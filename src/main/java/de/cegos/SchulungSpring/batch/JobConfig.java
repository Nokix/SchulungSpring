package de.cegos.SchulungSpring.batch;

import de.cegos.SchulungSpring.rest.model.Student;
import de.cegos.SchulungSpring.rest.repo.StudentRepository;
import de.cegos.SchulungSpring.rest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;
import java.util.stream.Stream;

@Configuration
@RequiredArgsConstructor
@Order(2)
public class JobConfig {

    final JobRepository jobRepository;
    final PlatformTransactionManager transactionManager;

    @Bean
    Job firstJob() {
        Tasklet tasklet = (contribution, chunkContext) -> {
            System.out.println("Hallo Welt! Endlich bin ich da, puh...");
            return RepeatStatus.FINISHED;
        };

        Step step = new StepBuilder("Simple Step", jobRepository)
                .tasklet(tasklet, transactionManager)
                .build();

        return new JobBuilder("My First Job", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    @Primary
    Job getSingleStepJob(Step step) {
        return new JobBuilder("My Job", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    Step getListSouterStep() {
        ChunkListener listener = new ChunkListener() {
            @Override
            public void beforeChunk(ChunkContext context) {
                System.out.println("New Chunk is starting");
            }
        };

        List<String> input = List.of("a", "b", "c", "d", "e", "f", "g");

        return new StepBuilder("Sout List on Console", jobRepository)
                .<String, String>chunk(3, transactionManager)
                .listener(listener)
                .reader(new ListItemReader<>(input))
                .processor(String::toUpperCase)
                .writer(chunk -> chunk.forEach(System.out::println))
                .build();
    }

    @Bean
    @Primary
    Step writeRandomStudentsToDatabase(
            StudentService studentService,
            StudentRepository studentRepository
    ) {
        Iterable<Student> students = Stream
                .generate(studentService::createRandomStudent)
                .limit(100)
                .toList();

        RepositoryItemWriter<Student> writer =
                new RepositoryItemWriter<>();

        writer.setRepository(studentRepository);

        return new StepBuilder("Data Generator Step", jobRepository)
                .<Student, Student>chunk(10, transactionManager)
                .reader(new IteratorItemReader<>(students))
                .writer(writer)
                .build();
    }


}

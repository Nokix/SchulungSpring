package de.cegos.SchulungSpring.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

@Configuration
@RequiredArgsConstructor
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
        List<String> input = List.of("a", "b", "c", "d", "e", "f", "g");

        return new StepBuilder("Sout List on Console", jobRepository)
                .<String, String>chunk(3, transactionManager)
                .reader(new ListItemReader<>(input))
                .processor(String::toUpperCase)
                .writer(chunk -> chunk.forEach(System.out::println))
                .build();
    }


}

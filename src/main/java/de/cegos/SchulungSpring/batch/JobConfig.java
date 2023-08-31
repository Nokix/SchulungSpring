package de.cegos.SchulungSpring.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

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
}

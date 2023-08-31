package de.cegos.SchulungSpring.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JobStarter implements CommandLineRunner {

    JobLauncher jobLauncher;
    Job job;

    public JobStarter(JobLauncher jobLauncher, Job job) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    @Override
    public void run(String... args) throws Exception {
        jobLauncher.run(job, jobParameters());
    }

    private JobParameters jobParameters() {
        return new JobParametersBuilder()
                //.addLong("startAt", System.currentTimeMillis())
                .addLong("startAt", 1693486150419L)
                .toJobParameters();
    }
}

package com.springweb.example.batch.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class batchLogTest {

    private static Logger log = LoggerFactory.getLogger(batchLogTest.class);

    @Bean
    public Job logTest(JobRepository jobRepository, Step step1) {
        return new JobBuilder("logTest", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step1)
                .build();
    }
    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step1", jobRepository)
                .tasklet((contribution, chunkContext) -> {
                    log.info(">>>>>   Batch 프로그램을 통해 로그 출력 성공   <<<<<");

                    return RepeatStatus.FINISHED;
                }).transactionManager(transactionManager)
                .build();
    }

}

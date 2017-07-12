package com.muatik.model;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by muatik on 7/12/17.
 */
@Configuration
@EnableBatchProcessing
public class Job1 {
    private JobBuilderFactory jobBuilderFactory;
    private Step step1;

    public Job1(JobBuilderFactory jobBuilderFactory, Step step1) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.step1 = step1;
    }

    @Bean
    public Job job() {
        return jobBuilderFactory.get("job1")
                .incrementer(new RunIdIncrementer())
                .flow(step1)
                .end()
                .build();
    }
}

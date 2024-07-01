package com.teste.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class MigracaoRenovacaoIntegracaoJobConfig {

    private final JobBuilderFactory jobBuilderFactory;

    public MigracaoRenovacaoIntegracaoJobConfig(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job migracaoRenovacaoJob(Step migracaoRenovacaoIntegracaoStep) throws Exception {
        return jobBuilderFactory.get("migracaoRenovacaoJob")
                .incrementer(new RunIdIncrementer())
                .flow(migracaoRenovacaoIntegracaoStep)
                .end()
                .build();
    }

}

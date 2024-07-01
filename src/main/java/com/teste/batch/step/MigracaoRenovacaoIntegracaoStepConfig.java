package com.teste.batch.step;

import com.amazonaws.services.s3.model.S3Object;
import com.teste.batch.model.Relatorio;
import com.teste.batch.step.processor.MigracaoRenovacaoIntegracaoProcessor;
import com.teste.batch.step.reader.MigracaoRenovacaoIntegracaoReader;
import com.teste.batch.step.writer.MigracaoRenovacaoIntegracaoWriter;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MigracaoRenovacaoIntegracaoStepConfig {

    private final StepBuilderFactory stepBuilderFactory;

    public MigracaoRenovacaoIntegracaoStepConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Step migracaoRenovacaoIntegracaoStep(
            MigracaoRenovacaoIntegracaoReader reader,
            MigracaoRenovacaoIntegracaoProcessor processor,
            MigracaoRenovacaoIntegracaoWriter writer
    ) {
        return stepBuilderFactory
                .get("migracaoRenovacaoIntegracaoStep")
                .<S3Object, List<Relatorio>>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}

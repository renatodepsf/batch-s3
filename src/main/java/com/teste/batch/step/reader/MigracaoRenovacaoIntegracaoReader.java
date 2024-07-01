package com.teste.batch.step.reader;

import com.amazonaws.services.s3.model.S3Object;

import com.teste.batch.config.CustomConfig;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class MigracaoRenovacaoIntegracaoReader implements ItemReader<S3Object> {

    private final CustomConfig s3Client;


    public MigracaoRenovacaoIntegracaoReader(CustomConfig s3Client) {
        this.s3Client = s3Client;
    }

    @Override
    public S3Object read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return s3Client.getConteudoObjeto();
    }
}

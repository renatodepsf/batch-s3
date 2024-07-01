package com.teste.batch.step.processor;

import com.amazonaws.services.s3.model.S3Object;
import com.teste.batch.model.Relatorio;
import com.teste.batch.util.Utils;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MigracaoRenovacaoIntegracaoProcessor implements ItemProcessor<S3Object, List<Relatorio>> {

    private final Utils utils;

    public MigracaoRenovacaoIntegracaoProcessor(Utils utils) {
        this.utils = utils;
    }

    @Override
    public List<Relatorio> process(S3Object objeto) throws Exception {
        List<Object> objects = utils.csvParaObjeto(Relatorio.class, objeto);
        List<Relatorio> relatorios = new ArrayList<>();
        for (Object obj : objects) {
            relatorios.add((Relatorio) obj);
        }
        return relatorios;
    }
}

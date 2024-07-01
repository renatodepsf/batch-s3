package com.teste.batch.step.writer;

import com.teste.batch.model.Relatorio;
import com.teste.batch.service.RelatorioServiceImpl;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MigracaoRenovacaoIntegracaoWriter implements ItemWriter<List<Relatorio>> {

    private final RelatorioServiceImpl relatorioService;

    public MigracaoRenovacaoIntegracaoWriter(RelatorioServiceImpl relatorioService) {
        this.relatorioService = relatorioService;
    }

    @Override
    public void write(List<? extends List<Relatorio>> list) throws Exception {
        for (List<Relatorio> relatorios : list) {
            relatorioService.salvarRelatorio(relatorios);
        }
    }
}

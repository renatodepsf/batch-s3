package com.teste.batch.service;

import com.teste.batch.model.Relatorio;
import com.teste.batch.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioServiceImpl {

    @Autowired
    private RelatorioRepository relatorioRepository;

    public void salvarRelatorio(List<Relatorio> relatorios) {
        relatorioRepository.salvarRelatorio(relatorios);
    }
}

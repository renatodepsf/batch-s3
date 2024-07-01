package com.teste.batch.repository;

import com.teste.batch.model.Relatorio;

import java.util.List;

public interface RelatorioRepository {

    void salvarRelatorio(List<Relatorio> relatorios);
}

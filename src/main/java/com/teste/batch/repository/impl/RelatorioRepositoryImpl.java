package com.teste.batch.repository.impl;

import com.teste.batch.model.Relatorio;
import com.teste.batch.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@PropertySource("classpath:query/relatorio-migracao.properties")
@Repository
public class RelatorioRepositoryImpl implements RelatorioRepository {

    @Value("${SPI.RELATORIO}")
    private String queryInsertRelatorio;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplateDataSource;

    @Override
    public void salvarRelatorio(List<Relatorio> relatorios) {
        Map<String, Object> map = new HashMap<>();

        for (Relatorio dado : relatorios) {
            map.put("dataHora", dado.getData_hora());
            map.put("localizadorCotacao", dado.getLocalizadorCotacao());
            map.put("statusComunicacao", dado.getStatusComunicacao());
            map.put("cdStatusRenovacao", dado.getCdStatusRenovacao());
            map.put("evento", dado.getEvento());
            map.put("tentativas", dado.getTentativas());
        }
        namedParameterJdbcTemplateDataSource.update(queryInsertRelatorio, map);
    }
}

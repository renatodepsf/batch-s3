package com.teste.batch.model;

public class Relatorio {

    private String data_hora;
    private String localizadorCotacao;
    private String statusComunicacao;
    private String cdStatusRenovacao;
    private String evento;
    private String tentativas;

    public Relatorio() {
    }

    public Relatorio(String data_hora, String localizadorCotacao, String statusComunicacao, String cdStatusRenovacao, String evento, String tentativas) {
        this.data_hora = data_hora;
        this.localizadorCotacao = localizadorCotacao;
        this.statusComunicacao = statusComunicacao;
        this.cdStatusRenovacao = cdStatusRenovacao;
        this.evento = evento;
        this.tentativas = tentativas;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public String getLocalizadorCotacao() {
        return localizadorCotacao;
    }

    public void setLocalizadorCotacao(String localizadorCotacao) {
        this.localizadorCotacao = localizadorCotacao;
    }

    public String getStatusComunicacao() {
        return statusComunicacao;
    }

    public void setStatusComunicacao(String statusComunicacao) {
        this.statusComunicacao = statusComunicacao;
    }

    public String getCdStatusRenovacao() {
        return cdStatusRenovacao;
    }

    public void setCdStatusRenovacao(String cdStatusRenovacao) {
        this.cdStatusRenovacao = cdStatusRenovacao;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getTentativas() {
        return tentativas;
    }

    public void setTentativas(String tentativas) {
        this.tentativas = tentativas;
    }
}

package org.foryou.bancoforyou.Transations;

import java.util.Date;

public class TransacoesMinDTO{
    
    protected Long idTransacao;

    protected Double valor;

    protected Date dataTransacao;

    protected String nomeReceptante;

    public TransacoesMinDTO(){}

    public TransacoesMinDTO(Transacoes entity){
        nomeReceptante = entity.getNomeReceptante();
        dataTransacao = entity.getDataTransacao();
    }

    public Long getIdTransacao(){
        return idTransacao;
    }

    public Double getValor(){
        return valor;
    }

    public String getNomeReceptante(){
        return nomeReceptante;   
    }

    public Date getDataTransacao(){
        return dataTransacao;
    }
}

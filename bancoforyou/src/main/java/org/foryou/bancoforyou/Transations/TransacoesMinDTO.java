package org.foryou.bancoforyou.Transations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class TransacoesMinDTO{
    
    protected Long idTransacao;

    protected BigDecimal valor;

    protected LocalDate dataTransacao;

    protected String nomeReceptante;

    public TransacoesMinDTO(){}

    public TransacoesMinDTO(Transacoes entity){
        nomeReceptante = entity.getNomeReceptante();
        dataTransacao = entity.getDataTransacao();
    }

    public Long getIdTransacao(){
        return idTransacao;
    }

    public BigDecimal getValor(){
        return valor;
    }

    public String getNomeReceptante(){
        return nomeReceptante;   
    }

    public LocalDate getDataTransacao(){
        return dataTransacao;
    }
}

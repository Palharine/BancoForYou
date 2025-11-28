package org.foryou.bancoforyou.Extrato;

import java.util.Date;

import org.foryou.bancoforyou.Transations.Transacoes;

import java.math.BigDecimal;
import java.time.LocalDate;
public class Extrato{

    protected Long idTransacao;

    protected BigDecimal valor;
    
    protected String nomeReceptante;
    
    protected int idadeReceptante;
    
    protected LocalDate dataTransacao;
    
    protected String formaPagamento;
    
    protected String tipoConta;
    
    protected String cpfReceptante;
    
    protected String bancoReceptante;

    protected String cnpjReceptante;

    public Extrato(){}

    public Extrato(Transacoes entity){
        nomeReceptante = entity.getNomeReceptante();
        cpfReceptante = entity.getCpfReceptante();
        bancoReceptante = entity.getBancoReceptante();
        cnpjReceptante = entity.getCNPJReceptante();
        dataTransacao = entity.getDataTransacao();
        formaPagamento = entity.getFormaPagamento();
        tipoConta = entity.getTipoConta();
        idTransacao = entity.getIdTransacao();
        valor = entity.getValor();
    }

    //protected Long idTransacao;
    public Long getIdTransacao(){
        return idTransacao;
    }

    //protected String cpfReceptante;
    public String getCpfReceptante(){
        return cpfReceptante;
    }
    //protected String bancoReceptante;
    public String getBancoReceptante(){
        return bancoReceptante;
    }
    //protected String cnpjReceptante;
    public String getCNPJReceptante(){
        return cnpjReceptante;
    }
    //protected Date dataTransacao;
    public LocalDate getDataTransacao(){
        return dataTransacao;
    }

    //protected String formaPagamento;
    public String getFormaPagamento(){
        return formaPagamento;
    }

    //protected String tipoConta;
    public String getTipoConta(){
        return tipoConta;
    }

    //protected BigDecimal valor;
    public BigDecimal getValor(){
        return valor;
    }

    //protected String nomeReceptante;
    public String getNomeReceptante(){
        return nomeReceptante;
    }
    
    //protected int idadeReceptante;
    public int getIdadeReceptante(){
        return idadeReceptante;
    }
    }   


package org.foryou.bancoforyou.Extrato;

import java.util.Date;
import java.math.BigDecimal;
public class Extrato{
        
public class Transacoes{    

    @Id
    protected Long idTransacao;

    protected BigDecimal valor;
    
    protected String nomeReceptante;
    
    protected int idadeReceptante;
    
    protected Date dataTransacao;
    
    protected String formaPagamento;
    
    protected String tipoConta;
    
    protected String cpfReceptante;
    
    protected String bancoReceptante;

    protected String cnpjReceptante;

    pulbic Extrato(){}

    public Extrato(Transacoes entity){
        nomeReceptante = entity.getName();
        cpfReceptante = entity.getCPF();
        bancoReceptante = entity.getNomeBanco();
        cnpjReceptante = entity.getCNPJ();
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
    public Strig getBancoReceptante(){
        return bancoReceptante;
    }
    //protected String cnpjReceptante;
    public String getCNPJReceptante(){
        return cnpjReceptante;
    }
    //protected Date dataTransacao;
    public Date getDataTransacao(){
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
        retun nomeReceptante;
    }
    
    //protected int idadeReceptante;
    public int getIdadeReceptante(){
        return idadeReceptante;
    }
    }   
}

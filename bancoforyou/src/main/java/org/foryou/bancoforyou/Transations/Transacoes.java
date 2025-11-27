package org.foryou.bancoforyou.Transations;

import java.math.BigDecimal;
import java.util.Date;

import org.foryou.bancoforyou.User.Usuarios;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table( name = "teste")
public class Transacoes{    

    @Id
    @Column (name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idTransacao;

    @Column (name = "Valor", nullable = false)
    protected BigDecimal valor;
    
    @Column (name = "idPagante", nullable = false)
    protected Long idPagante;
    
    @Column (name = "idReceptante", nullable = false)
    protected Long idReceptante;
    
    @Column (name = "nomeReceptante", nullable = false)
    protected String nomeReceptante;
    
    @Column (name = "idadeReceptante")
    protected int idadeReceptante;
    
    @Column (name = "dataTransacao")
    protected Date dataTransacao;
    
    @Column (name = "formaPagamento", nullable = false)
    protected String formaPagamento;
    
    @Column (name = "tipoConta", nullable = false)
    protected String tipoConta;
    
    @Column (name = "cpfReceptante", nullable = false)
    protected String cpfReceptante;
    
    @Column (name = "bancoReceptante", nullable = false)
    protected String bancoReceptante;

    @Column (name = "CNPJ")
    protected String cnpjReceptante;


    public Transacoes(){}

    public Transacoes(Usuarios receptante,Usuarios pagante){
        idPagante = pagante.getId();
        idReceptante = receptante.getId();
        nomeReceptante = receptante.getName();
        idadeReceptante = receptante.getIdade();
        cpfReceptante = receptante.getCPF();
        bancoReceptante = receptante.getNomeBanco();
        cnpjReceptante = receptante.getCNPJ();
    }

    public Long getIdTransacao(){
        return idTransacao;
   }

    public BigDecimal getValor(){
        return valor;
    }

    public Long getIdPagante(){
        return idPagante;
    }

    public Long getIdReceptante(){
        return idReceptante;
    }

    public String getNomeReceptante(){
        return nomeReceptante;   
    }

    public int getIdadeReceptante(){
        return idadeReceptante;
    }

    public Date getDataTransacao(){
        return dataTransacao;
    }
    
    public String getFormaPagamento(){
        return formaPagamento;
    }

    public String getTipoConta(){
        return tipoConta;
    }

    public String getCpfReceptante(){
        return cpfReceptante;
    }

    public String getBancoReceptante(){
        return bancoReceptante;
    }

    public String getCNPJReceptante(){
        return cnpjReceptante;
    }

    public void setIdTransacao(Long idTransacao){
        this.idTransacao = idTransacao;
    }

    public void setValor(BigDecimal valor){
        this.valor = valor;
    }

    public void setIdPagante(Long idPagante){
        this.idPagante = idPagante;
    }

    public void setIdReceptante(Long idReceptante){
        this.idReceptante = idReceptante;
    }

    public void setNomeReceptante(String nomeReceptante){
        this.nomeReceptante = nomeReceptante;
    }

    public void setIdadeReceptante(int idadeReceptante){
        this.idadeReceptante = idadeReceptante;
    }

    public void setDataTransacao(Date dataTransacao){
            this.dataTransacao = dataTransacao;
    }

    public void setFormaPagamento(String formaPagamento){
        this.formaPagamento = formaPagamento;
    }

    public void setTipoConta(String tipoConta){
        this.tipoConta = tipoConta;
    }

    public void setCpfReceptante(String cpfReceptante){
        this.cpfReceptante = cpfReceptante;
    }
    public void getBancoReceptante(String bancoReceptante){
        this.bancoReceptante = bancoReceptante;
    }

    public void getCNPJReceptante(String cnpjReceptante){
        this.cnpjReceptante = cnpjReceptante;
    }

   
}

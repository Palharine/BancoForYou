package org.foryou.bancoforyou.Transations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class TransacoesMinDTO {

    protected Long idTransacao;

    protected BigDecimal valor;

    protected LocalDate dataTransacao;

    protected String nomeReceptante;

    protected int idadeReceptante;

    protected String formaPagamento;

    protected String tipoConta;

    protected String cpfReceptante;

    protected String bancoReceptante;

    protected String cnpjReceptante;

    public TransacoesMinDTO() {
    }

    public TransacoesMinDTO(Transacoes entity) {
        nomeReceptante = entity.getNomeReceptante();
        dataTransacao = entity.getDataTransacao();
        valor = entity.getValor();
        idadeReceptante = entity.getIdadeReceptante();
        formaPagamento = entity.getFormaPagamento();
        tipoConta = entity.getTipoConta();
        cpfReceptante = entity.getCpfReceptante();
        bancoReceptante = entity.getBancoReceptante();
    }

    public Long getIdTransacao() {
        return idTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getNomeReceptante() {
        return nomeReceptante;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public int getIdadeReceptante() {
        return idadeReceptante;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public String getCpfReceptante() {
        return cpfReceptante;
    }

    public String getBancoReceptante() {
        return bancoReceptante;
    }

    public String getCNPJReceptante() {
        return cnpjReceptante;
    }
}

package org.foryou.bancoforyou.Transations;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
@Service
public interface TransacoesService{
    
    public List<TransacoesMinDTO> getTransacoesByDate(Date dataTransacao);
    public List<TransacoesMinDTO> getTransacoesByReceptante(String nomeReceptante);
    public List<TransacoesMinDTO> findAll();
    public Transacoes transferencia( BigDecimal valor, String formaPagamento, String tipoConta, String chave, Date data, ObjectId paganteId, ObjectId receptanteId);  
}

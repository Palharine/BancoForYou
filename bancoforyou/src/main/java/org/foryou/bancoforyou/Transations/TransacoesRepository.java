package org.foryou.bancoforyou.Transations;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface TransacoesRepository extends JpaRepository<TransacoesMinDTO, Long>{
    public List<TransacoesMinDTO> getTransacoesByDate(Date dataTransacoes);
    public List<TransacoesMinDTO> getTransacoesByReceptante(String nomeReceptante);
    public Transacoes transferencia( BigDecimal valor,  String formaPagamento, String tipoConta, String chave, Date data);
    public Transacoes saveTransferencia(BigDecimal valor,  String formaPagamento, String tipoConta, String chave, Date data);
}

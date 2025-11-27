package org.foryou.bancoforyou.Transations;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacoesRepository extends JpaRepository<TransacoesMinDTO, Long>{
    @Query(nativeQuery = true, value = "
        SELECT transacoes.id, transacoes.
    public List<TransacoesMinDTO> getTransacoesByDate(Date dataTransacoes);
    public List<TransacoesMinDTO> getTransacoesByReceptante(String nomeReceptante);
    
}

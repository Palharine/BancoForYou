package org.foryou.bancoforyou.Transations;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface TransacoesService{
    
    public List<TransacoesMinDTO> getTransacoesByDate(Date dataTransacao);
    public List<TransacoesMinDTO> getTransacoesByReceptante(String nomeReceptante);
    public List<TransacoesMinDTO> findAll();
}

package org.foryou.bancoforyou.Transations;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.transaction.Transactional;

public class TransacoesServiceImpl implements TransacoesService{
    
    @Autowired
    TransacoesRepository transacoesRepository;

    @Transactional(readOnly = true)
    public List<TransacoesMinDTO> getTransacoesByDate(Date dataTransacoes){
        List<TransacoesMinDTO> result = transacoesRepository.getTransacoesByDate(dataTransacoes);
        return result;
    }

    @Transactional(readOnly = true)
    public List<TransacoesMinDTO> getTransacoesByReceptante(String nomeReceptante){
        List<TransacoesMinDTO> result = transacoesRepository.getTransacoesByReceptante(nomeReceptante);
        return result;
    }

    @Transactional(readOnly = true)
    public List<TransacoesMinDTO> findAll(){
        List<TransacoesMinDTO> result = transacoesRepository.findAll();
        return result;
    }
}

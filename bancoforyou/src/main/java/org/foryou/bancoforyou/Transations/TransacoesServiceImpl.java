package org.foryou.bancoforyou.Transations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.foryou.bancoforyou.User.UserMinDTO;
import org.foryou.bancoforyou.User.UserRepository;
import org.foryou.bancoforyou.User.UserService;
import org.foryou.bancoforyou.User.UserServiceImpl;
import org.foryou.bancoforyou.User.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.transaction.Transactional;

public class TransacoesServiceImpl implements TransacoesService{
    
    @Autowired
    TransacoesRepository transacoesRepository;

    @Transactional
    public List<TransacoesMinDTO> getTransacoesByDate(Date dataTransacoes){
        List<TransacoesMinDTO> result = transacoesRepository.getTransacoesByDate(dataTransacoes);
        return result;
    }

    @Transactional
    public List<TransacoesMinDTO> getTransacoesByReceptante(String nomeReceptante){
        List<TransacoesMinDTO> result = transacoesRepository.getTransacoesByReceptante(nomeReceptante);
        return result;
    }

    @Transactional
    public List<TransacoesMinDTO> findAll(){
        List<TransacoesMinDTO> result = transacoesRepository.findAll();
        return result;
    }
    
   
    public Transacoes transferencia(  BigDecimal valor, String formaPagamento, String tipoConta, String chave, Date data, ObjectId paganteId, ObjectId receptanteId){    
        
        Transacoes t = new Transacoes();
        
        UserServiceImpl user =new UserServiceImpl();
        
        t.setDataTransacao(LocalDate.now());
        
        user.pagar(paganteId,receptanteId, chave, valor);

        return t;
    }


    
}

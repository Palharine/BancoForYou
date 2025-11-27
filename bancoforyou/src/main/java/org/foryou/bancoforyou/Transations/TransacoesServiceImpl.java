package org.foryou.bancoforyou.Transations;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.foryou.bancoforyou.User.UserMinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

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
    
   
    public Transacoes transferencia(  BigDecimal valor, String formaPagamento, String tipoConta, String chave, Date data, ObjectId paganteId, ObjectId receptanteId){    
        
        Transacao t = new Transacao();

        UserRepository user = new UserRepository();
        
        t.setData(LocalDate.now());
        
        UserMinDTO pagamento = user.pagar(paganteId,receptanteId, chave, valor);
    }


    
}

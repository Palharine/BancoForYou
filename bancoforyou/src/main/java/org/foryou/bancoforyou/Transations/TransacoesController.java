package org.foryou.bancoforyou.Transations;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transacoes")
public class TransacoesController{

    @Autowired
    private TransacoesService transacoesService;


    @GetMapping()
    public ResponseEntity<List<TransacoesMinDTO>> getTransacoesByDate(Date dataTransacao){
        List<TransacoesMinDTO> getTransacoesByDate = transacoesService.getTransacoesByDate(dataTransacao);
        return new ResponseEntity<>(getTransacoesByDate,HttpStatus.FOUND);
    }
    
    @GetMapping()
        public ResponseEntity<List<TransacoesMinDTO>> getTransacoesByReceptante(String nomeReceptante){
        List<TransacoesMinDTO> getTransacoesByReceptante = transacoesService.getTransacoesByReceptante(nomeReceptante);
  
        return new ResponseEntity<>(getTransacoesByReceptante,HttpStatus.FOUND);
    }
    
    @GetMapping()
    public List<TransacoesMinDTO> findAll(){
        List<TransacoesMinDTO> result= transacoesService.findAll();
        return result;
    }



}

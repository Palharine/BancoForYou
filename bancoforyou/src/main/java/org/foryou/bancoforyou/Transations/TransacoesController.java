package org.foryou.bancoforyou.Transations;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.bson.types.ObjectId;
import org.foryou.bancoforyou.Extrato.ExtratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/transacoes")
public class TransacoesController{

    @Autowired
    private TransacoesService transacoesService;
    @Autowired
    private ExtratoService extratosService;

    @GetMapping(value = "/{dataTransacao}")
    public ResponseEntity<List<TransacoesMinDTO>> getTransacoesByDate(Date dataTransacao){
        List<TransacoesMinDTO> getTransacoesByDate = transacoesService.getTransacoesByDate(dataTransacao);
        return new ResponseEntity<>(getTransacoesByDate,HttpStatus.FOUND);
    }
    
    @GetMapping(value = "/{nomeReceptante}")
        public ResponseEntity<List<TransacoesMinDTO>> getTransacoesByReceptante(String nomeReceptante){
        List<TransacoesMinDTO> getTransacoesByReceptante = transacoesService.getTransacoesByReceptante(nomeReceptante);
  
        return new ResponseEntity<>(getTransacoesByReceptante,HttpStatus.FOUND);
    }
    
    @GetMapping()
    public List<TransacoesMinDTO> findAll(){
        List<TransacoesMinDTO> result= transacoesService.findAll();
        return result;
    }

    @PostMapping(value = "/transferencia")  
    public Transacoes transferencia( @RequestParam BigDecimal valor, @RequestParam String formaPagamento, @RequestParam String tipoConta, @RequestParam String chave, @RequestParam Date data, @RequestParam ObjectId paganteId, @RequestParam ObjectId receptanteId){    
        Transacoes result = transacoesService.transferencia(valor, formaPagamento, tipoConta, chave, data, paganteId, receptanteId);
        return result;
    }
    @PostMapping(value = "/transferencia/extratos")
    public void downloadExcel(HttpServletResponse response) throws Exception{
        Workbook workbook = extratosService.gerarExtratoExcel();

        response.setHeader("Content-Disposition", "attachment; filename=extrato.xlsx");
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        workbook.write(response.getOutputStream());
        workbook.close();
    }

}

package org.foryou.bancoforyou.Extrato;

import org.springframework.beans.factory.annotation.Autowired;
import org.foryou.bancoforyou.Transations.TransacoesRepository;
import org.foryou.bancoforyou.Transations.TransacoesService;
import org.foryou.bancoforyou.Transations.Transacoes;
import org.foryou.bancoforyou.Transations.TransacoesMinDTO;
import org.foryou.bancoforyou.Transations.TransacoesProjection;

import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExtratoService {

    @Autowired
    TransacoesRepository transacaoRepository;

    public Workbook gerarExtratoExcel() {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Extrato");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Data");
        header.createCell(1).setCellValue("Valor");
        header.createCell(2).setCellValue("Nome do Receptante");
        header.createCell(3).setCellValue("Idade do Receptante");
        header.createCell(4).setCellValue("Forma de Pagamento");
        header.createCell(5).setCellValue("Tipo da Conta");
        header.createCell(6).setCellValue("CPF do Receptante");
        header.createCell(7).setCellValue("Banco Receptante");
        header.createCell(8).setCellValue("CNPJ do Receptante");

        List<TransacoesMinDTO> transacoes = transacaoRepository.findAll();
        int rowIndex = 1;

        for (TransacoesMinDTO t : transacoes) {
            Row row = sheet.createRow(rowIndex++);

            row.createCell(0).setCellValue(t.getDataTransacao().toString());
            row.createCell(1).setCellValue(t.getValor().doubleValue());
            row.createCell(2).setCellValue(t.getNomeReceptante());
            row.createCell(3).setCellValue(t.getIdadeReceptante());
            row.createCell(4).setCellValue(t.getFormaPagamento());
            row.createCell(5).setCellValue(t.getTipoConta());
            row.createCell(6).setCellValue(t.getCpfReceptante());
            row.createCell(7).setCellValue(t.getBancoReceptante());
            row.createCell(8).setCellValue(t.getCNPJReceptante());
        }

        return workbook;
    }
}

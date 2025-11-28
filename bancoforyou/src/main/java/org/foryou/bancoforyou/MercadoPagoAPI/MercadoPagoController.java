package org.foryou.bancoforyou.MercadoPagoAPI;

import org.foryou.bancoforyou.MercadoPagoAPI.CreatePaymentPreferenceService;
import org.foryou.bancoforyou.MercadoPagoAPI.CreatePreferenceResponseDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/pagamentos")
@Slf4j
public class MercadoPagoController{
    
    private createPaymentPreferenceService createPaymentPreferenceService;
    @PostMapping()   
    public ResponseEntity<CreateResponseDTO> createPreference(@Valid @RequestBody CreateReferenceRequestDTO request){

        try{    
            CreatePreferenceResponseDTO response = createPaymentPreferenceService.createPreference(request);
            createPaymentPreferenceService.createPreference(request);

            return ResponseEntity.ok();
        } catch(Exception e){
            log.error("Error Creating Payment Preference: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

}

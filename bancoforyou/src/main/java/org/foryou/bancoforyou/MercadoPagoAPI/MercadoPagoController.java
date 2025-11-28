package org.foryou.bancoforyou.MercadoPagoAPI;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/pagamentos")
@RequiredArgsConstructor
public class MercadoPagoController {

    private static final Logger log = LoggerFactory.getLogger(MercadoPagoController.class);

    private CreatePaymentPreferenceService createPaymentPreferenceService;

    @PostMapping
   public ResponseEntity<CreatePreferenceResponseDTO> createPreference(
        @Validated @RequestBody CreatePreferenceRequestDTO request) {

        try {
            CreatePreferenceResponseDTO response = createPaymentPreferenceService.createPreference(request);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            log.error("Error Creating Payment Preference: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }
}


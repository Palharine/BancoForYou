package org.foryou.bancoforyou.MercadoPagoAPI;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.foryou.bancoforyou.MercadoPagoAPI.CreatePreferenceRequestDTO;
import org.foryou.bancoforyou.MercadoPagoAPI.CreatePreferenceResponseDTO;

import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;

import java.util.UUID;

@Service
public class CreatePaymentPreferenceService {

    private static final Logger log =
            LoggerFactory.getLogger(CreatePaymentPreferenceService.class);

    private final MercadoPagoClient mercadoPagoClient;

    public CreatePaymentPreferenceService(MercadoPagoClient mercadoPagoClient) {
        this.mercadoPagoClient = mercadoPagoClient;
    }

    public CreatePreferenceResponseDTO createPreference(CreatePreferenceRequestDTO inputData) {
        log.info("Creating payment preference with request: {}", inputData);

        String orderNumber = UUID.randomUUID().toString();

        try {
            return mercadoPagoClient.createPreference(inputData, orderNumber);

        } catch (MPApiException | MPException e) {
            log.error("Error creating Mercado Pago preference: {}", e.getMessage(), e);
            throw new RuntimeException("Erro ao criar preferência no Mercado Pago", e);
        }
    }
}

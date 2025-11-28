package org.foryou.bancoforyou.MercadoPagoAPI;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferencePayerRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;

import lombok.extern.slf4j.Slf4j;

import org.foryou.bancoforyou.MercadoPagoAPI.CreatePreferenceRequestDTO;
import org.foryou.bancoforyou.MercadoPagoAPI.CreatePreferenceResponseDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class MercadoPagoClient {

    private static final Logger log =
            LoggerFactory.getLogger(MercadoPagoClient.class);
    @Value("${mercadopago-access-token}")
    private String accessToken;

    @Value("${mercadopago-notification-url}")
    private String notificationUrl;

    @PostConstruct
    public void init() {
        MercadoPagoConfig.setAccessToken(accessToken);
        log.info("MercadoPago initialized");
    }

    public CreatePreferenceResponseDTO createPreference(CreatePreferenceRequestDTO inputData, String orderNumber)
            throws MPException, MPApiException {

        log.info("Criando preferência com os dados: {}", inputData);

        try {
            PreferenceClient client = new PreferenceClient();

            // Payer
            PreferencePayerRequest payer = PreferencePayerRequest.builder()
                    .name(inputData.getPayer().getName())
                    .email(inputData.getPayer().getEmail())
                    .build();

            // Item
            PreferenceItemRequest item = PreferenceItemRequest.builder()
                    .title(inputData.getItem().getTitle())
                    .quantity(inputData.getItem().getQuantity())
                    .unitPrice(new java.math.BigDecimal(inputData.getItem().getPrice()))                    
                    .build();

            // Back URLs
            PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest.builder()
                    .success(inputData.getBackUrls().getSuccess())
                    .pending(inputData.getBackUrls().getPending())
                    .failure(inputData.getBackUrls().getFailure())
                    .build();

            // Final Request
            PreferenceRequest request = PreferenceRequest.builder()
                    .payer(payer)
                    .items(java.util.List.of(item))
                    .backUrls(backUrls)
                    .notificationUrl(notificationUrl)
                    .externalReference(orderNumber)
                    .autoReturn("approved")
                    .build();

            // Chamada ao MP
            Preference preference = client.create(request);

            CreatePreferenceResponseDTO response = new CreatePreferenceResponseDTO();
                response.setId(preference.getId());
                response.setInitPoint(preference.getInitPoint());
                response.setExternalReference(preference.getExternalReference());
            return response;
        } catch (Exception e) {
            log.error("Erro inesperado: {}", e.getMessage());
            throw new MPException("Erro inesperado", e);
        }
    }
}


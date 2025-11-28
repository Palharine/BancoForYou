package org.foryou.bancoforyou.MercadoPagoAPI;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferencePayerRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MercadoPagoClient{

    @Value("${mercadopago-access-token")
    private String acessToken;

    @Value("${mercadopago-notification-url}")
    private String notificationUrl;
    
    @PostConstruct
    public void init(){
        MercadoPagoConfig.setAccesToken(acessToken);
        log.info("Iniciaindo Mercado Pago");
    }

    public CreateResponseDTO createPreference(CreatePreferenceRequestDTO inputData, String orderNumber) throws MPException, 
           MPApiException{

               log.info("Criando Preferencia de pagamento no Mercado Pago com dados: {}", inputData);
            try{
        PreferenceClient preferenceClient = new PreferenceClient();

        PreferencePayerRequest payer = PreferencePayerRequest().builder()
            .name(inputData.payer().name())
            .email(inputData.payer().email())
            .build();


        PreferenceBackUrlsRequest backUrlsRequest = PreferenceBackUrlsRequest.builder()
            .success(inputData.backUrls().success())
            .failure(inputData.backUrls().failure())
            .pending(inputData.backUrls.pending())
            .build();

        PreferenceRequest preferenceRequest = new PreferenceRequest().builder()
            .payer(payer)
            .backUrls(backUrl)
            .notificationUrl(notificationUrl)
            .externalReference(orderNumber)
            .autoReturn("approved")
            .build();


            Preference preference = client.create(preferenceClient);
            log.info("Preferencia criada com sucesso no Mercado Pago: {} e {}", preference.getId(), preference.getInitPoint());
            return new CreateResponseDTO(
                    preference.getId(),
                    preference.getInitPoint()
                    );
    
                
            }catch(MPApiException e){
                log.error("Error ao criar preferencias no Mercado Pago na api: {}", e.getMessage());
                throw e;
            }catch(MPApiException e){
                log.error("Error ao criar preferencias no Mercado Pago: {}", e.getMessage());
                throw e;
            }catch(Exception e){
                log.error("Erro inesperado ao criar preferencias no Mercado Pago: {}", e.getMessage());
                throw new MPException("Erro inesperado ao criar a sua preferencia", e);
            }
    }    
}


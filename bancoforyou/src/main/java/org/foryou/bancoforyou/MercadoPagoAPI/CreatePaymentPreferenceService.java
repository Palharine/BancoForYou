package org.foryou.bancoforyou.MercadoPagoAPI;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import org.foryou.bancoforyou.MercadoPagoAPI.CreatePreferenceResponseDTO;
import org.foryou.bancoforyou.MercadoPagoAPI;

@Service
@Slf4j
public class CreatePaymentPreferenceService{

    private final MercadoPagoClient mercadoPagoClient;

    public CreatePaymentPreferenceService(MercadoPagoClient mercadoPagoClient){
        this.mercadoPagoClient = mercadoPagoClient;
    }

    public CreatePreferenceResponseDTO createPreference(CreatePreferenceRequestDTO inputData){
        log.info("Create payment preference with request: {}", inputData);


        String orderNumber = "123123123123123123";
        
    

    try{
        CreatePreferenceResponseDTO response = mercadoPagoClient.createPreference(inputData, orderNumber);
        return response;
    } catch (MPException e) {
        throw new RuntimeException(e);
    }catch(MPApiException e){
        throw new RuntimeException(e);
    }
    }
}



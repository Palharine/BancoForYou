package org.foryou.bancoforyou.MercadoPagoAPI;

import java.math.BigDecimal;
//import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

public record CreateReferenceRequestDTO(
    
         Long userId,
         
         
         BigDecimal valor,
         PayerDTO payer,
         @NotNull
         BackUrlsDTO backUrls,
         //DeliveryAddressDTO deliveryAddress,
         @NotNull
         String notificationURL
         //List<ItemDTO> itens,     
 ){


public record BackUrlsDTO(
        String succes,
        String failure,
        String pending
        ){}


}

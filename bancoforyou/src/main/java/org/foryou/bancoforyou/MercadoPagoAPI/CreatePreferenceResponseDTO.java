package org.foryou.bancoforyou.MercadoPagoAPI;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePreferenceResponseDTO {
    private String id;
    private String initPoint;
    private String externalReference;

    public String getId() {
        return id;
    }

    public String getInitPoint() {
        return initPoint;
    }

    public String getExternalReference() {
        return externalReference;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public void setInitPoint(String initPoint) {
        this.initPoint = initPoint;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }
}

package org.foryou.bancoforyou.MercadoPagoAPI;

public class BackUrlsDTO {

    private String success;
    private String failure;
    private String pending;

    public String getSuccess() {
        return success;
    }

    public String getFailure() {
        return failure;
    }

    public String getPending() {
        return pending;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public void setFailure(String failure) {
        this.failure = failure;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }
}


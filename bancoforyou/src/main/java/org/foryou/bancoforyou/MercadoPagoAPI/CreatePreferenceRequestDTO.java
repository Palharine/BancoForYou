package org.foryou.bancoforyou.MercadoPagoAPI;

public class CreatePreferenceRequestDTO {

    private PayerDTO payer;
    private ItemDTO item;
    private BackUrlsDTO backUrls;

    public PayerDTO getPayer() {
        return payer;
    }

    public ItemDTO getItem() {
        return item;
    }

    public BackUrlsDTO getBackUrls() {
        return backUrls;
    }

    public void setPayer(PayerDTO payer) {
        this.payer = payer;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    public void setBackUrls(BackUrlsDTO backUrls) {
        this.backUrls = backUrls;
    }
}

package org.foryou.bancoforyou.MercadoPagoAPI;

public class ItemDTO {

    private String title;
    private Integer quantity;
    private Double price;

    public ItemDTO() {}

    public ItemDTO(String title, Integer quantity, Double price) {
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}


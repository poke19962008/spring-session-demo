package com.example.springsession.dto;

/**
 * @author : sayan.das
 * @since : 2/22/21, Monday
 **/
public class ProductDTO {

    private String title;
    private boolean isInsStock;
    private String description;
    private int salePrice;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isInsStock() {
        return isInsStock;
    }

    public void setInsStock(boolean insStock) {
        isInsStock = insStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }
}

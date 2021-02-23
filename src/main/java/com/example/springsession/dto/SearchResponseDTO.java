package com.example.springsession.dto;

import java.util.List;

/**
 * @author : sayan.das
 * @since : 2/22/21, Monday
 **/
public class SearchResponseDTO {

    private List<ProductDTO> products;
    private List<ProductDTO> productLocation;


    public List<ProductDTO> getProductLocation() {
        return productLocation;
    }

    public void setProductLocation(List<ProductDTO> productLocation) {
        this.productLocation = productLocation;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}

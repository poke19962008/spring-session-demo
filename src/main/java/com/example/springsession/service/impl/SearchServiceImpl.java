package com.example.springsession.service.impl;

import com.example.springsession.dto.ProductDTO;
import com.example.springsession.dto.SearchRequestDTO;
import com.example.springsession.dto.SearchResponseDTO;
import com.example.springsession.service.SearchService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author : sayan.das
 * @since : 2/22/21, Monday
 **/
@Service
public class SearchServiceImpl implements SearchService {
    @Override
    public SearchResponseDTO getProducts(SearchRequestDTO request) {
        SearchResponseDTO responseDTO = new SearchResponseDTO();
        ProductDTO product  = new ProductDTO();
        product.setDescription("Samsung galaxy s5 ......");
        product.setTitle("Samsung galaxy s5");
        product.setInsStock(true);
        responseDTO.setProducts(Arrays.asList(product));
        return responseDTO;
    }
}

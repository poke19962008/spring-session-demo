package com.example.springsession.service.impl;

import com.example.springsession.client.SearchClient;
import com.example.springsession.constants.SolrFieldNames;
import com.example.springsession.dto.ProductDTO;
import com.example.springsession.dto.SearchRequestDTO;
import com.example.springsession.dto.SearchResponseDTO;
import com.example.springsession.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author : sayan.das
 * @since : 2/22/21, Monday
 **/
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SearchClient searchClient;

    @Override
    public SearchResponseDTO getProducts(SearchRequestDTO request) {

        Map<String, Object> productResponse = searchClient.getProducts(request.getSearchTerm());
        Map<String, Object> responseObject = (Map<String, Object>) (productResponse.get("response"));
        List<Map<String, Object>> products = (List<Map<String, Object>>) responseObject.get("docs");
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Map<String, Object> productClientResponse :products) {
            String title = (String) productClientResponse.get(SolrFieldNames.NAME);
            boolean inStock = (int) productClientResponse.get(SolrFieldNames.IN_STOCK) == 1? true: false;
            String description = (String) productClientResponse.get(SolrFieldNames.DESCRIPTION);

            ProductDTO productDTO = new ProductDTO();
            productDTO.setInsStock(inStock);
            productDTO.setTitle(title);
            productDTO.setDescription(description);

            productDTOS.add(productDTO);
        }
        SearchResponseDTO responseDTO = new SearchResponseDTO();
        responseDTO.setProducts(productDTOS);
        return responseDTO;
    }
}

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
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author : sayan.das
 * @since : 2/22/21, Monday
 **/
@Service
public class SearchServiceImpl implements SearchService {
    private  static final int POOL_SIZE = 2;

    @Autowired
    private SearchClient searchClient;

    @Override
    public SearchResponseDTO getProducts(SearchRequestDTO request) {

        SearchResponseDTO responseDTO = new SearchResponseDTO();
        ExecutorService threadPool = Executors.newFixedThreadPool(POOL_SIZE);

        threadPool.execute(() -> {
            String searchTermQuery = request.getSearchTerm();
            List<ProductDTO> productDTOS = getSearchTermBaseProducts(searchTermQuery);
            responseDTO.setProducts(productDTOS);
        });

        threadPool.execute(() -> {
            String locationQuery = SolrFieldNames.STOCK_LOCATION + ":\"" + request.getLocation() + "\"";
            List<ProductDTO> locationProductDTOs = getSearchTermBaseProducts(locationQuery);
            responseDTO.setProductLocation(locationProductDTOs);
        });

        awaitTerminationAfterShutdown(threadPool);
        return responseDTO;
    }

    private void awaitTerminationAfterShutdown(ExecutorService threadPool) {
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    private List<ProductDTO> getSearchTermBaseProducts(String query) {
        Map<String, Object> productResponse = searchClient.getProducts(query);
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
        return productDTOS;
    }
}

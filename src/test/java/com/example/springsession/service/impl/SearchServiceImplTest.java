package com.example.springsession.service.impl;

import com.example.springsession.client.SearchClient;
import com.example.springsession.dto.SearchRequestDTO;
import com.example.springsession.dto.SearchResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
class SearchServiceImplTest {

    @InjectMocks
    private SearchServiceImpl searchService;

    @Mock
    private SearchClient searchClient;

    @BeforeEach
    public void init () {
        MockitoAnnotations.openMocks(this);
    }


    @AfterEach
    public void teardown() {
        verifyNoMoreInteractions(searchClient);
    }

    @Test
    void getProducts() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> searchTermMockObject = objectMapper.readValue(
            new URL("file:src/test/resources/search.mock"), Map.class);

        Map<String, Object> locationMockObject = objectMapper.readValue(
            new URL("file:src/test/resources/location.mock"), Map.class);

        Mockito.when(searchClient.getProducts("samsung")).thenReturn(searchTermMockObject);
        Mockito.when(searchClient.getProducts("stockLocation:\"jakarta\""))
            .thenReturn(locationMockObject);

        SearchRequestDTO requestDTO = new SearchRequestDTO();
        requestDTO.setSearchTerm("samsung");
        requestDTO.setLocation("jakarta");
        SearchResponseDTO response = searchService.getProducts(requestDTO);

        assertEquals(response.getProducts().size(), 10);
        assertEquals(response.getProductLocation().size(), 10);

        Mockito.verify(searchClient).getProducts("samsung");
        Mockito.verify(searchClient).getProducts("stockLocation:\"jakarta\"");

    }

    @Test
    public void testGetProductsExceptionTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> searchTermMockObject = objectMapper.readValue(
            new URL("file:src/test/resources/search.mock"), Map.class);


        Mockito.when(searchClient.getProducts("samsung")).thenReturn(searchTermMockObject);
        Mockito.when(searchClient.getProducts("stockLocation:\"jakarta\""))
            .thenThrow(NullPointerException.class);

        SearchRequestDTO requestDTO = new SearchRequestDTO();
        requestDTO.setSearchTerm("samsung");
        requestDTO.setLocation("jakarta");
        SearchResponseDTO response = searchService.getProducts(requestDTO);

        assertEquals(response.getProducts().size(), 10);
        assertEquals(response.getProductLocation(), null);

        Mockito.verify(searchClient).getProducts("samsung");
        Mockito.verify(searchClient).getProducts("stockLocation:\"jakarta\"");
    }
}

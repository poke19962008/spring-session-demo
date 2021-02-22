package com.example.springsession.service;

import com.example.springsession.dto.SearchRequestDTO;
import com.example.springsession.dto.SearchResponseDTO;

/**
 * @author : sayan.das
 * @since : 2/22/21, Monday
 **/
public interface SearchService {

    SearchResponseDTO getProducts(SearchRequestDTO request);
}

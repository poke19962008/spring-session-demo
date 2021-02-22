package com.example.springsession.controller;

import com.example.springsession.dto.SearchRequestDTO;
import com.example.springsession.dto.SearchResponseDTO;
import com.example.springsession.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : sayan.das
 * @since : 2/22/21, Monday
 **/
@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping(path = "/search")
    public SearchResponseDTO getProducts(@RequestBody SearchRequestDTO request) {
        return searchService.getProducts(request);
    }

}

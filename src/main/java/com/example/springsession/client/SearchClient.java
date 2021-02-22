package com.example.springsession.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author : sayan.das
 * @since : 2/22/21, Monday
 **/
@FeignClient(name = "search-client", url="http://10.177.68.40:8983")
public interface SearchClient {
    /**
     * API Ref.
     * [GET] 10.177.68.40:8983/solr/productCollection/select?q=samsung+galaxy
     */
    @RequestMapping(method= RequestMethod.GET, path = "/solr/productCollection/select")
    Map<String, Object> getProducts(@RequestParam("q") String query);
}

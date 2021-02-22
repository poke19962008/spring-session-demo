package com.example.springsession.controller;

import com.example.springsession.dto.MyRequestDTO;
import com.example.springsession.dto.MyResponseDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : sayan.das
 * @since : 2/22/21, Monday
 **/
@RestController
public class MyController {

    @GetMapping(path = "/hello")
    public String helloWorld() {
        return "success!!!";
    }

//    @PutMapping
//    @DeleteMapping
    @PostMapping(path = "/hello-post")
    public String helloWorldPost() {
        return "success-post!!";
    }

    @GetMapping(path = "/hello-query")
    public String helloQuery(@RequestParam String query) {
        return "query " + query;
    }

    @PostMapping(path = "/register")
    public String registerUser(@RequestBody MyRequestDTO request) {
        return request.toString();
    }

    //[GET] /employee/{employeeID}
    //  /employee/123
    @GetMapping(path = "/employee/{employeeId}")
    public MyResponseDTO getEmployeeDetails(@PathVariable String employeeId) {
        MyResponseDTO response = new MyResponseDTO();
        response.setId(employeeId);
        return response;
    }
}

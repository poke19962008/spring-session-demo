package com.example.springsession.service.impl;

import com.example.springsession.dto.MyRequestDTO;
import com.example.springsession.dto.MyResponseDTO;
import com.example.springsession.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author : sayan.das
 * @since : 2/22/21, Monday
 **/
@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
        System.out.println("Inside UserService constructor..");
    }

    @PostConstruct
    public void init() {
        System.out.println("Inside UserService PostConstructor..");
    }

    @Override
    public boolean updateEmployee(MyRequestDTO request, String id) {
        // process...
        System.out.println("inside User Service "+ request + " id " + id);
        return false;
    }
}

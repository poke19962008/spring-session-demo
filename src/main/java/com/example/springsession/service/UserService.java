package com.example.springsession.service;

import com.example.springsession.dto.MyRequestDTO;
import com.example.springsession.dto.MyResponseDTO;

/**
 * @author : sayan.das
 * @since : 2/22/21, Monday
 **/
public interface UserService {
    boolean updateEmployee(MyRequestDTO request, String id);
}

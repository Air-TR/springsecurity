package com.tr.springsecurity.service;

import com.tr.springsecurity.entity.User;
import org.springframework.http.ResponseEntity;

public interface LoginAndOutService {

    ResponseEntity login(User user);
    ResponseEntity logout();

}

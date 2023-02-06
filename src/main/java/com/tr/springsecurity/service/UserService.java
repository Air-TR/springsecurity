package com.tr.springsecurity.service;

import com.tr.springsecurity.entity.User;

public interface UserService {

    User findByUsername(String username);

}

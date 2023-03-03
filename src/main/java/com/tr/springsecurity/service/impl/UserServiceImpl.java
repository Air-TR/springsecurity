package com.tr.springsecurity.service.impl;

import com.tr.springsecurity.common.exception.BusinessException;
import com.tr.springsecurity.entity.User;
import com.tr.springsecurity.jpa.UserRepository;
import com.tr.springsecurity.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author taorun
 * @date 2023/1/30 9:27
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new BusinessException("用户不存在"));
    }

}

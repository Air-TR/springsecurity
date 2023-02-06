package com.tr.springsecurity.controller;

import com.tr.springsecurity.entity.User;
import com.tr.springsecurity.service.impl.LoginAndOutServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author taorun
 * @date 2023/1/30 8:28
 */
@RestController
public class SecurityController {

    @Resource
    private LoginAndOutServiceImpl loginAndOutService;

    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody User user) {
        return loginAndOutService.login(user);
    }

    @GetMapping("/test")
    public String test() {
        return "test success";
    }

    @GetMapping("/nf/test")
    public String nfTest() {
        return "no filter success";
    }

}

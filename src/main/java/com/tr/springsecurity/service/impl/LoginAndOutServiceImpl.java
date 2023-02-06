package com.tr.springsecurity.service.impl;

import com.tr.springsecurity.entity.User;
import com.tr.springsecurity.service.LoginAndOutService;
import com.tr.springsecurity.util.JwtUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author taorun
 * @date 2023/1/30 9:43
 */
@Service
public class LoginAndOutServiceImpl implements LoginAndOutService {

    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public ResponseEntity login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名或密码错误");
        }
        // 使用 username 生成 token（如要用 user_id 生成，根据 username 去获取 user_id）
//        org.springframework.security.core.userdetails.User userDetail = (org.springframework.security.core.userdetails.User) authenticate.getPrincipal();
//        String userId = loginUser.getId().toString();
        String token = JwtUtil.createJWT(user.getUsername());
        // authenticate 存入redis
        stringRedisTemplate.opsForValue().set("TOKEN:" + user.getUsername(), token, 600, TimeUnit.SECONDS);
        return ResponseEntity.ok(token);
    }

    @Override
    public ResponseEntity logout() {
        return null;
    }

}

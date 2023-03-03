package com.tr.springsecurity.controller;

import com.tr.springsecurity.entity.User;
import com.tr.springsecurity.service.impl.LoginAndOutServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;

/**
 * @author taorun
 * @date 2023/1/30 8:28
 */
@RestController
public class SecurityController {

    @Resource
    private LoginAndOutServiceImpl loginAndOutService;

    /**
     * 用户名密码示例：
     *  admin：123456
     *  user：123456
     */
    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody User user) {
        return loginAndOutService.login(user);
    }

    @GetMapping("/nf/user/detail")
    public void detail() {
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println();
    }

    @GetMapping("/test")
    public String test() {
        return "test success";
    }

    @GetMapping("/nf/test")
    public String nfTest() {
        return "no filter success";
    }

    /**
     * 以下方式都能实现权限过滤
     *  推荐方式 @PreAuthorize
     *  @RolesAllowed、@Secured 都只能控制或，不能控制并且，即只能控制是否拥有某一权限，不能控制同时拥有多个权限
     *  要控制同时拥有多个权限，使用 @PreAuthorize + and 方式
     */
//    @RolesAllowed({"ROLE_Admin"})
//    @Secured({"ROLE_Admin", "ROLE_Manager"})
//    @PreAuthorize("hasRole('ROLE_Admin')")
//    @PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Manager')")
//    @PreAuthorize("hasRole('ROLE_Manager') and hasAnyRole('ROLE_Admin', 'ROLE_Root')")
//    @PreAuthorize("hasAuthority('ROLE_Admin')")
//    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager')")
    @PreAuthorize("hasAuthority('ROLE_Manager') and hasAuthority('ROLE_CEO') and hasAnyAuthority('ROLE_Admin', 'ROLE_Root')")
    @GetMapping("/test/role")
    public String role() {
        return "has role";
    }


}

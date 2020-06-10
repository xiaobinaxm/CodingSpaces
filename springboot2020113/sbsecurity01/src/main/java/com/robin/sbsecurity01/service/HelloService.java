package com.robin.sbsecurity01.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * @Description 方法安全
 * @Author Robin
 * @Date 2020/4/10 11:13
 */
@Service
public class HelloService {

    @PreAuthorize("hasRole('admin')")
    public String admin() {
        return "hello admin service!";
    }

    @Secured("ROLE_user")
    public String user() {
        return "hello user service!";
    }

    @PreAuthorize("hasAnyRole('admin','user')")
    public String users() {
        return "Congregations boys hello you have any roles!";
    }
}

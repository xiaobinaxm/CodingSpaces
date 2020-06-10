package com.robin.shiro03springboot.shiro;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/24 16:36
 */
@Controller
public class IndexController {

    @GetMapping({"/", "/index"})
    public String index() {
        return "/index";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) {
        System.out.println("HomeController.login>>>>>>>");
        //登陆失败后，从request中获取shiro处理异常信息
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception>>>" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        return "/login";
    }

    @GetMapping("/403")
    public String unauthorizedRole() {
        System.out.println("----------there is no role--------");
        return "403";
    }

}

















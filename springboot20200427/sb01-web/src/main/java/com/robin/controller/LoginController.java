package com.robin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/28 14:27
 */
@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("username") String password,
                        Model model,
                        HttpSession httpSession) {
        //执行具体的业务逻辑
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
            //这样直接跳转到这个页面，有个问题，就是用户名、密码都显示在url上面了，采用从定向方法
            //return "dashboard";
            httpSession.setAttribute("loginUser", username);
            return "redirect:/main.html";
        } else {
            //告诉用户，你登陆失败
            model.addAttribute("msg", "用户名或中密码错误！");
            return "index";
        }
    }


    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }


}

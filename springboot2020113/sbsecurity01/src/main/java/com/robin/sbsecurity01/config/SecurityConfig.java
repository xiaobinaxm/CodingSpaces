package com.robin.sbsecurity01.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/9 19:28
 */
//@Configuration    //暂时注释掉
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //    暂时不执行加密处理
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
//        return new BCryptPasswordEncoder();//采用加密方式
    }

    //不连接数据，配置用户名、密码
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("robin").password("root").roles("admin")
                .and()
                .withUser("robin1").password("root").roles("user");
    }


    //登陆信息配置
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
//                .antMatchers("user/**").hasAnyRole("admin", "user")
                .antMatchers("/user/**").hasAnyRole("admin", "user")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginProcessingUrl("/doLogin")
                .loginPage("/login")
                .usernameParameter("name")
                .passwordParameter("pwd")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json; charset=UTF-8");
                        PrintWriter writer = response.getWriter();
                        Map<Object, Object> map = new HashMap<>();
                        map.put("status", 200);
                        map.put("msg", authentication.getPrincipal());
                        writer.write(new ObjectMapper().writeValueAsString(map));
                        writer.flush();
                        writer.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
                        response.setContentType("application/json; charset=UTF-8");
                        PrintWriter out = response.getWriter();
                        Map map = new HashMap();
                        map.put("status", 401);
                        if (e instanceof LockedException) {
                            map.put("msg", "账户被锁定，登陆失败！");
                        } else if (e instanceof BadCredentialsException) {
                            map.put("msg", "用户名或密码错误，登陆失败！");
                        } else if (e instanceof DisabledException) {
                            map.put("msg", "账户被禁用，登陆失败！");
                        } else if (e instanceof CredentialsExpiredException) {
                            map.put("msg", "密码过期，登陆失败！");
                        } else if (e instanceof AccountExpiredException) {
                            map.put("msg", "账户过期，登陆失败！");
                        } else {
                            map.put("msg", "登陆失败！");
                        }
                        out.write(new ObjectMapper().writeValueAsString(map));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json; charset=UTF-8");
                        PrintWriter out = response.getWriter();
                        Map map = new HashMap();
                        map.put("status", 200);
                        map.put("msg", "注销登陆成功！");
                        out.write(new ObjectMapper().writeValueAsString(map));
                        out.flush();
                        out.close();
                    }
                })
                .and()
                .csrf().disable();
    }
}

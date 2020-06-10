package com.robin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Description 安全配置中心文件，看源码，一定要看注释信息，十分关键！！！！
 *              特别提醒：尽管项目配置了数据库，但是在做demo的时候，没有使用数据库
 * @Author Robin
 * @Date 2020/4/30 14:27
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    //授权配置规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，功能也只有对应权限的人才可以访问
        //采用链式变成，很爽的
        //请求授权规则
        http.authorizeRequests()
//                .antMatchers("/","/index","/index.html").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        //没有权限，默认会跳转到登陆页面   后面还可以对接前端，写用户名、密码
//        http.formLogin();//一行代码直接搞定     formLogin默认是走login请求的，但是我们路由配置的是toLogin，所以需要自己定义下
        http.formLogin().loginPage("/toLogin");//一行代码直接搞定,进一步增强，自定义登陆页面

        //一行代码直接搞定,进一步增强，自定义登陆页面，依据前端传递过来的参数,以及Action跳转页面（参数都在【views/login.html】页面中）
//        http.formLogin().loginPage("/toLogin").usernameParameter("username").passwordParameter("password").loginProcessingUrl("/login");

        //记住我
//        http.rememberMe();
        http.rememberMe().rememberMeParameter("remember");
        //自定义，在自己定义的页面，添加一个rememberme选项，实行服务端记住密码，默认是14天

        //防止网站攻击  get  post
        http.csrf().disable();


        //注销，开启了注销功能    也开打开源码，查询自定义登出
        //.logout().deleteCookies(&quot;remove&quot;).invalidateHttpSession(false)
        //.logoutUrl(&quot;/custom-logout&quot;).logoutSuccessUrl(&quot;/logout-success&quot;);
//        http.logout();
        http.logout().logoutSuccessUrl("/");//登出后跳转到首页


    }


    //面膜编码：PasswordEncode
    //在Spring Security 5.+ 新增了很多加密方法
    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
        //没有使用加密方法是报错
        //这些数据从内存中读取
 /*       auth.inMemoryAuthentication()
                .withUser("robin").password("123456").roles("vip1", "vip2", "vip3")
                .and()
                .withUser("robin1").password("123456").roles("vip1")
                .and()
                .withUser("robin2").password("123456").roles("vip2")
                .and()
                .withUser("robin3").password("123456").roles("vip3");
       */

        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1", "vip2")
                .and()
                .withUser("robin1").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1")
                .and()
                .withUser("robin2").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2")
                .and()
                .withUser("robin3").password(new BCryptPasswordEncoder().encode("123456")).roles("vip3");

    }
}

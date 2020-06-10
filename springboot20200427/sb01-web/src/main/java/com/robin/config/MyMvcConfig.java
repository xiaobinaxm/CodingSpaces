package com.robin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description 自定义配置文件，建议将所有个人配置统一配置到此处，便于后期维护
 * @Author Robin
 * @Date 2020/4/28 8:40
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //自定义页面控制
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/robin").setViewName("test");
        registry.addViewController("/main.html").setViewName("dashboard");
    }


    //国际化配置
    @Bean
    LocaleResolver localeResolver(){
        return new MyLocaleResolve();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/index",
                        "/", "/robin", "/user/login",
                        "/asserts/**");
    }
}

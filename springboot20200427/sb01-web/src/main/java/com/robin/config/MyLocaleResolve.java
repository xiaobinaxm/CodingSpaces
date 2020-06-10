package com.robin.config;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;



/**
 * @Description 配置本地化
 * @Author Robin
 * @Date 2020/4/28 12:03
 */
@Component
public class MyLocaleResolve implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        //获取请求参数头中的语言参数
        String languages = request.getParameter("language");

        System.out.println("lang>>>>>>" + languages);

        //如果没有就使用默认的
        //Locale locale = getDefaultLocale(); //这个方法也是可以的，采用的源码中代码风格import static javax.swing.JComponent.getDefaultLocale;
        Locale locale = Locale.getDefault();

        //如果请求参数中带有国际化的参数
        if (!StringUtils.isEmpty(languages)) {
            //因为国际化参数采用的是zh_CN形式，所以采用下划线分割
            String[] splits = languages.split("_");
            //语言 国家
            locale = new Locale(splits[0], splits[1]);
        }
        return locale;

/*
        String language = request.getParameter("lang");
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(language)){
            String[] split = language.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
*/



    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}

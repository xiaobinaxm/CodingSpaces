package com.robin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 测试Druid的Servlet配置  没有成功，啊啊啊啊啊啊啊啊fuck
 *              蠢材，访问路径，需要添加一个druid的，人才呀
 *              http://localhost:8080/druid
 * @Author Robin
 * @Date 2020/4/29 23:52
 */
@Configuration
public class DruidConfig {

/*


    //这个代码是我个人写的，可以执行，没问题
    //Druid数据源配置,加载配置yml配置文件
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //后台监控:web.xml,  ServletRegistrationBean
    //因为SpringBoot内置servlet容器，所以没有web.xml，替代方法就是讲这个ServletRegistrationBean注册进去即可
    @Bean
    public ServletRegistrationBean statViewServlet() {
        //必须注册一个支持视图的servlet
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>
                (new StatViewServlet(),"/druid/*");//必须注意此处的访问路径

        //后台需要有人登陆，账号密码设置
        HashMap<String, String> initParameters = new HashMap<>();
        //增加配置(固定配置，不要动)，设置用户名  密码
        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "123456");

        //允许所有人可以访问
        initParameters.put("allow", "");

        //设置初始化参数
        bean.setInitParameters(initParameters);
        return bean;
    }

    // filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        //可以过滤哪些请求呢?
        Map<String, String> initParameters = new HashMap<>();
        //这些东西不进行统计~
        initParameters.put("exclusions", "*.js*,css,/druid/*");
        bean.setInitParameters( initParameters);
        //bean.setUrlPatterns(Arrays.asList("/*"));//可配置，可不配置
        return bean;
    }
*/


///////////////////////////////////////华丽分割线/////////////////////////////////////////////////////

/*
//这个是网友提供的代码  没有问题
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    //配置Druid的监控
    //配置一管理后台的servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){

        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String>initParams = new HashMap<>();
        initParams.put("loginUsername","admin");   //设置登陆账号密码
        initParams.put("loginPassword","123456");
        initParams.put("allow","");

        bean.setInitParameters(initParams);
        return  bean;
    }

    //配置管理web监控的filter

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String,String>initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

*/



}

package com.robin;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @Description
 * @Author Robin
 * @Date 2020/5/31 16:49
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker//开启容错后处理机制
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class, args);
    }


    //直接在配置文件中配置:   management.endpoints.web.exposure.include="*",可以代替下面的java代码
    /**
     * 此配置是为了服务监控而配置，与服务 容错本身无关，SpringCloud 升级后的坑
     * ServletRegistrationBean因为springboot的默认路径不是"/hystrix.stream",
     * 只要在自己的项目里配置上:下面的servlet就可以了
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
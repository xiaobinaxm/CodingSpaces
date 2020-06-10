package com.robin.config;

import com.robin.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @Description  配置类==配置文件
 * @Author Robin
 * @Date 2018/12/9 19:50
 */
@Configuration//告诉Spring这是一个配置类
//@ComponentScan(value = "com.robin",excludeFilters = {
//        @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = Controller.class),
//        @ComponentScan.Filter(type =FilterType.ASSIGNABLE_TYPE,value = BookService.class)
//})
@ComponentScans(value = {
        @ComponentScan(value = "com.robin",includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Controller.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyTypeFilter.class)
        },useDefaultFilters = false)
})
//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] ;指定烧面的时候按照什么规则排除那些组件
//includeFilter = Filter[] ;指定烧面的时候，只需要包含那部分组件
public class MainConfig {

    //给容器中注册一个Bean；类型就是返回值的类型，id默认就是方法名作为id
    @Bean
    public Person person(){
        return new Person("Lishi",22);
    }


}

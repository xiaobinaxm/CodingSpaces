package com.robin.config;

import com.robin.bean.Color;
import com.robin.bean.ColorfactoryBean;
import com.robin.bean.Person;
import com.robin.bean.Red;
import com.robin.condition.LinuxCondition;
import com.robin.condition.MyImportBeanDefinitionRegistrar;
import com.robin.condition.MyImportSelector;
import com.robin.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @Description
 * @Author Robin
 * @Date 2018/12/10 23:53
 */
@Configuration
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
//import导入，id默认是组件的全路径名
public class MainConfig2 {


    /**
     * @Description：
     * @Author:Robin
     * @Date:2018/12/11 0:02
     *
     * prototype :多实例:IOC容器启动的时候并不会去调用方法创建对象放在容器中。
     *                  每次获取的时候才会调用方法创建对象。
     * singleton ：单实例（默认值）：IOC容器启动会调动方法创建对象放到IOC容器中。
     *                  以后每次获取就是直接从容器（map.get()）中拿
     * request ：同一个请求域
     * session ：同一个session创建一个实例
     *
     *
     * 懒加载：
     *         单实例bean：默认在容器启动的时候创建对象；
     *         懒加载：容器启动的时候不创建对象，在第一次使用bean的时候，再来创建对象，并进行一些初始化
     */
//    @Scope("prototype")
    @Lazy
    //默认都是单实例的
    @Bean("person")
    public Person person(){
        System.out.println("给容器中添加Person....");
        return new Person("肖斌",23);
    }


    /**
     * @Condition：按照一定条件进行判断，满足条件给容器中注册bean
     *              如果系统是Windows，给容器注册bill
     *              入股哦系统是Linux，给容器注册linus
     * @Author:Robin
     * @Date:2018/12/11 0:22
     */
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates",62);
    }

    @Conditional(LinuxCondition.class)
    @Bean("linus")
    public Person person02(){
        return new Person("Linus",40);
    }

    /**
     * 给容器中注册组件：
     * 1、包扫描+组件注解（@Controller @Service @Component @Repository）【自己写的】
     * 2、@Bean 【导入的第三方包】
     * 3、@Import 【快速的给容器中导入组件】
     *      1)、@Import（要导入容器中的组件）；容器就会自动注册这个组件，id是类的全路径名
     *      2）、@ImportSelector：导入的选择器，导入组件的全类名
     *      3)、@ImportBeanDefinitionRegistrar：手动注册bean到容器中
     *  4、使用Spring提供的FactoryBean（工厂Bean）
     *      1) 默认获取到的是工厂bean调用getObject()创建的对象
     *      2）获取工厂bean本身，需要在给id前面加一个&符号
     */
    @Bean
    public ColorfactoryBean colorfactoryBean(){
        return  new ColorfactoryBean();
    }

}

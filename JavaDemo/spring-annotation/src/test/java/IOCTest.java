import com.robin.bean.Blue;
import com.robin.bean.Person;
import com.robin.config.MainConfig;
import com.robin.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @Description
 * @Author Robin
 * @Date 2018/12/9 20:32
 */
public class IOCTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
    
    @Test
    public void testImport(){
        printBean(applicationContext);
        Blue bean = applicationContext.getBean(Blue.class);
        System.out.println(bean);

        //工厂bean获取的是调用getObject创建对象
        Object bean1 = applicationContext.getBean("ColorfactoryBean");
        System.out.println("bean的类型...." + bean1.getClass());

        Object bean2 = applicationContext.getBean("&colorfactoryBean");
        System.out.println(bean2.getClass());
    }

    //打印容器中所有组件的Bean信息
    public void printBean(AnnotationConfigApplicationContext applicationContext){
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names){
            System.out.println(name);
        }
    }

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println(name);
        }
    }

    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println(name);
        }

        System.out.println("IOC容器创建完成...");
        Object bean = applicationContext.getBean("person");
        Object bean1 = applicationContext.getBean("person");
        System.out.println(bean == bean1);//true  单实例
    }


    @Test
    public void test03(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);


        for (String name : names){
            System.out.println(name);
        }

        Map<String, Person> personMap = applicationContext.getBeansOfType(Person.class);
        System.out.println(personMap);

    }
}

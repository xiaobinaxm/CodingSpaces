import com.robin.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description
 * @Author Robin
 * @Date 2018/12/23 11:43
 */
public class IOCTest_LifeCycle {

    @Test
    public void test1(){
        //创建ioc容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成。。。。。");
        //

        //关闭容器，此刻就来调用销毁方法
        context.close();




    }
}

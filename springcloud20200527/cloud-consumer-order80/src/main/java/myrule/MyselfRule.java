package myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description   //自定义负载均衡规则
 * @Author Robin
 * @Date 2020/5/30 11:46
 */
@Configuration
public class MyselfRule {

    @Bean
    public IRule muRule() {
        return new RandomRule();//定义为随机
    }
}

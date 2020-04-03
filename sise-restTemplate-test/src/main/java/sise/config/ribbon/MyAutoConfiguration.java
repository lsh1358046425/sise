package sise.config.ribbon;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/4/3 16:53
 */

@Configuration
public class MyAutoConfiguration {
    @Autowired(required = false)
    @MyLoadBalanced
    private List<RestTemplate> templates = Collections.emptyList();

    @Bean
    public SmartInitializingSingleton myLoadBalancedRestTemplateInitializer(){
        System.out.println("======这个Bean将在容器初始化时创建");
        return new SmartInitializingSingleton() {
            @Override
            public void afterSingletonsInstantiated() {
                for (RestTemplate template : templates) {
                    //创建一个自定义拦截器实例
                    MyInterceptor interceptor = new MyInterceptor();
                    //获取原来的拦截器
                    List list = new ArrayList(template.getInterceptors());
                    //将自定义拦截器添加
                    list.add(interceptor);
                    //将新的拦截器集合设置到RestTemplate实例
                    template.setInterceptors(list);
                }
            }
        };
    }
}

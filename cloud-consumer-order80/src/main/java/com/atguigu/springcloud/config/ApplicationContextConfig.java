package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    // TODO: 2020/9/22 这里必须要有这个注解，否则provider的高可用（负载均衡）就无法实现
    //  （直接报错！因为我们在controller中调用的是服务名http://cloud-payment-service）！！
//    @LoadBalanced    //因为自己写了本地负载均衡LoadBalancer--MyLB  故将该注解注释掉
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}

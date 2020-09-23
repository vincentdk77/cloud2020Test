package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义负载均衡器（仿照RoundRobinRule来写的），需要将@LoadBalanced注解去掉，使ribbon的自带负载均衡不生效。
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}

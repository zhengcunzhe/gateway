package com.zcz.gateway;

import com.zcz.gateway.config.MyLoadBalancerClientConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//注册中心里服务名为PROVIDER的各个服务，采用的是MyLoadBalancerClientConfiguration自定义负载均衡策略
@LoadBalancerClient(name = "PROVIDER", configuration = MyLoadBalancerClientConfiguration.class)
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}

package com.zcz.gateway.config;

import com.zcz.gateway.rule.CustomLoadBalancerClient;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

public class MyLoadBalancerClientConfiguration {

    //自定义负载均衡策略,默认是轮询
    @Bean
    public ReactorServiceInstanceLoadBalancer customLoadBalancer(Environment environment, ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider) {
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        return new CustomLoadBalancerClient(serviceInstanceListSupplierProvider, name);
    }

}

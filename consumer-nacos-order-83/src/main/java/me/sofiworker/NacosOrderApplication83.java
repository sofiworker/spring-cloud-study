package me.sofiworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author sofiworker
 * @date 2020/7/13  17:28
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosOrderApplication83 {

    public static void main(String[] args) {
        SpringApplication.run(NacosOrderApplication83.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

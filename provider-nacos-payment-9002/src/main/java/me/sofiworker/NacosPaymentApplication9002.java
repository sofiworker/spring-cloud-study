package me.sofiworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sofiworker
 * @date 2020/7/13  17:06
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentApplication9002 {

    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentApplication9002.class, args);
    }
}

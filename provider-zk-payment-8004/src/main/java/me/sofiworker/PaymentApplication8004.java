package me.sofiworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2020/5/8 9:46
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8004.class,args);
    }
}

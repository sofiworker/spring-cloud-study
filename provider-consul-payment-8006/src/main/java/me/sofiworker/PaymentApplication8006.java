package me.sofiworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sofiworker
 * @date 2020/7/10  17:17
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication8006 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8006.class, args);
    }
}

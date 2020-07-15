package me.sofiworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sofiworker
 * @date 2020/7/15  21:14
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication9003 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication9003.class, args);
    }
}

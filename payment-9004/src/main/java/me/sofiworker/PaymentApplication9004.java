package me.sofiworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sofiworker
 * @date 2020/7/15  21:20
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication9004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication9004.class, args);
    }
}

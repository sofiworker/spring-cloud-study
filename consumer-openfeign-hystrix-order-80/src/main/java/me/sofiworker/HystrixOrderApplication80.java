package me.sofiworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author sofiworker
 * @date 2020/7/11  16:54
 */

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class HystrixOrderApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixOrderApplication80.class, args);
    }
}

package me.sofiworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author sofiworker
 * @date 2020/7/11  11:49
 */
@SpringBootApplication
@EnableFeignClients
public class OpenFeignApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignApplication80.class, args);
    }
}

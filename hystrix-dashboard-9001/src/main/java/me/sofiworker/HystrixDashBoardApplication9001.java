package me.sofiworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author sofiworker
 * @date 2020/7/11  22:06
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoardApplication9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoardApplication9001.class, args);
    }
}

package me.sofiworker.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * @author sofiworker
 * @date 2020/7/11  16:14
 */
@Service
public class PaymentService {

    //========================服务降级=============================================
    public String paymentInfoOk() {
        return "当前线程："+Thread.currentThread().getName()+"，成功了！！！";
    }

    @HystrixCommand(fallbackMethod = "paymentInfoErrorHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoError() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int result = 10 / 0;
        return "当前线程："+Thread.currentThread().getName()+"，失败了！！！";
    }

    public String paymentInfoErrorHandler() {
        return "8001错误处理";
    }

    //====================服务熔断======================
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            //请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            //时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            //失败率达到多少跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentCircuitBreaker(Long id) {
        if (id < 0) {
            throw new RuntimeException("------------------>传入的id不能为负数");
        }
        return "调用熔断服务成功！";
    }

    public String paymentCircuitBreakerFallback(Long id) {
        return "触发服务熔断，当前返回的是服务熔断的处理，当前传递的参数为："+id;
    }
}

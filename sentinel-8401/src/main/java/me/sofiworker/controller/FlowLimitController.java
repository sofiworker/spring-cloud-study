package me.sofiworker.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @author sofiworker
 * @date 2020/7/14  21:15
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "---------------->testA";
    }


    @GetMapping("/testB")
    public String testB() {
        Logger logger = Logger.getAnonymousLogger();
        logger.info("当前时间："+System.currentTimeMillis() +"当前线程："+Thread.currentThread().getName()+"，请求接口：testB");
        return "---------------->testB";
    }

    @GetMapping("/testD")
    public String testD() {
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("------------------------>测试RT");
        int age = 10 / 0;
        return "---------------->testD";
    }

    @GetMapping("/testE")
    public String testE() {
        System.out.println("------------------------>测试异常数");
        int age = 10 / 0;
        return "---------------->testE";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(required = false) String p1,
                             @RequestParam(required = false) String p2) {
        return "---------------->testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException e) {
        return "----------------------->deal_testHotKey";
    }
}

package me.sofiworker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sofiworker
 * @date 2020/7/13  10:18
 */
@RestController
@EnableBinding(Sink.class)
public class ReceiveMessageController {

    @Value("${server.port}")
    private String port;
    
    @StreamListener(Sink.INPUT)
    public void getMessage(Message<String> message) {
        System.out.println("当前消费者端口号："+port+"，接收的消息为："+message.getPayload());
    }
}

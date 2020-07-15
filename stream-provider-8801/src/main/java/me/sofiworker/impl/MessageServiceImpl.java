package me.sofiworker.impl;

import me.sofiworker.service.MessageService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author sofiworker
 * @date 2020/7/13  9:59
 */
@EnableBinding(Source.class)
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String payload = UUID.randomUUID().toString();
        System.out.println("id为："+payload);
        boolean send = output.send(MessageBuilder.withPayload(payload).build());
        return "结果："+send+"，id为："+payload;
    }
}

package me.sofiworker.controller;

import me.sofiworker.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sofiworker
 * @date 2020/7/13  10:05
 */
@RestController
public class MessageController {

    @Resource
    private MessageService messageService;

    @GetMapping("/send/message")
    public String getSendMessageResult() {
        return messageService.send();
    }
}

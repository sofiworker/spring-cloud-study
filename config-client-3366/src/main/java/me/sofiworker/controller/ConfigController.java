package me.sofiworker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sofiworker
 * @date 2020/7/12  17:50
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String port;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return "当前服务端口号："+port+"，远程配置信息为："+configInfo;
    }
}

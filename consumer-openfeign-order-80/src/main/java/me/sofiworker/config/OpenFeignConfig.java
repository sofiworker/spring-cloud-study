package me.sofiworker.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sofiworker
 * @date 2020/7/11  12:16
 */
@Configuration
public class OpenFeignConfig {

    @Bean
    Logger.Level level() {
        return Logger.Level.FULL;
    }
}

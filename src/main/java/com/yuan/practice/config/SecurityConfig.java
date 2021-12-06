package com.yuan.practice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yuan
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "security")
public class SecurityConfig {

    private Long expire = 7200000L;

    private String tokenHeader = "Authorization";
}

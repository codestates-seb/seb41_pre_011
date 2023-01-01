package com.codestates.seb41_pre_011.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")
                .allowedOrigins("http://ec2-13-209-138-5.ap-northeast-2.compute.amazonaws.com:8080")
                .allowedOrigins("*")
                .allowedMethods("*")
                .exposedHeaders("Authorization", "Refresh")
                .allowCredentials(false)
                .maxAge(3000);
    }
}
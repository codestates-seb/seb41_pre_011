package com.codestates.seb41_pre_011.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedOrigins("*")
                .allowedMethods("*")
                .exposedHeaders("Authorization", "Refresh")
                .allowCredentials(false)
                .maxAge(3000);
    }
}
package com.codestates.seb41_pre_011.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")
                .allowedOrigins("http://localhost:3000")
                .allowedOrigins("http://ec2-13-209-138-5.ap-northeast-2.compute.amazonaws.com:8080")
                .allowedOrigins("http://seb41-pre-011.s3-website.ap-northeast-2.amazonaws.com")
                .allowedOrigins("*")
                .allowedMethods("*")
                .exposedHeaders("Authorization", "Refresh")
                .allowedHeaders()
                .allowCredentials(false)
                .maxAge(3000);

    }
}
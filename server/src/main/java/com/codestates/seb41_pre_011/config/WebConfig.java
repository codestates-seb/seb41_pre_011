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
<<<<<<< HEAD
//                .allowedOrigins("http://ec2-13-209-138-5.ap-northeast-2.compute.amazonaws.com:8080")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowCredentials(true)
                .exposedHeaders("Authorization")
=======
                .allowedOrigins("http://ec2-13-209-138-5.ap-northeast-2.compute.amazonaws.com:8080")
                .allowedOrigins("*")
                .allowedMethods("*")
                .exposedHeaders("Authorization", "Refresh")
                .allowedHeaders()
                .allowCredentials(false)
>>>>>>> 7e03189891b8d21eed6b8fdf6becc07d55937e21
                .maxAge(3000);

    }
}
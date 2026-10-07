package com.aclibrary.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApiConfig {
 @Bean public BCryptPasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
 @Bean public WebMvcConfigurer corsConfigurer(){return new WebMvcConfigurer(){@Override public void addCorsMappings(CorsRegistry r){r.addMapping("/api/**").allowedOrigins("*").allowedMethods("GET","POST","PUT","DELETE","OPTIONS").allowedHeaders("*");}};}
}

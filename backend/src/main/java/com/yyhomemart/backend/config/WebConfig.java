package com.yyhomemart.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://y-y-home-mart-user.vercel.app") // <-- REMOVED THE TRAILING SLASH
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // <-- ADDED "OPTIONS"
                .allowedHeaders("*") // <-- Recommended to add this for flexibility
                .allowCredentials(true) // <-- Add this if you plan to use cookies/sessions/auth headers
                .maxAge(3600); // <-- Recommended for preflight caching
    }
}

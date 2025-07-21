package com.yyhomemart.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered; // Import Ordered
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter; // Corrected import for CorsFilter

@Configuration
public class WebConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        // Allow credentials (e.g., cookies, authorization headers)
        config.setAllowCredentials(true);
        // Specify the exact origin of your frontend application
        config.addAllowedOrigin("https://y-y-home-mart-user.vercel.app");
        // Allow all headers from the client
        config.addAllowedHeader("*");
        // Allow all HTTP methods (GET, POST, PUT, DELETE, OPTIONS, etc.)
        config.addAllowedMethod("*");
        // You can also set max age for preflight requests (in seconds)
        // config.setMaxAge(3600L); // Cache preflight response for 1 hour

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // Register this CORS configuration for all paths (/**)
        source.registerCorsConfiguration("/**", config);

        // Create the CorsFilter and set its order to be very high (run early)
        // Ordered.HIGHEST_PRECEDENCE ensures it runs before most other filters
        return new CorsFilter(source);
    }
}

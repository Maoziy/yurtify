package com.maoziy.yurtify;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Tüm endpointler için CORS izni
                        .allowedOrigins("http://example.com", "http://localhost:3000") // İzin verilen origin adresleri
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // İzin verilen HTTP metodları
                        .allowedHeaders("*") // İzin verilen header bilgileri
                        .allowCredentials(true) // Kimlik doğrulama bilgilerine izin ver
                        .maxAge(3600); // Preflight isteğinin geçerlilik süresi (saniye cinsinden)
            }
        };
    }
}

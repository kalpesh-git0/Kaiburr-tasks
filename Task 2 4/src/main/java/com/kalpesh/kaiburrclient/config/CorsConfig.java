package com.kalpesh.kaiburrclient.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("http://localhost:8080/api/objects/") // Configure the path pattern you want to allow CORS for
                .allowedOrigins("http://localhost:3000") // Specify the allowed origin(s)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Specify the allowed HTTP methods
                .allowCredentials(true); // Enable cookies and credentials (if needed)
    }
}

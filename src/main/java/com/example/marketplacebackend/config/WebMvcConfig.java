package com.example.marketplacebackend.config;

import com.example.marketplacebackend.controller.resolver.UsernameArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new UsernameArgumentResolver());
        WebMvcConfigurer.super.addArgumentResolvers(resolvers);
    }
}

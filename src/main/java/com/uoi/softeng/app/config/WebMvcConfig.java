package com.uoi.softeng.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /*
         * ViewControllerRegistry allows to create
         * simple automated controllers pre-configured
         * with status code and/or a view
         */
        registry.addViewController("/").setViewName("register");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/login").setViewName("login");
    }
}
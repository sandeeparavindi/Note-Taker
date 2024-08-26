package com.example.noteTaker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.example.noteTaker")
@EnableWebMvc
@EnableJpaRepositories(basePackages = "com.example.noteTaker")
@EnableTransactionManagement
public class WebAppConfig {
}

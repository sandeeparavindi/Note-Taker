package com.example.noteTaker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.example.noteTaker")
@EnableWebMvc //http request response handle krnn wishesha wela thina annotation ekak. presentation
// layer ektne adla e nis app congig eke withrak dnw. root config ekt danne nh
@EnableJpaRepositories(basePackages = "com.example.noteTaker")
@EnableTransactionManagement
public class WebAppConfig {
}

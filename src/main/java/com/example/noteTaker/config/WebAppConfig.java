package com.example.noteTaker.config;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.example.noteTaker")
@EnableWebMvc //http request response handle krnn wishesha wela thina annotation ekak. presentation
// layer ektne adla e nis app congig eke withrak dnw. root config ekt danne nh
//Ture power eka gnna thmai enable type annotation use krnne
@EnableJpaRepositories(basePackages = "com.example.noteTaker")
@EnableTransactionManagement
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, //2MB primary sha secondary memory eke dewal process krnw
        //2MB ta wdi nn hard eke tempary file ekt save weno
        maxFileSize = 1024 * 1024 * 10, //10MB
        //max file size upload krnn puluwan file eke uprima prmanaya
        maxRequestSize = 1024 * 1024 * 50 //50MB
)
public class WebAppConfig {
}

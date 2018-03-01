package com.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

//@EnableEurekaClient
//@EnableDiscoveryClient
@EnableGlobalMethodSecurity
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ApplicationBoot extends SpringBootServletInitializer{
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ApplicationBoot.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(ApplicationBoot.class, args);
	}
}

package com.gfdz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@EnableCaching
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.gfdz"})
@SpringBootApplication
public class StartApplication {
	@RequestMapping("/")
	public String index() {
		return "forward:/home";
	}
	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}
}

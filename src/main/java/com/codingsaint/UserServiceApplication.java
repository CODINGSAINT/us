package com.codingsaint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.security.oauth2.resource.EnableOAuth2Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableOAuth2Resource
@RestController
public class UserServiceApplication {
	@RequestMapping("/")
	public String ok() {
		return "ok";
	}
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
    }
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
}

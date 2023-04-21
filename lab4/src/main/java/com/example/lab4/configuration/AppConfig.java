package com.example.lab4.configuration;
import com.vaadin.flow.spring.annotation.EnableVaadin;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.lab4")
@EnableVaadin
public class AppConfig {
}
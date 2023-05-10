package com.example.lab4.configuration;
import com.vaadin.flow.spring.annotation.EnableVaadin;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableVaadin

@EntityScan("com.example.lab4.Entity")
@EnableJpaRepositories("com.example.lab4.repository")
public class AppConfig {

}
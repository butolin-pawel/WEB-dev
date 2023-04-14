package com.example.lab4.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import javax.sql.DataSource;
import javax.tools.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() //
                .antMatchers("/car/new").hasRole("ADMIN") //  ADMIN /admin/**
                .antMatchers("/car/**").hasAnyRole("USER", "ADMIN")

                .and()
                .formLogin() //
                .loginPage("/cars")
                .defaultSuccessUrl("/cars")
                .permitAll()
                .loginProcessingUrl("/authenticateTheUser")
                .and()
                .logout()
                .logoutUrl("/logout")
                .permitAll();
    }

}

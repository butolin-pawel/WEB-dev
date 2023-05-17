//package com.example.lab4.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.SecurityBuilder;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import javax.sql.DataSource;
//import javax.tools.*;
//
//@Configuration
//@EnableWebSecurity
//    public class SecurityConfig implements WebSecurityConfigurer {
//    private DataSource dataSource;
//
//    @Autowired
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource);
//    }
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests() //
//                .antMatchers("/cars/newcar").hasRole("ADMIN")
//                .antMatchers("/cars/newbox").hasRole("ADMIN")
//                .antMatchers("/cars/del/**").hasRole("ADMIN")
//                .antMatchers("/cars/edit").hasRole("ADMIN")
//                .antMatchers("/cars/edit/**").hasRole("ADMIN")
//                .antMatchers("/cars/del").hasRole("ADMIN")//  ADMIN /admin/**
//                .antMatchers("/cars/box").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/cars/box/**").hasAnyRole( "ADMIN")
//                .antMatchers("/cars/wash/**").hasAnyRole( "ADMIN")
//                .antMatchers("/cars/wash").hasAnyRole( "ADMIN")
//                .antMatchers("/cars/washes").hasAnyRole("USER","ADMIN")
//                .antMatchers("/cars/washes/**").hasRole("ADMIN")
//                .and()
//                .formLogin() //
//                .loginPage("/cars")
//                .defaultSuccessUrl("/cars")
//                .permitAll()
//                .loginProcessingUrl("/authenticateTheUser")
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .permitAll();
//    }
//
//    @Override
//    public void init(SecurityBuilder builder) throws Exception {
//
//    }
//
//    @Override
//    public void configure(SecurityBuilder builder) throws Exception {
//
//    }
//}
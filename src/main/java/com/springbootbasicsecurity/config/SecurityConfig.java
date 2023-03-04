package com.springbootbasicsecurity.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springbootbasicsecurity.securityService.CustomeUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	Logger logger = Logger.getLogger(SecurityConfig.class);
	
	@Autowired
	CustomeUserDetailsService customeUserDetailsService;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/h2-console/**").permitAll().anyRequest().authenticated().and().httpBasic();
		//this for normal auth from property file
		http.csrf().disable();
        http.headers().frameOptions().disable();
        logger.info("Loading Http Security.....");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 logger.info("Loading Http Authentication Manager Builder.....");
		auth.userDetailsService(customeUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		   logger.info("Generating Bcrypt Password Http Security.....");
		return new BCryptPasswordEncoder();
	}
}

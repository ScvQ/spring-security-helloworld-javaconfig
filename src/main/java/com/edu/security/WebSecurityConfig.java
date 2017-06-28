package com.edu.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("123").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("123").roles("USER", "ADMIN");
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/home").hasRole("USER");
		http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN");
		
		http.authorizeRequests().antMatchers("/**/*.html").permitAll();
		http.authorizeRequests().antMatchers("/**/*.css").permitAll();
		http.authorizeRequests().antMatchers("/**/*.js").permitAll();
		http.authorizeRequests().antMatchers("/**/*.png").access("permitAll");
		
		http.authorizeRequests().anyRequest().authenticated();
//		http.authorizeRequests().anyRequest().access("authenticated");
		
		http.formLogin();
	}
}

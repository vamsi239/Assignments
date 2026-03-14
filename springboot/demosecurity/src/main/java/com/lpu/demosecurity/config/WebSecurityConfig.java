package com.lpu.demosecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) {
		//return http.build();
		http.authorizeHttpRequests((req)->
		req.requestMatchers("/reg","/error").permitAll()
		.anyRequest().authenticated());
		
		http.formLogin(Customizer.withDefaults()); //Chrome login page
		http.httpBasic(Customizer.withDefaults()); //postman basic auth
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService detailsService() {
		UserDetails user1=User
				.withUsername("vamsi")
				.password("{noop}123")
				.roles("read")
				.build();
		UserDetails user2=User
				.withUsername("admin")
				.password("{noop}321")
				.roles("admin")
				.build();
		return new InMemoryUserDetailsManager(user1,user2);
	}
}

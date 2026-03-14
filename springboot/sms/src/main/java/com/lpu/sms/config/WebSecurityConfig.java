package com.lpu.sms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	    http
	        .csrf(csrf -> csrf.disable())   // important for REST APIs
	        .cors(Customizer.withDefaults())
	        .authorizeHttpRequests(req ->
	                req

	             // allow registration
	                .requestMatchers(HttpMethod.POST,"/api/students").permitAll()

	             // uploads
	                .requestMatchers(HttpMethod.POST,"/api/students/uploadProfile/**").hasAnyRole("ADMIN","USER")
	                .requestMatchers(HttpMethod.POST,"/api/students/uploadAssignment/**").hasAnyRole("ADMIN","USER")
	                // ADMIN only
	                .requestMatchers(HttpMethod.PUT,"/api/students/**").hasRole("ADMIN")
	                .requestMatchers(HttpMethod.DELETE,"/api/students/**").hasRole("ADMIN")

	                // ADMIN + USER
	                .requestMatchers(HttpMethod.GET,"/api/students/**").hasAnyRole("ADMIN","USER")

	                .anyRequest().authenticated()
	        )
	        .httpBasic(Customizer.withDefaults());

	    return http.build();
	}
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOrigin("http://localhost:3000");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
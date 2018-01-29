package br.com.client.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {    
    	
    	 http.csrf().disable().authorizeRequests()
	         .antMatchers(HttpMethod.POST).permitAll()
	         .anyRequest().authenticated()
	         .and()
	         .addFilter(new JWTAuthenticationFilter(authenticationManager()))
	         .cors();
    	
    }

    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
		 CorsConfiguration configuration = new CorsConfiguration();

		 configuration.setAllowCredentials(true);
	     configuration.addAllowedOrigin("http://localhost:4200");
	     configuration.addAllowedHeader("*");
	     configuration.addAllowedMethod("*");
	     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	     source.registerCorsConfiguration("/**", configuration);
	     return source;
    }

}
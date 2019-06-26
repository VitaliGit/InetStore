package com.vironit.store.config;

import java.util.Arrays;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource securityDS;
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(securityDS);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		cors().and().
		authorizeRequests().
		antMatchers("/").hasAnyRole("ADMIN", "REGULAR").
		antMatchers("/cart/**").hasAnyRole("ADMIN", "REGULAR").
		antMatchers("/authority/**").hasRole("ADMIN").
		antMatchers(HttpMethod.GET, "/user/enable").hasRole("ADMIN").
		antMatchers(HttpMethod.GET, "/user/search" ).hasRole("ADMIN").
		antMatchers(HttpMethod.GET, "/user/update_character" ).hasRole("ADMIN").		
		antMatchers("/rest_api+/**").hasRole("ADMIN"). // blocks the whole RESTful for everyone but the admins
		antMatchers("/**/management").hasRole("ADMIN"). // However do not do this /user/** as it'd restrict registration, change of passwords
		and().
		formLogin().loginPage("/login").loginProcessingUrl("/login_authentication").//successForwardUrl("/proceed").
		permitAll().and().
		logout().permitAll().and().
		csrf().disable().//only for postman purposes 
		exceptionHandling().accessDeniedPage("/access_prohibited");
	}

	 @Bean
	 CorsConfigurationSource corsConfigurationSource() {
	         CorsConfiguration configuration = new CorsConfiguration();
	         configuration.setAllowedOrigins(Arrays.asList("*"));
	         configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "DELETE", "PUT", "PATCH"));
	         configuration.setAllowedHeaders(Arrays.asList("X-Requested-With", "Origin", "Content-Type", "Accept", "Authorization"));
	         configuration.setAllowCredentials(true);
	         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	         source.registerCorsConfiguration("/**", configuration);
	         return source;
	     }

	

}

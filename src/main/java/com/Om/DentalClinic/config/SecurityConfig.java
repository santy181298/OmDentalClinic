package com.Om.DentalClinic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private AuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	@Bean
	public UserDetailsService getUserDetailsService() {
		return new CustomUserDetailsService();
	}
	
	@Bean
	public BCryptPasswordEncoder getPassword() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider()
	{
		DaoAuthenticationProvider daoauth=new DaoAuthenticationProvider();
		daoauth.setUserDetailsService(getUserDetailsService());
		daoauth.setPasswordEncoder(getPassword());
		return daoauth;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf().disable()
		.authorizeHttpRequests().requestMatchers("/adminhome.html").hasRole("ADMIN")
		.requestMatchers("/userhome.html").hasRole("USER")
		.requestMatchers("/**").permitAll()
		.and().formLogin().loginPage("/login")
		.loginProcessingUrl("/login").successHandler(customAuthenticationSuccessHandler).permitAll() // Redirect
																										// all
																										// users
																										// to a
																										// common
		// profile page after login
		.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").permitAll().and().exceptionHandling()
		.accessDeniedPage("/access-denied");

http.authenticationProvider(daoAuthenticationProvider());

return http.build();
	}
	
}

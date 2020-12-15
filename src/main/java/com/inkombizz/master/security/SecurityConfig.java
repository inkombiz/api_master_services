package com.inkombizz.master.security;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean 
	public PasswordEncoder passwordEncoder () {
		return new BCryptPasswordEncoder();
//		return new NoOpPasswordEncoder(); password tanpa enkripsi
//		return new StandardPasswordEncoder(); password enkripsi sha45
	}
	
	
//	@Autowired
//	UserDetailsServiceImpl userService;
//	// proses authentikasi nya 
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
//		//ini untuk setting hardcode password dan username nya
////		String password = passwordEncoder().encode("12345");
////		auth.inMemoryAuthentication()
////		.withUser("admin")
////		.password(password).roles("USER");
//		
//		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
//		
////		super.configure(auth);
//	}
	
	
	// rule / aturan main untuk login
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		
//		http.csrf().disable()
//		.authorizeRequests()
//		.antMatchers(HttpMethod.POST, "/v1/user/")
//		.permitAll()
//		.anyRequest().authenticated()
//		.and()
//		.addFilter(new JWTAuthenticationFilter(authenticationManager()))
//		.addFilter(new JWTAuthorizationFilter(authenticationManager()))
//		.sessionManagement()
//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////		.and().httpBasic(); ini unutk basic authenticasi
//	//	super.configure(http);
//	}
	
	
}

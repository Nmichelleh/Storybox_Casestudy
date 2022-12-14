package com.book.store.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.annotation.WebFilter;


@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{

		http
		.csrf().disable()
		.authorizeRequests().antMatchers("/home","/","/login/login","/login/createUser","/createUser", "/login","/login/**", "/css/**", "*.mp4").permitAll()
		.anyRequest().authenticated()
		.and()
//,"../js/**", "../css/**","/**/*.js", "/**/*.css"
		.formLogin()
		.loginPage("/login/login").permitAll()
//				.loginPage("/login/createUser").permitAll()
		.defaultSuccessUrl("/login/userPortal")
//				.defaultSuccessUrl("/login/userPortal")
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/home").permitAll();


	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("../js/**", "../css/**","/**/*.js", "/**/*.css");
	}
}

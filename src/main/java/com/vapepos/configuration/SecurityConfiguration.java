package com.vapepos.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
			auth.inMemoryAuthentication()
		.withUser("jonmiller44@gmail.com").password("miller").roles("ADMIN", "TRUSTED_CLIENT")
			.and()
		.withUser("john-miller").password("miller").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
            .antMatchers("/**", "/resources/**")
            .permitAll()
            
            .antMatchers("/**")
            .anonymous()
            
            .anyRequest()
            .authenticated()
            .and()
            
        .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
        .logout()
            .permitAll();
	}
}

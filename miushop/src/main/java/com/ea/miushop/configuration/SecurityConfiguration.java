package com.ea.miushop.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ea.miushop.service.impl.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	

	    @Autowired
	    private PasswordEncoder bCryptPasswordEncoder;

	    @Autowired
	    private MyUserDetailsService userDetailsService;



	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	                auth
	                    .userDetailsService(userDetailsService)
	                    .passwordEncoder(bCryptPasswordEncoder);
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {

	        http.
	                authorizeRequests()
	                .antMatchers("/").permitAll()
	                .antMatchers("/login").permitAll()
	                .antMatchers("/registration").permitAll()
	                .antMatchers("/api/admin/**").hasAuthority("ADMIN")
	                .antMatchers("/api/purchaser/**").hasAuthority("PURCHASER")
	                .antMatchers("/api/student/**").hasAuthority("STUDENT").anyRequest()
	                .authenticated().and().csrf().disable().formLogin()
	                .defaultSuccessUrl("/swagger-ui.html")
	                .and().logout()
	                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	                .logoutSuccessUrl("/login").and().exceptionHandling()
	                .accessDeniedPage("/access-denied");
	    }

	    @Override
	    public void configure(WebSecurity web) throws Exception {
	        web
	                .ignoring()
	                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	    }
	    
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	}



package com.rabbit_farm.configurations.security;

import com.rabbit_farm.areas.user.enumerations.UserRole;
import com.rabbit_farm.areas.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	private UserService userService;

	@Autowired
	public SpringSecurityConfig(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(this.userService)
			.passwordEncoder(getBCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers(
						"/",
						"/user/register",
						"/bootstrap/**",
						"/jquery/**",
						"/js/**",
						"/connect/**",
						"/css/**").permitAll()
				.antMatchers("/rabbit/**").hasAuthority(UserRole.WORKER.toString())
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/user/login").permitAll()
				.usernameParameter("email")
				.passwordParameter("password")
//                .and()
//					.rememberMe()
//					.rememberMeCookieName("RememberMeForLaptop")
//					.rememberMeParameter("rememberMe")
//					.key("SlonoMekoHurBestaMarahaKadumba")
//					.tokenValiditySeconds(300)
				.and()
				.logout().logoutSuccessUrl("/user/logout").permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/403")
				.and()
				.csrf().csrfTokenRepository(csrfTokenRepository());
	}

	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository httpSessionCsrfTokenRepository = new HttpSessionCsrfTokenRepository();
		httpSessionCsrfTokenRepository.setSessionAttributeName("_csrf");

		return httpSessionCsrfTokenRepository;
	}
}

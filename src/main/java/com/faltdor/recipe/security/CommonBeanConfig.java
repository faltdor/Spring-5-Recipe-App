package com.faltdor.recipe.security;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CommonBeanConfig {

	@Bean
	public StrongPasswordEncryptor strongEncryptor() {
		return new StrongPasswordEncryptor();
	}
	
	
}

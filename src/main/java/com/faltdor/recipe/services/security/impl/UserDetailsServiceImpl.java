package com.faltdor.recipe.services.security.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.faltdor.recipe.domain.User;
import com.faltdor.recipe.services.impl.UserServiceImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private UserServiceImpl userService;
	
	public UserDetailsServiceImpl(UserServiceImpl userService, Converter<User, UserDetails> userUserDetailsConverter) {
		this.userService = userService;
		this.userUserDetailsConverter = userUserDetailsConverter;
	}

	@Qualifier(value = "userToUserDetails")
    private Converter<User, UserDetails> userUserDetailsConverter;
	

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		return userUserDetailsConverter.convert(userService.findByUserName(name));
	}

}

package com.faltdor.recipe.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faltdor.recipe.domain.User;
import com.faltdor.recipe.repositories.IUserRepository;
import com.faltdor.recipe.services.IUserService;
import com.faltdor.recipe.services.security.impl.EncryptionServiceImpl;

@Service
//@Profile("springdatajpa")
public class UserServiceImpl implements IUserService {
	
	private IUserRepository userRepository;
	private EncryptionServiceImpl encryptionService;
	
	@Autowired
	public UserServiceImpl(IUserRepository userRepository, EncryptionServiceImpl encryptionService) {
		this.userRepository = userRepository;
		this.encryptionService = encryptionService;
	}
	
	
	@Override
	public List<User> listAll() {
		List<User> usersList = new ArrayList<>();
		userRepository.findAll().forEach(usersList::add);
		return usersList;
	}

	@Override
	public User getById(Integer id) {
		Optional<User> userOptional = userRepository.findById(id);
		if(!userOptional.isPresent()) {
			throw new RuntimeException("Can not found user "+id);
		}
		return userOptional.get();
	}

	@Override
	public User saveOrUpdate(User domainObject) {
		if(domainObject.getPassword() != null) {
			domainObject.setEncryptedPassword(encryptionService.encryptString(domainObject.getPassword()));
		}
		return userRepository.save(domainObject);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public User findByUserName(String name) {
		return userRepository.findByUsername(name);
	}

}

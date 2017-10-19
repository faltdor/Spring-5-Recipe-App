package com.faltdor.recipe.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.faltdor.recipe.domain.Role;
import com.faltdor.recipe.domain.User;
import com.faltdor.recipe.repositories.IRoleRepository;
import com.faltdor.recipe.services.IRoleService;

@Service
//@Profile("springdatajpa")
public class RoleServiceImpl implements IRoleService {
	
	private final IRoleRepository roleRepository;
	
	@Autowired
	public RoleServiceImpl(IRoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public List<Role> listAll() {
		List<Role> roles = new ArrayList<>();
		roleRepository.findAll().forEach(roles ::add);
		return roles;
	}

	@Override
	public Role getById(Integer id) {
		Optional<Role> optionalRole = roleRepository.findById(id);
		if(!optionalRole.isPresent()) {
			throw new RuntimeException("Can not found Role "+id);
		}
		return optionalRole.get();
	}

	@Override
	public Role saveOrUpdate(Role domainObject) {
		return roleRepository.save(domainObject);
	}

	@Override
	public void delete(Integer id) {
		roleRepository.deleteById(id);
	}

	@Override
	public Role findByRolename(String role) {
		return roleRepository.findByRole(role);
	}

}

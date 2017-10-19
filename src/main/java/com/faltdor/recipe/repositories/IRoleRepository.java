package com.faltdor.recipe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.faltdor.recipe.domain.Role;

public interface IRoleRepository extends CrudRepository<Role, Integer>{
	public Role findByRole(String roleName);
}

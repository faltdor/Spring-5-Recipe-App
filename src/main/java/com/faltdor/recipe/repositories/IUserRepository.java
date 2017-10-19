package com.faltdor.recipe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.faltdor.recipe.domain.User;

public interface IUserRepository extends CrudRepository<User, Integer> {
	public User findByUsername(String name);
}

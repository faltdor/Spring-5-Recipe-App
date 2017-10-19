package com.faltdor.recipe.services;

import com.faltdor.recipe.domain.User;
import com.faltdor.recipe.services.config.ICRUDService;

public interface IUserService extends ICRUDService<User> {
	User findByUserName(String name);
}

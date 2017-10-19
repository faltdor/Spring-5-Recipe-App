package com.faltdor.recipe.services;

import com.faltdor.recipe.domain.Role;
import com.faltdor.recipe.domain.User;
import com.faltdor.recipe.services.config.ICRUDService;

public interface IRoleService extends ICRUDService<Role> {
	Role findByRolename(String rol);
}

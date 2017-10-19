package com.faltdor.recipe.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.faltdor.recipe.domain.config.AbstractDomainClass;

import lombok.Data;

@Entity
@Data
public class Role extends AbstractDomainClass {
	
	private String role;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "role_id"),
		       inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> users = new HashSet<>();
	
	 public void addUser(User user){
	        if(!this.users.contains(user)){
	            this.users.add(user);
	        }
	 
	        if(!user.getRoles().contains(this)){
	            user.getRoles().add(this);
	        }
	    }
	 
	    public void removeUser(User user){
	        this.users.remove(user);
	        user.getRoles().remove(this);
	    }
}

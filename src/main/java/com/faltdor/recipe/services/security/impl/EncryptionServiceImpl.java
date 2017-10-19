package com.faltdor.recipe.services.security.impl;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faltdor.recipe.services.security.IEncryptionService;

@Service
public class EncryptionServiceImpl  implements IEncryptionService{
	
	private StrongPasswordEncryptor strongEncryptor;
	
	@Autowired
	public EncryptionServiceImpl(StrongPasswordEncryptor strongEncryptor) {
		this.strongEncryptor = strongEncryptor;
	}

	@Override
	public String encryptString(String input) {
		return strongEncryptor.encryptPassword(input);
	}

	@Override
	public boolean checkPassword(String plainPassword, String encryptedPassword) {
		return strongEncryptor.checkPassword(plainPassword, encryptedPassword);
	}


}

package com.faltdor.recipe.services.security;

public interface IEncryptionService {
	String encryptString(String input);
    boolean checkPassword(String plainPassword, String encryptedPassword);
}

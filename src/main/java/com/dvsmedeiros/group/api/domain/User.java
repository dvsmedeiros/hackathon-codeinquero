package com.dvsmedeiros.group.api.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.dvsmedeiros.bce.domain.DomainEntity;

@Component
@Entity
@Table(name = "USERS")
public class User extends DomainEntity {
	
	private String username;
	private String password;
	private String passwordConfirmation;
	private String associationCode;
	private String email;
	private String emailConfirmation;
	
	
	// Verificar o que pode ser recebido na autentica��o utilizando o google e o
	// facebook

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAssociationCode() {
		return associationCode;
	}

	public void setAssociationCode(String associationCode) {
		this.associationCode = associationCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getEmailConfirmation() {
		return emailConfirmation;
	}

	public void setEmailConfirmation(String emailConfirmation) {
		this.emailConfirmation = emailConfirmation;
	}

	

}

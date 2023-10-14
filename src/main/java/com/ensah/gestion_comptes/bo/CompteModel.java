package com.ensah.gestion_comptes.bo;

//Classe model utilisé dans la partie web
//pour recevoir les données de la vue 
//utilisée pour créer les comptes
//C'est une classe non persistante
public class CompteModel {
	
	private String username;
	
	private String password;
	
	private Long roleId;
	
	private Long personId;
	
	
	public CompteModel() {
	}

	public CompteModel(Long personId) {
		this.personId = personId;
	}

	
	public CompteModel(Long roleId, Long personId) {
		this.roleId = roleId;
		this.personId = personId;
	}

	public CompteModel(String username, String password, Long roleId, Long personId) {
		this.username = username;
		this.password = password;
		this.roleId = roleId;
		this.personId = personId;
	}

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

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	
}

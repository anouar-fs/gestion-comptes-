package com.ensah.gestion_comptes.bo;

public class Loger {
	
	private String Login;
	private String password;
	
	
	
	public Loger() {
		
	}
	
	
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Loger [Login=" + Login + ", password=" + password + "]";
	}
	
	
	
	

}

package com.ensah.gestion_comptes.Service;

import java.util.List;

import com.ensah.gestion_comptes.bo.Utilisateur;

public interface IUtilisateurService {
	public void addUser(Utilisateur cUtilisateur);
	
	public void updateUser(Utilisateur cUtilisateur);
	
	public Utilisateur getUser(Long cId);
	
	public void deleteUser(Long cId);
	
	public List<Utilisateur> getUserByIds(List<Long> ids);
	
	public List<Utilisateur> getAllUsers();
	
	public List<Utilisateur> getAllUsersByCin(String cin);
}

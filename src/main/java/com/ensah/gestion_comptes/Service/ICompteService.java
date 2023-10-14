package com.ensah.gestion_comptes.Service;

import java.util.List;

import com.ensah.gestion_comptes.bo.Compte;

public interface ICompteService {

	public void addCompte(Compte cContact);
	
	public void updateCompte(Compte cContact);
	
	public Compte getCompte(Long cId);
	
	public void deleteCompte(Long cId);
	
	public List<Compte> getComptesByIds(List<Long> ids);
	
	public List<Compte> getAllComptes();
	
	public List<Compte> getAllCompteNamesAsc(String buffer);
	
	 Compte SearchLoginAndPassword(String login, String password);
	
}

package com.ensah.gestion_comptes.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.gestion_comptes.Dao.IUtilisateurDao;
import com.ensah.gestion_comptes.bo.Utilisateur;

@Service
@Transactional
public class UtilisateurServiceImpl implements IUtilisateurService{
	
	private IUtilisateurDao utilDao;
	
	
	@Autowired
	public UtilisateurServiceImpl(IUtilisateurDao dao)
	{
		utilDao = dao;
	}


	@Override
	public void addUser(Utilisateur cUtilisateur) {
		utilDao.save(cUtilisateur);
		
	}


	@Override
	public void updateUser(Utilisateur cUtilisateur) {
		utilDao.save(cUtilisateur);
		
	}


	@Override
	public Utilisateur getUser(Long cId) {
		
		return utilDao.findById(cId).get();
	}


	@Override
	public void deleteUser(Long cId) {
		utilDao.deleteById(cId);	
	}


	@Override
	public List<Utilisateur> getUserByIds(List<Long> ids) {
		
		return utilDao.findAllById(ids);
	}


	@Override
	public List<Utilisateur> getAllUsers() {
		return utilDao.findAll();
	}


	@Override
	public List<Utilisateur> getAllUsersByCin(String cin) {
		return utilDao.findAllByCinContaining(cin);
	}
	
	
	
}

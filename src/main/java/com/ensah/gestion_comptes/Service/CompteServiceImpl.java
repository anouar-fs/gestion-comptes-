package com.ensah.gestion_comptes.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.gestion_comptes.Dao.ICompteDao;
import com.ensah.gestion_comptes.bo.Compte;

@Service
@Transactional
public class CompteServiceImpl implements ICompteService {

	private ICompteDao icmpDao;
	
	
	@Autowired
	public CompteServiceImpl(ICompteDao dao)
	{
		icmpDao = dao;
	}
	
	@Override
	public void addCompte(Compte cCompte) {
		icmpDao.save(cCompte);
	}

	@Override
	public void updateCompte(Compte cCompte) {
		icmpDao.save(cCompte);
	}

	@Override
	public Compte getCompte(Long cId) {
		Compte cmpt = icmpDao.findById(cId).get();
		return cmpt;
	}

	@Override
	public void deleteCompte(Long cId) {
		icmpDao.deleteById(cId);;
		
	}

	@Override
	public List<Compte> getComptesByIds(List<Long> ids) {
		 return icmpDao.findAllById(ids);
	}

	@Override
	public List<Compte> getAllComptes() {
		
		return icmpDao.findAll();
	}
	
	@Override
	public List<Compte> getAllCompteNamesAsc(String buffer){
		return icmpDao.findAllByLoginContainingOrderByLoginAsc(buffer) ;
	}

	@Override
	public Compte SearchLoginAndPassword(String login, String password) {

		return icmpDao.findByLoginAndPassword(login,password);
	}
}

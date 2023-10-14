package com.ensah.gestion_comptes.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ensah.gestion_comptes.bo.*;


public interface ICompteDao extends JpaRepository<Compte,Long> {
	List<Compte> findAllByLoginContainingOrderByLoginAsc(String Login);
	 Compte findByLoginAndPassword(String login, String password);
}

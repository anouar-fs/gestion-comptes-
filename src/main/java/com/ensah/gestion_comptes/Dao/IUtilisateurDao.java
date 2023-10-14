package com.ensah.gestion_comptes.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ensah.gestion_comptes.bo.Utilisateur;

public interface IUtilisateurDao  extends JpaRepository<Utilisateur,Long> {
	List<Utilisateur> findAllByCinContaining(String cin);
}

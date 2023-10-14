package com.ensah.gestion_comptes.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ensah.gestion_comptes.bo.*;

public interface IRoleDao extends JpaRepository<Role,Long> {
	
}

package com.ensah.gestion_comptes.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.gestion_comptes.Dao.IRoleDao;
import com.ensah.gestion_comptes.bo.Role;


@Service
@Transactional
public class RoleServiceImpl implements IRoleService{

	private IRoleDao iroledao;
	
	
	@Autowired
	public RoleServiceImpl(IRoleDao dao)
	{
		iroledao = dao;
	}
	@Override
	public void addRole(Role cRole) {
		iroledao.save(cRole);
	}

	@Override
	public void updateRole(Role cRole) {
		iroledao.save(cRole);
		
	}

	@Override
	public Role getRole(Long cId) {
		
		return iroledao.findById(cId).get();
	}

	@Override
	public void deleteRole(Long cId) {
		
		iroledao.deleteById(cId);
	}

	@Override
	public List<Role> getRoleByIds(List<Long> ids) {
		
		return iroledao.findAllById(ids);
	}

	@Override
	public List<Role> getAllRoles() {
		
		return iroledao.findAll();
	}

}

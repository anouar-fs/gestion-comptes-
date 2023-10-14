package com.ensah.gestion_comptes.Service;

import java.util.List;

import com.ensah.gestion_comptes.bo.Role;

public interface IRoleService {

	public void addRole(Role cContact);
	
	public void updateRole(Role cContact);
	
	public Role getRole(Long cId);
	
	public void deleteRole(Long cId);
	
	public List<Role> getRoleByIds(List<Long> ids);
	
	public List<Role> getAllRoles();
}

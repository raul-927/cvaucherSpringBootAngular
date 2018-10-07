package uy.com.cvaucher.services.services;

import java.util.List;

import uy.com.cvaucher.services.domain.Roles;



public interface RolesService {
	
	void 		insertRole(Roles roles);
	void 		updateRole(Roles roles);
	void 		deleteRole(Roles roles);
	List<Roles> showAllRoles();
	Roles 		showRoleById(int rolId);
	

}

package uy.com.cvaucher.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uy.com.cvaucher.services.domain.Roles;
import uy.com.cvaucher.services.mybatis.mappers.RolesMapper;
import uy.com.cvaucher.services.services.RolesService;

@Service("rolesService")
@Transactional
public class RolesServiceImpl implements RolesService{
	@Autowired
	private RolesMapper rolesMapper;
	@Override
	
	public void insertRole(Roles roles) {
		String aux = "ROLE_".concat(roles.getRolName().toUpperCase());
		roles.setRolName(aux);
		rolesMapper.insertRole(roles);
	}

	@Override
	public void updateRole(Roles roles) {

		rolesMapper.updateRole(roles);
		
	}

	@Override
	public void deleteRole(Roles roles) {
		rolesMapper.deleteRole(roles);
		
	}

	@Override
	public List<Roles> showAllRoles() {
		List<Roles> roles = rolesMapper.showAllRoles();
		return roles;
	}

	@Override
	public Roles showRoleById(int rolId) {
		Roles roles = rolesMapper.showRoleById(rolId);
		return roles;
	}

}

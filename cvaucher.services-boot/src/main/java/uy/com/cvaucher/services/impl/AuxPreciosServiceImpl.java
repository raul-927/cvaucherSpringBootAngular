package uy.com.cvaucher.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uy.com.cvaucher.services.domain.AuxPrecios;
import uy.com.cvaucher.services.mybatis.mappers.AuxPreciosMapper;
import uy.com.cvaucher.services.services.AuxPreciosService;

@Service("auxPreciosService")
@Transactional
//@PreAuthorize("hasRole('ROLE_ADMIN') or (hasRole('ROLE_USER') and authentication.name == 'gaby')")
public class AuxPreciosServiceImpl implements AuxPreciosService 
{
	@Autowired
	private AuxPreciosMapper auxPreciosMapper;

	@Override
	public List<AuxPrecios> findAllAuxPrecios() 
	{
		// TODO Auto-generated method stub
		return this.auxPreciosMapper.findAllAuxPrecios();
	}

	@Override
	public void insertAuxPrecios(AuxPrecios auxPrecios) 
	{
		this.auxPreciosMapper.insertAuxPrecios(auxPrecios);

	}

}

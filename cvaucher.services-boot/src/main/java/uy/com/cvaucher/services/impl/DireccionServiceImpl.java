package uy.com.cvaucher.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uy.com.cvaucher.services.domain.Direccion;
import uy.com.cvaucher.services.mybatis.mappers.DireccionMapper;
import uy.com.cvaucher.services.services.DireccionService;

@Service("direccionService")
@Transactional
//@PreAuthorize("hasRole('ROLE_ADMIN') or (hasRole('ROLE_USER') and authentication.name == 'gaby')")
public class DireccionServiceImpl implements DireccionService
{
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DireccionMapper direccionMapper;
	
	@Override
	public List<Direccion> findAllDireccion()
	{
		List<Direccion> direccion = direccionMapper.findAllDireccion();
		return direccion;
	}
	
	@Override
	public List<Direccion> findDireccionByCedula(int pacCedula)
	{
		
		logger.debug("findDireccionById :"+pacCedula);
		
		List <Direccion> direccion = direccionMapper.findDireccionByCedula(pacCedula);
		return direccion;
	}
	
	@Override
	public void insertDireccion(Direccion direccion)
	{
		
		direccionMapper.insertDireccion(direccion);
	}
	
	@Override
	public void updateDireccion(Direccion direccion)
	{
		direccionMapper.updateDireccion(direccion);
		
	}
	
	@Override
	public void deleteDireccion(int dirId)
	{
		direccionMapper.deleteDireccion(dirId);
	}

	@Override
	public List<Direccion> findDireccionById(int dirId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

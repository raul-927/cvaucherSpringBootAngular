package uy.com.cvaucher.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uy.com.cvaucher.services.domain.Impuesto;
import uy.com.cvaucher.services.mybatis.mappers.ImpuestoMapper;
import uy.com.cvaucher.services.services.ImpuestoService;



@Service("impuestoService")
@Transactional
public class ImpuestoServiceImpl implements ImpuestoService {
	
	@Autowired
	private ImpuestoMapper impuestoMapper;

	@Override
	public List<Impuesto> findAllImpuestos() {
		// TODO Auto-generated method stub
		return this.impuestoMapper.findAllImpuestos();
	}

	@Override
	public Impuesto findImpuestoById(int impuestoId) {
		// TODO Auto-generated method stub
		return this.impuestoMapper.findImpuestoById(impuestoId);
	}

	@Override
	public void insertImpuesto(Impuesto impuesto) {
		
		this.impuestoMapper.insertImpuesto(impuesto);

	}

	@Override
	public List<Impuesto> findAllImpuestosByTipo(String impuestoTipo) {
		// TODO Auto-generated method stub
		return this.impuestoMapper.findAllImpuestosByTipo(impuestoTipo);
	}

}

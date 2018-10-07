package uy.com.cvaucher.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uy.com.cvaucher.services.domain.Caja;
import uy.com.cvaucher.services.mybatis.mappers.CajaMapper;
import uy.com.cvaucher.services.services.CajaService;

@Service("cajaService")
@Transactional
public class CajaServiceImpl implements CajaService {
	
	@Autowired
	private CajaMapper cajaMapper;
	
	@Override
	public Caja aperturaCaja() {
		Caja caja = this.cajaMapper.aperturaCaja();
		return caja;
	}

	@Override
	public void insertarCaja(Caja caja) {
		this.cajaMapper.insertarCaja(caja);

	}

	@Override
	public void cerrarCaja(Caja caja) {
		this.cajaMapper.cerrarCaja(caja);

	}

	@Override
	public Caja cargoCajaActual() {
		// TODO Auto-generated method stub
		return this.cajaMapper.cargoCajaActual();
	}

}

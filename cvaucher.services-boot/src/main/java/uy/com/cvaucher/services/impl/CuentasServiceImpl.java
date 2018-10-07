package uy.com.cvaucher.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uy.com.cvaucher.services.domain.Cuentas;
import uy.com.cvaucher.services.mybatis.mappers.CuentasMapper;
import uy.com.cvaucher.services.services.CuentasService;

@Service("cuentasService")
@Transactional
//@PreAuthorize("hasRole('ROLE_ADMIN') or (hasRole('ROLE_USER') and authentication.name == 'gaby')")
public class CuentasServiceImpl implements CuentasService 
{
	
	@Autowired
	private CuentasMapper cuentasMapper;

	@Override
	public void insertCuenta(Cuentas cuentas) {
		this.cuentasMapper.insertCuenta(cuentas);
		
	}

	@Override
	public Cuentas selectCuentaByCuentaDesc(String cuentaDesc) {
		
		return this.cuentasMapper.selectCuentaByCuentaDesc(cuentaDesc);
	}

	@Override
	public Cuentas selectCuentaByCuentaId(int cuentaId) {
		
		return this.cuentasMapper.selectCuentaByCuentaId(cuentaId);
	}

	@Override
	public Cuentas selectCuentaByFecha(Date cuentaFecha) {
		
		return this.cuentasMapper.selectCuentaByFecha(cuentaFecha);
	}

	@Override
	public Cuentas selectCuentaByHora(Date cuentaHora) {
		
		return this.cuentasMapper.selectCuentaByHora(cuentaHora);
	}
/*
	@Override
	public Cuentas selectCuentaByFechaHora(Date cuentaFecha, Date cuentaHora) {
		
		return this.cuentasMapper.selectCuentaByFechaHora(cuentaFecha, cuentaHora);
	}
*/
	@Override
	public List<Cuentas> selectAllCuentas() {
		
		return this.cuentasMapper.selectAllCuentas();
	}

@Override
public List<Cuentas> selectAllCuentasByGrupo(ArrayList<Integer> grupoCuentaId) {
	StringBuilder aux = new StringBuilder();
	Iterator<Integer> it = grupoCuentaId.iterator();
	while(it.hasNext()){
		aux.append(it.next()+",");
	}
	aux.deleteCharAt(aux.length()-1);
	String resultado = String.valueOf(aux);
	return this.cuentasMapper.selectAllCuentasByGrupo(resultado);
}
	
	
}

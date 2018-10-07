package uy.com.cvaucher.services.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import uy.com.cvaucher.services.domain.Cuentas;

public interface CuentasService {
	void insertCuenta(Cuentas cuentas);
	Cuentas selectCuentaByCuentaDesc(String cuentaDesc);
	Cuentas selectCuentaByCuentaId(final int cuentaId);
	Cuentas selectCuentaByFecha(Date cuentaFecha);
	Cuentas selectCuentaByHora(Date cuentaHora);
	//Cuentas selectCuentaByFechaHora(Date cuentaFecha, Date cuentaHora);
	List<Cuentas> selectAllCuentas();
	List<Cuentas> selectAllCuentasByGrupo(ArrayList<Integer> grupoCuentaId);
	

}

package uy.com.cvaucher.services.services;

import java.util.List;

import uy.com.cvaucher.services.clases.FormasDePagosDesc;
import uy.com.cvaucher.services.clases.MaxNumAsientoContable;
import uy.com.cvaucher.services.clases.ResumenPorCuentas;
import uy.com.cvaucher.services.domain.AsientoContable;
import uy.com.cvaucher.services.domain.AsientoContableMap;
import uy.com.cvaucher.services.domain.ResultadoCuentaAsientoTotal;
import uy.com.cvaucher.services.domain.TratamientoPaciente;

public interface AsientoContableService {
	
	ResultadoCuentaAsientoTotal cuentaAsientoTotal();
	List<ResultadoCuentaAsientoTotal> cuentasAsientoTotal();
	void ingresarAsientoContable(Object formaDePago,TratamientoPaciente tratamientoPaciente, FormasDePagosDesc formasDePagoDesc);
	MaxNumAsientoContable maxNumAsientoContable();
	MaxNumAsientoContable cantRegistros();
	List<ResumenPorCuentas> resumenPorCuentas(int cuentaTipo);
	List<ResumenPorCuentas> resumenPorCuentasTotalPorCaja(String cuentaTipo, int idCaja);
	List<AsientoContable> showAsientoContable(AsientoContable asientoContable);
	List<AsientoContable> showAsientoContableByAsConNro(int asConNro);
}

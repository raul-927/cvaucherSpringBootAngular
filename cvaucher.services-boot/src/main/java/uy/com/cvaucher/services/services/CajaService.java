package uy.com.cvaucher.services.services;

import uy.com.cvaucher.services.domain.Caja;

public interface CajaService {
	Caja aperturaCaja();
	void insertarCaja(Caja caja);
	void cerrarCaja(Caja caja);
	Caja cargoCajaActual();
}

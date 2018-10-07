package uy.com.cvaucher.services.services;

import java.util.List;

import uy.com.cvaucher.services.domain.GrupoCuentas;

public interface GrupoCuentasService {
	
	void insertGrupoCuentas(GrupoCuentas grupoCuentas);
	List<GrupoCuentas> showAllGrupoCuentas();
}

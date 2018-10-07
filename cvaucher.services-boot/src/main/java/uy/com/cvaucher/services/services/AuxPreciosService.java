package uy.com.cvaucher.services.services;

import java.util.List;

import uy.com.cvaucher.services.domain.AuxPrecios;

public interface AuxPreciosService {
	
	List<AuxPrecios> findAllAuxPrecios();
	void insertAuxPrecios(AuxPrecios auxPrecios);

}

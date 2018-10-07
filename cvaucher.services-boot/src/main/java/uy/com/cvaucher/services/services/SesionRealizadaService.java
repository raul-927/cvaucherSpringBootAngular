package uy.com.cvaucher.services.services;

import java.util.List;

import uy.com.cvaucher.services.domain.SesionRealizada;

public interface SesionRealizadaService 
{
	
	List<SesionRealizada> findAllSesionRealizada();
	SesionRealizada findSesionRealizadaById(int sesRealizadaId);
	void insertSesionRealizada(SesionRealizada sesionRealizada);
	void updateSesionRealizada(SesionRealizada sesionRealizada);
	void deleteSesionRealizada(int sesRealizadaId);
	

}

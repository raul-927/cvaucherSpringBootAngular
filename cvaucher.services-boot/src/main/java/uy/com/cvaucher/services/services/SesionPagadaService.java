package uy.com.cvaucher.services.services;

import java.util.List;

import uy.com.cvaucher.services.domain.SesionPagada;

public interface SesionPagadaService 
{
	
	List<SesionPagada> findAllSesionPagada();
	SesionPagada findSesionById(int sesPagoId);
	void insertSesionPagada(SesionPagada sesionPagada);
	void updateSesionPagada(SesionPagada sesionPagada);
	void deleteSesionPagada(int sesPagoId);
	

}

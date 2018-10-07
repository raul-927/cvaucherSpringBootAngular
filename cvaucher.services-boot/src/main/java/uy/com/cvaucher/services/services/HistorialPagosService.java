package uy.com.cvaucher.services.services;

import java.util.List;

import uy.com.cvaucher.services.domain.HistorialPagos;

public interface HistorialPagosService 
{
	List<HistorialPagos> findHistorialPagoByHistTratPacId(int histTratPacId);
	
	void insertHistorialPago(HistorialPagos historialPagos);

}

package uy.com.cvaucher.services.services;

import java.util.List;


import uy.com.cvaucher.services.domain.TipoTratamiento;


public interface TipoTratamientoService {
	
	List<TipoTratamiento> findAllTipoTratamiento();
	TipoTratamiento findTipoTratamientoById(Integer tipTratId);
	void createTipoTratamiento(TipoTratamiento tipoTratamiento);
	void updateTipoTratamiento(TipoTratamiento tipoTratamiento);
	void deleteTipoTratamiento(int tipTratId);
	void deleteTipoTratamientoByDesc(String tipTratDesc);

}

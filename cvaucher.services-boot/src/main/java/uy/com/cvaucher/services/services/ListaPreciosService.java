package uy.com.cvaucher.services.services;


import java.util.List;

import uy.com.cvaucher.services.domain.AuxPrecios;
import uy.com.cvaucher.services.domain.ListPrecTratDesc;
import uy.com.cvaucher.services.domain.ListaPrecios;
import uy.com.cvaucher.services.domain.ListaPreciosArray;
import uy.com.cvaucher.services.domain.MaxIdListaPrecios;

public interface ListaPreciosService {

	
	List<ListaPrecios> findAllListaPrecios();
	List<ListaPrecios> findListaPreciosById(Integer listPrecId);
	ListaPrecios findActualListaPrecios();
	List<ListPrecTratDesc> findListaPreciosTratDescById(int listPrecId);
	void insertListaPrecios(ListaPreciosArray listaPreciosArray);
	void updateListaPrecios(ListaPrecios listaPrecios);
	void deleteListaPrecios(Integer listPrecId);
	MaxIdListaPrecios findMaxIdListaPrecios();
	
	void insertAuxPrecios(AuxPrecios auxPrecios);
}

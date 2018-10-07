package uy.com.cvaucher.services.services;

import java.util.List;

import uy.com.cvaucher.services.domain.TipoAgenda;

public interface TipoAgendaService 
{
	
	public List<TipoAgenda> findAllTipoAgenda();
	public TipoAgenda findTipoAgendaById(int tpoAgId);
	public void insertTipoAgenda(TipoAgenda tipoAgenda);
	public void updateTipoAgenda(TipoAgenda tipoAgenda);
	public void deleteTipoAgenda(int tpoAgId);

}

package uy.com.cvaucher.services.services;

import java.util.List;

import uy.com.cvaucher.services.domain.PagoEfectivo;

public interface PagoEfectivoService 
{
	void insertPagoEfectivo(PagoEfectivo pagoEfectivo);
	List<PagoEfectivo> showPagoEfectivoByCaja(int idCaja, String cuenta);

}

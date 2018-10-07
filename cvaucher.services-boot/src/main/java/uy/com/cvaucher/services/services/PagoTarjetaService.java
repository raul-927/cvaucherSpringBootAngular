package uy.com.cvaucher.services.services;

import java.util.List;

import uy.com.cvaucher.services.domain.PagoTarjeta;

public interface PagoTarjetaService 
{
	void insertPagoTarjeta(PagoTarjeta pagoTarjeta);
	List<PagoTarjeta> showPagoTarjetaByCaja(int idCaja, String cuenta);

}

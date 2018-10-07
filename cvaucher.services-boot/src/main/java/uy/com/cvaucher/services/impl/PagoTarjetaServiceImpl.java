package uy.com.cvaucher.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uy.com.cvaucher.services.domain.PagoTarjeta;
import uy.com.cvaucher.services.mybatis.mappers.PagoTarjetaMapper;
import uy.com.cvaucher.services.services.PagoTarjetaService;

@Service("pagoTarjetaService")
@Transactional
public class PagoTarjetaServiceImpl implements PagoTarjetaService 
{
	@Autowired
	private PagoTarjetaMapper pagoTarjetaMapper;
	
	@Override
	public void insertPagoTarjeta(PagoTarjeta pagoTarjeta) 
	{
		this.pagoTarjetaMapper.insertPagoTarjeta(pagoTarjeta);

	}

	@Override
	public List<PagoTarjeta> showPagoTarjetaByCaja(int idCaja, String cuenta) {

		return this.pagoTarjetaMapper.showPagoTarjetaByCaja(idCaja, cuenta);
	}

}

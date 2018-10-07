package uy.com.cvaucher.services.impl;

import java.util.List;

import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uy.com.cvaucher.services.domain.PagoEfectivo;
import uy.com.cvaucher.services.mybatis.mappers.PagoEfectivoMapper;
import uy.com.cvaucher.services.services.PagoEfectivoService;


@Service("pagoEfectivoService")
@Transactional
public class PagoEfectivoServiceImpl implements PagoEfectivoService 
{

	@Autowired
	private PagoEfectivoMapper pagoEfectivoMapper;
	
	@Override
	public void insertPagoEfectivo(PagoEfectivo pagoEfectivo) 
	{
		this.pagoEfectivoMapper.insertPagoEfectivo(pagoEfectivo);
	}

	@Override
	public List<PagoEfectivo> showPagoEfectivoByCaja(int idCaja, String cuenta) {
		 return this.pagoEfectivoMapper.showPagoEfectivoByCaja(idCaja, cuenta);
	}

}

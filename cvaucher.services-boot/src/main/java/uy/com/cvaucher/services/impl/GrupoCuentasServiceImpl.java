package uy.com.cvaucher.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uy.com.cvaucher.services.domain.GrupoCuentas;
import uy.com.cvaucher.services.mybatis.mappers.GrupoCuentasMapper;
import uy.com.cvaucher.services.services.GrupoCuentasService;


@Service("grupoCuentasService")
@Transactional
public class GrupoCuentasServiceImpl implements GrupoCuentasService {
	@Autowired
	private GrupoCuentasMapper grupoCuentasMapper;
	
	@Override
	public void insertGrupoCuentas(GrupoCuentas grupoCuentas) {

		this.grupoCuentasMapper.insertGrupoCuentas(grupoCuentas);

	}

	@Override
	public List<GrupoCuentas> showAllGrupoCuentas() {
		
		return this.grupoCuentasMapper.showAllGrupoCuentas();
	}

}

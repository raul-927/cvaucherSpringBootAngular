package uy.com.cvaucher.services.mybatis.mappers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import uy.com.cvaucher.services.domain.Cuentas;
import uy.com.cvaucher.services.mybatis.sql.SqlCuentasProvider;

public interface CuentasMapper {
	
	
	@InsertProvider(type = SqlCuentasProvider.class, method ="insertCuenta")
	@Options(useGeneratedKeys=true, keyProperty="cuentaId") 
	void insertCuenta(Cuentas cuentas);
	
	@SelectProvider(type = SqlCuentasProvider.class, method ="selectCuentaByCuentaDesc")
	@ResultMap("uy.com.cvaucher.services.mybatis.mappers.CuentasMapper.CuentasResult")
	Cuentas selectCuentaByCuentaDesc(String cuentaDesc);
	
	@SelectProvider(type = SqlCuentasProvider.class, method ="selectCuentaByCuentaId")
	@ResultMap("uy.com.cvaucher.services.mybatis.mappers.CuentasMapper.CuentasResult")
	Cuentas selectCuentaByCuentaId(final int cuentaId);
	
	@SelectProvider(type = SqlCuentasProvider.class, method ="selectCuentaByFecha")
	@ResultMap("uy.com.cvaucher.services.mybatis.mappers.CuentasMapper.CuentasResult")
	Cuentas selectCuentaByFecha(Date cuentaFecha);
	
	@SelectProvider(type = SqlCuentasProvider.class, method ="selectCuentaByHora")
	@ResultMap("uy.com.cvaucher.services.mybatis.mappers.CuentasMapper.CuentasResult")
	Cuentas selectCuentaByHora(Date cuentaHora);
	
	@SelectProvider(type = SqlCuentasProvider.class, method ="selectCuentaByGrupo")
	@ResultMap("uy.com.cvaucher.services.mybatis.mappers.CuentasMapper.CuentasResult")
	List<Cuentas> selectAllCuentasByGrupo(String grupoCuentaId);
	
	@SelectProvider(type = SqlCuentasProvider.class, method ="selectAllCuentas")
	@ResultMap("uy.com.cvaucher.services.mybatis.mappers.CuentasMapper.CuentasResult")
	List<Cuentas> selectAllCuentas();
	

}

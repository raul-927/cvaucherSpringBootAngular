package uy.com.cvaucher.services.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import uy.com.cvaucher.services.domain.HistorialPagos;
import uy.com.cvaucher.services.mybatis.sql.SqlHistorialPagosProvider;

public interface HistorialPagosMapper 
{
	@SelectProvider(type= SqlHistorialPagosProvider.class, method="findHistorialPagoByHistTratPacId")
	@ResultMap("uy.com.cvaucher.services.mybatis.mappers.HistorialPagosMapper.HistorialPagosResult")
	List<HistorialPagos> findHistorialPagoByHistTratPacId(@Param("histTratPacId")Integer histTratPacId);
	
	@InsertProvider(type =SqlHistorialPagosProvider.class, method ="insertHistorialPago")
	@Options(useGeneratedKeys=true, keyProperty="histPagosId")
	void insertHistorialPago(HistorialPagos historialPagos);
}

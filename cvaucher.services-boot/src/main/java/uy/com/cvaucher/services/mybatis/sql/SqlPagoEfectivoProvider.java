package uy.com.cvaucher.services.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import uy.com.cvaucher.services.domain.PagoCredito;
import uy.com.cvaucher.services.domain.PagoEfectivo;

public class SqlPagoEfectivoProvider {
	
	public String insertPagoEfectivo(Object pago){
		String sql ="";
		if(pago instanceof PagoEfectivo) {
			sql= new SQL(){{
				INSERT_INTO("pago_efectivo");
				VALUES("pago_ef_id",		  String.valueOf(((PagoEfectivo) pago).getEfId()));
				VALUES("pago_ef_caja_id",	  String.valueOf(((PagoEfectivo) pago).getPagoEfCajaId()));
				VALUES("pago_ef_asiento_nro", String.valueOf(((PagoEfectivo) pago).getAsientoNro()));
				VALUES("pago_ef_cedula",	  String.valueOf(((PagoEfectivo) pago).getPagoEfCedula()));
				VALUES("pago_ef_importe",	  String.valueOf(((PagoEfectivo) pago).getPagoEfImporte()));
				VALUES("pago_ef_cuenta",	  "'".concat(((PagoEfectivo) pago).getPagoEfCuenta()).concat("'"));
				VALUES("pago_ef_desc",		  "'".concat(((PagoEfectivo) pago).getPagoEfDesc()).concat("'"));
			}}.toString();
		}
		else if(pago instanceof PagoCredito){
			sql= new SQL(){{
				INSERT_INTO("pago_efectivo");
				VALUES("pago_ef_id",		  String.valueOf(((PagoCredito) pago).getCredId()));
				VALUES("pago_ef_caja_id",	  String.valueOf(((PagoCredito) pago).getPagoCredCajaId()));
				VALUES("pago_ef_asiento_nro", String.valueOf(((PagoCredito) pago).getAsientoNro()));
				VALUES("pago_ef_cedula",	  String.valueOf(((PagoCredito) pago).getPagoCredCedula()));
				VALUES("pago_ef_importe",	  String.valueOf(((PagoCredito) pago).getPagoCredImporte()));
				VALUES("pago_ef_cuenta",	  "'".concat(((PagoCredito) pago).getPagoCredCuenta()).concat("'"));
				VALUES("pago_ef_desc",		  "'".concat(((PagoCredito) pago).getPagoCredDesc()).concat("'"));
			}}.toString();
		}

		return sql;
	}
	
	public String showPagoEfectivoByCaja(){
		return new SQL(){{
			SELECT("ef_id, pago_ef_id, pago_ef_caja_id, pago_ef_asiento_nro, pago_ef_cedula, pago_ef_importe, pago_ef_cuenta, pago_ef_desc, pago_ef_usuario");
			FROM("pago_efectivo");
			WHERE("pago_ef_caja_id = #{idCaja}");
			WHERE("pago_ef_cuenta = #{cuenta}");
		}}.toString();
		
	}

}

package uy.com.cvaucher.services.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import uy.com.cvaucher.services.domain.PagoEfectivo;

public class SqlPagoEfectivoProvider {
	public String insertPagoEfectivo(PagoEfectivo pagoEfectivo){
		return new SQL(){{
			INSERT_INTO("pago_efectivo");
			VALUES("pago_ef_id","#{pagoEfId}");
			VALUES("pago_ef_caja_id","#{pagoEfCajaId}");
			VALUES("pago_ef_asiento_nro","#{asientoNro}");
			VALUES("pago_ef_cedula","#{pagoEfCedula}");
			VALUES("pago_ef_importe","#{pagoEfImporte}");
			VALUES("pago_ef_cuenta","#{pagoEfCuenta}");
			VALUES("pago_ef_desc","#{pagoEfDesc}");
		}}.toString();
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

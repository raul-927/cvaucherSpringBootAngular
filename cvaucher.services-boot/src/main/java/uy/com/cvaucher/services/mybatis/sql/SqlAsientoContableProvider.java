package uy.com.cvaucher.services.mybatis.sql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import uy.com.cvaucher.services.domain.AsientoContable;

public class SqlAsientoContableProvider {
	
	public String cuentaAsientoTotal(){
		return new SQL(){{
			SELECT("c.cuenta_desc Cuenta, SUM(a.as_cuenta_debeMonto - a.as_cuenta_haberMonto) Total"); 	 
			FROM("asiento_contable a, cuentas c"); 		 
			WHERE("a.as_cuenta_debe = c.cuenta_id"); 	
			WHERE("as_cuenta_haber	= c.cuenta_id");
			WHERE("c.cuenta_id = #{cuentaId}");
			WHERE("a.as_con_fecha = #{asConFecha}");
		}}.toString();
	}
	
	public String cuentasAsientoTotal(){
		return new SQL(){{
			SELECT("c.cuenta_desc Cuenta, SUM(a.as_cuenta_debeMonto - a.as_cuenta_haberMonto) Total"); 	 
			FROM("asiento_contable a, cuentas c"); 		 
			WHERE("a.as_cuenta_debe = c.cuenta_id"); 	
			WHERE("as_cuenta_haber	= c.cuenta_id");
			WHERE("a.as_con_fecha = #{asConFecha}");
			GROUP_BY("Cuenta");
		}}.toString();
	}
	
	public String ingresarAsientoContable(final AsientoContable asientoContable){
		 
		String sql = new SQL(){{
			INSERT_INTO("asiento_contable");
			VALUES("as_con_caja_id",		String.valueOf(asientoContable.getCaja().getCajaId()));
			VALUES("as_con_nro",			String.valueOf(asientoContable.getAsConNro()));
			VALUES("as_cuenta_debe",		String.valueOf(asientoContable.getAsCuentaDebe().getCuentaId()));
			VALUES("as_cuenta_debeMonto",	String.valueOf(asientoContable.getAsCuentaDebeMonto()));
			VALUES("as_cuenta_haber",		String.valueOf(asientoContable.getAsCuentaHaber().getCuentaId()));
			VALUES("as_cuenta_haberMonto",	String.valueOf(asientoContable.getAsCuentaHaberMonto()));
			VALUES("as_cuenta_tipo",		"'".concat(String.valueOf(asientoContable.getAsCuentaTipo()).concat("'")));
			VALUES("as_con_descripcion",	"'".concat(String.valueOf(asientoContable.getAsConDescripcion())).concat("'"));
			VALUES("as_con_fecha",			String.valueOf(asientoContable.getAsConFecha()));
			VALUES("as_con_hora",			String.valueOf(asientoContable.getAsConHora()));
			VALUES("as_con_usr",			String.valueOf(asientoContable.getAsConUsr()));
			
		}}.toString();
		return sql;
	}
	
	public String maxNumAsiento(){
		return new SQL(){{
			SELECT("MAX(as_con_nro)+1 max_num");
			FROM("asiento_contable");
		}}.toString();
	}
	
	public String cantRegistros(){
		return new SQL(){{
			SELECT("COUNT(1) max_num");
			FROM("asiento_contable");
		}}.toString();
	}
	
	public String showAsientoContable(final AsientoContable asientoContable){
		return new SQL(){{
			SELECT("as_con_id, as_con_caja_id, as_con_nro, as_cuenta_debe, as_cuenta_debeMonto, "
					+ "as_cuenta_haber, as_cuenta_haberMonto, as_cuenta_tipo, as_con_descripcion, "
					+ "as_con_fecha");
			FROM("asiento_contable");
			if(asientoContable.getAsContId()>0){
				WHERE("as_con_id = #{asConId}");
			}
			if(asientoContable.getCaja().getCajaId()>0){
				WHERE("as_con_caja_id = #{cajaId}");
			}
			if(asientoContable.getAsConNro()>0){
				WHERE("as_con_nro = #{asConNro}");
			}
			if(!asientoContable.getAsCuentaDebe().equals(null)||!asientoContable.getAsCuentaDebe().equals("")){
				WHERE("as_cuenta_debe = #{asCuentaDebe}");
			}
			if(!asientoContable.getAsCuentaHaber().equals(null)||!asientoContable.getAsCuentaHaber().equals("")){
				WHERE("as_cuenta_haber = #{asCuentaHaber}");
			}
		}}.toString();
	}
	public String showAsientoContableByAsConNro(Map<String, Object>map){
		int asConNro = Integer.parseInt(map.get("asConNro").toString());
		return new SQL(){{
			SELECT("a.as_con_id as CON_ID, a.as_con_caja_id as CAJA_ID, a.as_con_nro as NRO, "
					+ "c.cuenta_desc as DEBE, a.as_cuenta_debeMonto as DEBE_MONTO, "
					+ "c.cuenta_desc as HABER, a.as_cuenta_haberMonto as HABER_MONTO, "
					+ "a.as_cuenta_tipo as TIPO, a.as_con_descripcion as DESCRIPCION, "
					+ "a.as_con_fecha as FECHA, a.as_con_hora as HORA, a.as_con_usr as USR");
			FROM("asiento_contable a, cuentas c");
			WHERE("a.as_cuenta_debe = c.cuenta_id");
			WHERE("a.as_cuenta_haber = c.cuenta_id");
			WHERE("a.as_con_nro = "+asConNro);
		}}.toString();
	}
}

package uy.com.cvaucher.services.mybatis.sql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
public class SqlTratamientoProvider 
{
	
	public String finTratamientoById() {
		return new SQL(){{
			SELECT("t.trat_id, t.trat_tpo_id, t.trat_descripcion, t.trat_cant_sesiones, i.impuesto_id, i.impuesto_desc, i.impuesto_desc_abrv, i.impuesto_valor, i.impuesto_tipo, c.cuenta_id");
			FROM("tratamiento t, impuesto i, cuentas c");
			WHERE("t.trat_ipuesto_id = i.impuesto_id");
			WHERE("i.impuesto_cuenta = c.cuenta_id");
			WHERE("t.trat_id = #{t.tratId}");
			
		}}.toString();
	}
	
	public String findAllTratamientos() {
		return new SQL(){{
			SELECT("t.trat_id, tt.tip_trat_descripcion, trat_descripcion, trat_cant_sesiones, i.impuesto_desc_abrv");
			FROM("tratamiento t, tipo_tratamiento tt, impuesto i");
			WHERE("t.trat_ipuesto_id = i.impuesto_id");
			WHERE("t.trat_tpo_id = tt.tip_trat_id");
			ORDER_BY("trat_id");
		}}.toString();
	}
	
	public String findSesionesByTratamientoId(Map<String, Object>map) {
		int tratId = Integer.parseInt(map.get("tratId").toString());
		return new SQL(){{
			SELECT("trat.trat_id ID, trat.trat_descripcion DESCRIPCION, trat.trat_cant_sesiones CANT_SESIONES, lis.list_prec_monto MONTO");
			FROM("tratamiento trat, lista_precios lis, aux_precios aux");
			WHERE("trat.trat_id = lis.list_prec_id_trat ");
			WHERE("trat.trat_id ="+tratId);
			WHERE("lis.list_prec_id = aux.aux_prec_id_list");
			WHERE("current_date() BETWEEN aux.aux_prec_fech_ini AND aux.aux_prec_fech_fin");
			OR();
			WHERE("current_date() > aux.aux_prec_fech_ini");
			WHERE("aux.aux_prec_fech_fin = '0000-00-00'");
		}}.toString();
		
	}
	
	public String findTratamientoByActualListById(int tratId) {
		return new SQL(){{
			
		}}.toString();
	}
	
	public String findAllTratamientoByActualList() {
		
		return new SQL(){{
			SELECT("trat.trat_id ID, trat.trat_descripcion DESCRIPCION, trat.trat_cant_sesiones CANT_SESIONES, lis.list_prec_monto MONTO");
			FROM("tratamiento trat, lista_precios lis, aux_precios aux");
			WHERE("trat.trat_id = lis.list_prec_id_trat ");
			WHERE("lis.list_prec_id = aux.aux_prec_id_list");
		}}.toString();
	}
	
	public String findNewTratamiento() {
		/*
		 "SELECT trat_id, trat_tpo_id, trat_descripcion, trat_cant_sesiones "+ 
			"FROM	tratamiento trat "+
			"WHERE	trat_id NOT IN (SELECT lis.list_prec_id_trat "+
									"FROM lista_precios lis, aux_precios aux "+
									"WHERE lis.list_prec_id = aux.aux_prec_id_list "+
									"AND	current_date() BETWEEN aux.aux_prec_fech_ini AND aux.aux_prec_fech_fin "+ 
									"OR 	current_date() > aux.aux_prec_fech_ini "+
									"AND 	aux.aux_prec_fech_fin = '0000-00-00') "+ 
									"ORDER BY trat_id"
		 */
		return new SQL() {{
			SELECT("trat_id, trat_tpo_id, trat_descripcion, trat_cant_sesiones");
			FROM("tratamiento trat");
			WHERE("trat_id NOT IN("+auxFinfNewTratamiento()+")");
		}}.toString();
	}
	
	public String auxFinfNewTratamiento() {
		return new SQL() {{
			SELECT("SELECT lis.list_prec_id_trat");
			FROM("ista_precios lis, aux_precios aux");
			WHERE("is.list_prec_id = aux.aux_prec_id_list");
			WHERE("current_date() BETWEEN aux.aux_prec_fech_ini AND aux.aux_prec_fech_fin");
			OR();
			WHERE("current_date() > aux.aux_prec_fech_ini");
			WHERE("aux.aux_prec_fech_fin = '0000-00-00'");
			ORDER_BY("trat_id");
		}}.toString();
	}
	
}
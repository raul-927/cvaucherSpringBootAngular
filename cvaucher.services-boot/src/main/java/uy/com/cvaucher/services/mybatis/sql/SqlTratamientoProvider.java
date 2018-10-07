package uy.com.cvaucher.services.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;
public class SqlTratamientoProvider 
{
	
	public String finTratamientoById()
	{
		return new SQL(){{
		SELECT("t.trat_id, t.trat_tpo_id, t.trat_descripcion, t.trat_cant_sesiones, i.impuesto_id, i.impuesto_desc, i.impuesto_desc_abrv, i.impuesto_valor, i.impuesto_tipo, c.cuenta_id");
		 FROM("tratamiento t, impuesto i, cuentas c");
		 WHERE("t.trat_ipuesto_id = i.impuesto_id");
		 WHERE("i.impuesto_cuenta = c.cuenta_id");
		 WHERE("t.trat_id = #{t.tratId}");
			
			}}.toString();
	}
	
	public String findAllTratamientos()
	{
		return new SQL(){{
		SELECT("t.trat_id, tt.tip_trat_descripcion, trat_descripcion, trat_cant_sesiones, i.impuesto_desc_abrv");
		FROM("tratamiento t, tipo_tratamiento tt, impuesto i");
		 WHERE("t.trat_ipuesto_id = i.impuesto_id");
		WHERE("t.trat_tpo_id = tt.tip_trat_id");
		ORDER_BY("trat_id");
		}}.toString();
	}
	
	public String findSesionesByTratamientoId(int tratId)
	{
		return new SQL(){{
		
		}}.toString();
		
	}
	
	public String findAllTratamientoByActualList()
	{
		
		return new SQL(){{
		SELECT("trat.trat_id ID, trat.trat_descripcion DESCRIPCION, trat.trat_cant_sesiones CANT_SESIONES, lis.list_prec_monto MONTO");
		FROM("tratamiento trat, lista_precios lis, aux_precios aux");
		WHERE("trat.trat_id = lis.list_prec_id_trat ");
		WHERE("lis.list_prec_id = aux.aux_prec_id_list");
		}}.toString();
	}
}

package uy.com.cvaucher.services.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;






import uy.com.cvaucher.services.domain.TratByList;
import uy.com.cvaucher.services.domain.Tratamiento;
import uy.com.cvaucher.services.mybatis.sql.SqlTratamientoProvider;

public interface TratamientoMapper 
{
	@SelectProvider(type=SqlTratamientoProvider.class,method="findAllTratamientos")
	/*@Select("SELECT t.trat_id, tt.tip_trat_descripcion, trat_descripcion, trat_cant_sesiones FROM tratamiento t, tipo_tratamiento tt "
			+ " WHERE t.trat_tpo_id = tt.tip_trat_id ORDER BY trat_id")*/
	@ResultMap("uy.com.cvaucher.services.mybatis.mappers.TratamientoMapper.TratResult")
	List<Tratamiento> findAllTratamientos();
	
	@SelectProvider(type=SqlTratamientoProvider.class,method="finTratamientoById")
	//@Select("SELECT trat_id, trat_tpo_id, trat_descripcion, trat_cant_sesiones FROM tratamiento WHERE trat_id=#{tratId}")
	@ResultMap("uy.com.cvaucher.services.mybatis.mappers.TratamientoMapper.TratResult")
	Tratamiento findTratamientoById(int tratId);
	
	@Select("SELECT trat_id, trat_tpo_id, trat_descripcion, trat_cant_sesiones FROM tratamiento WHERE trat_cedula=#{cedula}")
	@ResultMap("uy.com.cvaucher.services.mybatis.mappers.TratamientoMapper.TratResult")
	List<Tratamiento> findTratamientoByCedula(int cedula);
	
	@Select("SELECT trat_cant_sesiones FROM tratamiento WHERE trat_id = #{tratId}")
	@ResultMap("uy.com.cvaucher.services.mybatis.mappers.TratamientoMapper.SesionResult")
	int findSesionesByTratamientoId(int tratId);
	
	//@SelectProvider(type =SqlTratamientoProvider.class, method ="findAllTratamientoByActualList")
	@Select("SELECT		trat.trat_id ID, trat.trat_descripcion DESCRIPCION, trat.trat_cant_sesiones CANT_SESIONES, lis.list_prec_monto MONTO "
			+ "FROM		tratamiento trat, lista_precios lis, aux_precios aux "
			+ "WHERE	trat.trat_id = lis.list_prec_id_trat "
			+ "AND		lis.list_prec_id = aux.aux_prec_id_list "
			+ "AND		current_date() BETWEEN aux.aux_prec_fech_ini AND aux.aux_prec_fech_fin "
			+ "OR 		current_date() > aux.aux_prec_fech_ini "
			+ "AND 		aux.aux_prec_fech_fin = '0000-00-00'")
	@ResultMap("uy.com.cvaucher.services.mybatis.mappers.TratamientoMapper.TratByListResult")
	List<TratByList> findAllTratamientoByActualList();
	
	@Select("SELECT trat_id, trat_tpo_id, trat_descripcion, trat_cant_sesiones "+ 
			"FROM	tratamiento trat "+
			"WHERE	trat_id NOT IN (SELECT lis.list_prec_id_trat "+
									"FROM lista_precios lis, aux_precios aux "+
									"WHERE lis.list_prec_id = aux.aux_prec_id_list "+
									"AND	current_date() BETWEEN aux.aux_prec_fech_ini AND aux.aux_prec_fech_fin "+ 
									"OR 	current_date() > aux.aux_prec_fech_ini "+
									"AND 	aux.aux_prec_fech_fin = '0000-00-00') "+ 
									"ORDER BY trat_id")
	@ResultMap("uy.com.cvaucher.services.mybatis.mappers.TratamientoMapper.TratResult")
	List<Tratamiento> findNewTratamiento();
	
//	@Select("SELECT		trat.trat_id ID, trat.trat_descripcion DESCRIPCION, trat.trat_cant_sesiones CANT_SESIONES, lis.list_prec_monto MONTO "
//			+ "FROM		tratamiento trat, lista_precios lis, aux_precios aux "
//			+ "WHERE	trat.trat_id = lis.list_prec_id_trat "
//			+ "AND		trat.trat_id = #{tratId} "
//			+ "AND		lis.list_prec_id = aux.aux_prec_id_list "
//			+ "AND		current_date() BETWEEN aux.aux_prec_fech_ini AND aux.aux_prec_fech_fin "
//			+ "OR 		current_date() > aux.aux_prec_fech_ini "
//			+ "AND 		aux.aux_prec_fech_fin = '0000-00-00'")
	@SelectProvider(type=SqlTratamientoProvider.class, method="findSesionesByTratamientoId")
	@ResultMap("uy.com.cvaucher.services.mybatis.mappers.TratamientoMapper.TratByListResult")
	TratByList findTratamientoByActualListById(@Param("tratId")int tratId);
	
	@Insert("INSERT INTO tratamiento (trat_tpo_id, trat_descripcion,trat_cant_sesiones, trat_ipuesto_id)VALUES(#{tipoTratamiento.tipTratId}, #{tratDescripcion}, #{tratCantSesiones}, #{impuesto.impuestoId})")
	@Options(useGeneratedKeys=true, keyProperty="tratId")
	void insertTratamiento(Tratamiento tratamiento);
	
	
	@Update("UPDATE tratamiento set trat_tpo_id = #{tipoTratamiento.tipTratId}, trat_descripcion = #{tratDescripcion} , trat_cant_sesiones = #{tratCantSesiones} WHERE  trat_id=#{tratId}")
	void updateTratamiento(Tratamiento tratamiento);
	
	
	@Delete("DELETE FROM tratamiento WHERE trat_id=#{tratId}")
	void deleteTratamiento(int tratId);
	
}

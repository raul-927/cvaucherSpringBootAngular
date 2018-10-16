package uy.com.cvaucher.services.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import uy.com.cvaucher.services.domain.TratamientoPaciente;

public class SqlTratamientoPacienteProvider {
	
	
	public String insertTratamientoPaciente(TratamientoPaciente tratamientoPaciente) {
		String sql = new SQL() {{			
			INSERT_INTO("tratamiento_paciente");
				VALUES("fecha","'".concat(tratamientoPaciente.getFecha()).concat("'"));
				VALUES("pac_cedula",String.valueOf(tratamientoPaciente.getPacientes().getCedula()));
				VALUES("trat_id", String.valueOf(tratamientoPaciente.getTratamId()));
				VALUES("costo_tratamiento",String.valueOf(tratamientoPaciente.getCostoTratSesion()));
				VALUES("importe_pagado", String.valueOf(tratamientoPaciente.getImportePagado()));
				VALUES("saldo_pendiente", String.valueOf(tratamientoPaciente.getCostoTratSesion()));
				VALUES("cant_sesiones",String.valueOf(tratamientoPaciente.getCantSesiones()));
		}}.toString();
		
		
		return sql;
	}
}

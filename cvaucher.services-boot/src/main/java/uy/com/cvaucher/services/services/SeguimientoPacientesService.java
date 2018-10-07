package uy.com.cvaucher.services.services;

import java.util.List;

import uy.com.cvaucher.services.domain.SeguimientoPacientes;

public interface SeguimientoPacientesService {
	
	List<SeguimientoPacientes> findAllSeguimientoPacientes();
	List<SeguimientoPacientes> findSeguimientoPacientesByTratPacId( int tratPacId);
	void insertSeguimientoPacientes(SeguimientoPacientes seguimientoPacientes);
	void updateSeguimientoPacientes(SeguimientoPacientes seguimientoPacientes);
	void deleteSeguimientoPacientes(int segPacId);
	
}

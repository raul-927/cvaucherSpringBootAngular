package uy.com.cvaucher.services.services;

import java.util.List;

import uy.com.cvaucher.services.domain.Impuesto;

public interface ImpuestoService{
	List<Impuesto> findAllImpuestos();
	Impuesto findImpuestoById(int impuestoId);
	void insertImpuesto(Impuesto impuesto);
	List<Impuesto> findAllImpuestosByTipo(String impuestoTipo);
}

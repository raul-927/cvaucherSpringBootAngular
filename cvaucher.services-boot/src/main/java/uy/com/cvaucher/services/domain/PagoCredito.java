package uy.com.cvaucher.services.domain;

import java.io.Serializable;

public class PagoCredito implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int credId;
	private int pagoCredCajaId;
	private int asientoNro;
	private int pagoCredId;
	private long pagoCredCedula;
	private int pagoCredImporte;
	private String pagoCredCuenta;
	private String pagoCredDesc;
	private String pagoCredUsuario;
	
	public int getCredId() {
		return credId;
	}
	public void setCredId(int credId) {
		this.credId = credId;
	}
	public int getPagoCredCajaId() {
		return pagoCredCajaId;
	}
	public void setPagoCredCajaId(int pagoCredCajaId) {
		this.pagoCredCajaId = pagoCredCajaId;
	}
	public int getAsientoNro() {
		return asientoNro;
	}
	public void setAsientoNro(int asientoNro) {
		this.asientoNro = asientoNro;
	}
	public int getPagoCredId() {
		return pagoCredId;
	}
	public void setPagoCredId(int pagoCredId) {
		this.pagoCredId = pagoCredId;
	}
	public long getPagoCredCedula() {
		return pagoCredCedula;
	}
	public void setPagoCredCedula(long pagoCredCedula) {
		this.pagoCredCedula = pagoCredCedula;
	}
	public int getPagoCredImporte() {
		return pagoCredImporte;
	}
	public void setPagoCredImporte(int pagoCredImporte) {
		this.pagoCredImporte = pagoCredImporte;
	}
	public String getPagoCredCuenta() {
		return pagoCredCuenta;
	}
	public void setPagoCredCuenta(String pagoCredCuenta) {
		this.pagoCredCuenta = pagoCredCuenta;
	}
	public String getPagoCredDesc() {
		return pagoCredDesc;
	}
	public void setPagoCredDesc(String pagoCredDesc) {
		this.pagoCredDesc = pagoCredDesc;
	}
	public String getPagoCredUsuario() {
		return pagoCredUsuario;
	}
	public void setPagoCredUsuario(String pagoCredUsuario) {
		this.pagoCredUsuario = pagoCredUsuario;
	}
}

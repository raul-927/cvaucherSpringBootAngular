package uy.com.cvaucher.rest.statemachine.states;

public enum PacienteStates {
	SI(1, "Estado inicial"), S1(2,"Primer estado"), S2(3,"Segundo estado"),S3(4,"Estado final");
	
	private int id;
	private String valor;
	
	private PacienteStates(int id, String valor) {
		this.id = id;
		this.valor = valor;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getValor() {
		return this.valor;
	}
}

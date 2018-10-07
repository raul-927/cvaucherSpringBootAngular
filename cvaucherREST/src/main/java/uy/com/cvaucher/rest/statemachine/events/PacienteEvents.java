package uy.com.cvaucher.rest.statemachine.events;

public enum PacienteEvents {
	E1(1,"Evento 1"), E2(2,"Evento 2"), E3(3,"Evento 3");
	
	private int id;
	private String valor;
	
	private PacienteEvents(int id, String valor) {
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

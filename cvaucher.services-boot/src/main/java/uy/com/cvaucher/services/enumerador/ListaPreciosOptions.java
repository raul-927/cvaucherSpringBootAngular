package uy.com.cvaucher.services.enumerador;

public enum ListaPreciosOptions {
	NUEVA_LISTA_PRECIOS(1, "Nueva lista de precios"), 
	COPIAR_Y_MODIFICAR_LISTA_PRECIOS(2, "Copiar y modificar lista de precios"),
	INSERTAR_TRATAMIENTO_EN_LISTA_ACTUAL(3, "Insertar tratamiento en lista actual");
	private int opcion;
	private String descripcion;
	
	ListaPreciosOptions(int opcion, String descripcion)
	{
		this.opcion = opcion;
		this.descripcion = descripcion;
		
	}
	
	public int getOpcion(){
		return this.opcion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
}

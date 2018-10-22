package uy.com.cvaucher.services.domain;

import java.util.List;

public class Items {
	private int itemsId;
	private List<Tratamiento> tratamientos;
	private List<Producto> productos;
	
	
	public int getItemsId() {
		return itemsId;
	}
	public void setItemsId(int itemsId) {
		this.itemsId = itemsId;
	}
	public List<Tratamiento> getTratamientos() {
		return tratamientos;
	}
	public void setTratamientos(List<Tratamiento> tratamientos) {
		this.tratamientos = tratamientos;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}

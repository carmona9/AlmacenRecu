package beans;

public class Producto {

	int cantidad;
	int precio;
	
	public Producto(int cantidad, int precio) {
		super();
		this.cantidad = cantidad;
		this.precio = precio;
		
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
		
	}
	
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;      
	}

}

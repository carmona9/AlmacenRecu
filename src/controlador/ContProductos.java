package controlador;

import java.util.Vector;

import dao.DAOProductos;
import modelo.ModeloAlmacen;

public class ContProductos {

	private ModeloAlmacen modelo;
	private Vector<DAOProductos> productos;
	

	public ContProductos(ModeloAlmacen modelo) {
		this.modelo=modelo;
	}
	
	public Vector<DAOProductos> obtenerProductos() throws Exception{
		productos=modelo.obtenerProductos();
		return productos;
	}
	
	public Vector<DAOProductos> mostrarTuerca() throws Exception {
		return modelo.mostrarTuercas();
	}
	public Vector<DAOProductos> mostrarTornillos() throws Exception {
		return modelo.mostrarTornillos();
		}
	public  Vector<DAOProductos> mostrarPasador() throws Exception {
		return modelo.mostrarPasador();
			}
	public Vector<DAOProductos> mostrarBisagras() throws Exception {
		return modelo.mostrarBisagra();
					
	}

	//Ejecutamos el método terminar para liberar memoria
	public void terminar() {
		modelo.terminar();
	}
}
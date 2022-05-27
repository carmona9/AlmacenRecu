package controlador;

import java.util.Vector;

import dao.DAOCategoria;
import dao.DAOProductos;
import modelo.ModeloAlmacen;


public class ContCategoria {

	private ModeloAlmacen modelo;
	private Vector<DAOCategoria> categorias;
	private DAOCategoria categoria;
	
	public ContCategoria(ModeloAlmacen modelo) {
		this.modelo=modelo;
	}
	
	
	public Vector<DAOCategoria> obtenerCategorias() throws Exception{
		categorias=modelo.obtenerCategorias();
		return categorias;
	}
	
	/*	public static DAOCategoria obtenerCategoria() throws Exception {
		categoria=modelo.obteberCategoria();
		return categoria;
		
	}
	*/
	
	//Ejecutamos el método terminar para liberar memoria
	public void terminar() {
		modelo.terminar();
	}
	
}
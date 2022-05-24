package controlador;

import java.util.Vector;

import dao.DAOCategoria;
import dao.DAOProductos;
import modelo.ModeloAlmacen;


public class ContCategoria {

	private ModeloAlmacen modelo;
	private Vector<DAOCategoria> categorias;
	
	public ContCategoria(ModeloAlmacen modelo) {
		this.modelo=modelo;
	}

	//Ejecutamos el método terminar para liberar memoria
	public void terminar() {
		modelo.terminar();
	}
	
}
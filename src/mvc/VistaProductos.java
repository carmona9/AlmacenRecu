package mvc;

import java.sql.*;
import java.util.*;
import controlador.ContProductos;
import dao.DAOCategoria;
import dao.DAOProductos;

public class VistaProductos {
	
	private int opcion;
	private ContProductos controlador;
	private ResultSet resultado;
	private Scanner entrada;
	private String cod_categoria;
	private String cod_producto;
	private String nombre_producto;
	private String cantidad;
	private String precio;
	
	public VistaProductos(ContProductos controlador) {
		this.controlador=controlador;
	}
	
	public void getAccion() {
		getMenu();
		getOpcion();
		
		do {
			switch(opcion) {
			case 1:
				altaProducto();
					break;
			case 2:
				try {
					modificacionProducto();
				}catch (Exception e) {
					System.err.println("Ha habido un error al modificar las categoria");
				}
					break;
			case 3:
				borrarProducto();
					break;
			case 4:
				consultaProducto();
					break;
				default:
				System.out.println("La opcion no es correcta. \n");
					
			}
			if(opcion != 0) {
				getMenu();
				getOpcion();
			}
		}while(opcion != 0) ;
			System.out.println("ADIOS");
			System.out.println("-------");
			terminarAplicacion();
			System.exit(0);
		}
	
	private void getMenu() {
		
		System.out.println("\n==============================");
		System.out.println("	MANTENIMIENTO CATEGORÍA		");
		System.out.println("==============================");
		System.out.println("Menu");
		System.out.println("-----");
		System.out.println("1 - Alta Producto");
		System.out.println("2 - Modificar Producto");
		System.out.println("3 - Borrar Producto");
		System.out.println("4 - Consulta Producto");
		System.out.println("0 - Salir");
		
	}

	private void getOpcion() {
		entrada = new Scanner(System.in);
			System.out.println("Introduzca una opcion: ");
			try {
				opcion = entrada.nextInt();
				entrada.nextLine();
			}catch(InputMismatchException exc) {
				opcion = -1;
			}
	}

	//METODOS para solicitar los servicios de la Aplicacion


	private void terminarAplicacion() {
		entrada.close();
		controlador.terminar();
	}

	private void altaProducto() {
	
	try {
		do {
	System.out.println("Nombre de la Categoria");
	nombre_producto = entrada.nextLine();
	System.out.println("Codigo para la Categoria");
	cod_categoria = entrada.nextLine();}while(nombre_producto.equals("")||cod_producto.equals(""));
	
	controlador.insertarProducto(cod_categoria,cod_producto,
			nombre_producto,cantidad,precio);
	
	}catch(Exception exc) {
		System.err.println("FALLO AL DAR DE ALTA LA CATEGORIA");
		exc.printStackTrace();
	}
	
	
	}

	private void modificacionProducto() throws Exception {
	
	
		do {
			System.out.println("Escribe codProducto a modificar");
			cod_producto = entrada.nextLine();}while(cod_producto.equals(""));
		DAOProductos producto=controlador.obtenerProductos(cod_producto);
		DAOProductos.mostrarProducto(producto);
		do {
			System.out.println("Nombre Producto");
			nombre_producto = entrada.nextLine();}while(nombre_producto.equals("")||cod_producto.equals(""));

		DAOCategoria.modificarCategoria(cod_categoria, nombre_producto);
	
	}

	private void borrarProducto() {
		try { String cod_producto;
		System.out.println("Escribe idProducto");
		cod_producto = entrada.nextLine();
	
	
		
			if(controlador.borrarProducto(cod_producto)>0) {
				System.out.println("Autor eliminado con exito");}
			else {
				System.out.println("No se ha eliminado ningun Producto");
			}
		} catch (Exception e) {
			System.err.println("Fallo al eliminar el Producto");
			e.printStackTrace();
		}
	
	
	}


	private void consultaProducto() {
		Vector<DAOProductos> productos;
		try {
			productos = controlador.obtenerProductos();
	
			System.out.println("\nLISTADO DE Productos");
			System.out.println("======================");
	
			Iterator<DAOProductos> itProductos = productos.iterator();
			while(itProductos.hasNext()) {
				DAOProductos producto= itProductos.next();
				DAOProductos.mostrarProducto(producto);
			
			}
			
			
		} catch (Exception e) {
			System.err.println("Vista: FALLO A OBTENER PRODUCTOS");
			e.printStackTrace();
		}
	}
}

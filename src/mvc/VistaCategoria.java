package mvc;


import java.sql.*;
import java.util.*;
import controlador.ContCategoria;
import dao.DAOCategoria;


public class VistaCategoria {

	private int opcion;
	private ContCategoria controlador;
	private ResultSet resultado;
	private Scanner entrada;
	private String cod_categoria;
	private String nombre_categoria;
	
	public VistaCategoria(ContCategoria controlador) {
		this.controlador=controlador;
	}
	
	public void getAccion() {
		getMenu();
		getOpcion();
		
		do {
			switch(opcion) {
			case 1:
				altaCategoria();
					break;
			case 2:
				try {
					modificacionCategoria();
				}catch (Exception e) {
					System.err.println("Ha habido un error al modificar las categoria");
				}
					break;
			case 3:
				borrarCategoria();
					break;
			case 4:
				consultaCategoria();
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
		System.out.println("1 - Alta Categoria");
		System.out.println("2 - Modificar Categoria");
		System.out.println("3 - Borrar Categoria");
		System.out.println("4 - Consulta Categoria");
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

	private void altaCategoria() {
	
	try {
		do {
	System.out.println("Nombre de la Categoria");
	nombre_categoria = entrada.nextLine();
	System.out.println("Codigo para la Categoria");
	cod_categoria = entrada.nextLine();}while(nombre_categoria.equals("")||cod_categoria.equals(""));
	
	controlador.insertarCategoria(cod_categoria, nombre_categoria);
	
	}catch(Exception exc) {
		System.err.println("FALLO AL DAR DE ALTA LA CATEGORIA");
		exc.printStackTrace();
	}
	
	
	}

	private void modificacionCategoria() throws Exception {
	
	
		do {
			System.out.println("Escribe idCategoria a modificar");
			cod_categoria = entrada.nextLine();}while(cod_categoria.equals(""));
		DAOCategoria categoria=controlador.obtenerCategoria(cod_categoria);
		DAOCategoria.mostrarCategoria(categoria);
		do {
			System.out.println("Nombre Categoria");
			nombre_categoria = entrada.nextLine();}while(nombre_categoria.equals("")||cod_categoria.equals(""));

		DAOCategoria.modificarCategoria(cod_categoria, nombre_categoria);
	
	}

	private void borrarCategoria() {
		try { String cod_categoria;
		System.out.println("Escribe idCategoria");
		cod_categoria = entrada.nextLine();
	
	
		
			if(controlador.borrarCategoria(cod_categoria)>0) {
				System.out.println("Autor eliminado con exito");}
			else {
				System.out.println("No se ha eliminado ningun categoria");
			}
		} catch (Exception e) {
			System.err.println("Fallo al eliminar el Categoria");
			e.printStackTrace();
		}
	
	
	}


	private void consultaCategoria() {
		Vector<DAOCategoria> categorias;
		try {
			categorias = controlador.obtenerCategorias();
	
			System.out.println("\nLISTADO DE CATEGORIAS");
			System.out.println("======================");
	
			Iterator<DAOCategoria> itCategorias = categorias.iterator();
			while(itCategorias.hasNext()) {
				DAOCategoria categoria= itCategorias.next();
				DAOCategoria.mostrarCategoria(categoria);
			
			}
			
			
		} catch (Exception e) {
			System.err.println("Vista: FALLO A OBTENER  CATEGORIAS");
			e.printStackTrace();
		}
	}
}

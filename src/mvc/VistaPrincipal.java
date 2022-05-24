package mvc;


import java.util.*;
import controlador.ContCategoria;
import controlador.ContProductos;


public class VistaPrincipal {

	
	ContCategoria contCategoria;
	ContProductos contProductos;
	
	private int opcion;
	private Scanner entrada;
	
	
	public VistaPrincipal(ContCategoria contCategoria,ContProductos contProductos) {
		this.contCategoria=contCategoria;
		this.contProductos=contProductos;
	
	}	
	
	public void getAccion() throws Exception {
		getMenu();
		getOpcion();
		
		do {
			switch(opcion) {
			case 1:
				VistaCategoria vistaCategoria = new VistaCategoria(contCategoria);
				vistaCategoria.getAccion();
					break;
			case 2:
				VistaProductos vistaProductos = new VistaProductos(contProductos);
				vistaProductos.getAccion();
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
			System.out.println("------");
			terminarAplicacion();
			System.exit(0);
		}
	private void getMenu() {
		
		System.out.println("APLICACION PROYECTO ALMACEN");
		System.out.println("==============================");
		System.out.println("Menu");
		System.out.println("-----");
		System.out.println("1 - Mantenimientos de Categorias");
		System.out.println("2 - Mantenimiento de Productos");
		System.out.println("0 - Salir");
	}
	
	private void getOpcion() {
		entrada = new Scanner(System.in);
			System.out.println("Introduzca una opcion: ");
		try {
			opcion = entrada.nextInt();
		}catch(InputMismatchException exc) {
			opcion = -1;
		}
	}
	
	//METODOS para solicitar los servicios de la Aplicacion
	
	
			private void terminarAplicacion() {
				entrada.close();
				//controlador.terminar();
			}
			
}
	


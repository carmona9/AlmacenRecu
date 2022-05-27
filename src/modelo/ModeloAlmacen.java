package modelo;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

import bbdd.ServicioMySQL;
import dao.DAOCategoria;
import dao.DAOProductos;

public class ModeloAlmacen {

	private Connection conexionBBDD;
	private Statement sentencia;
	
	private DAOCategoria categoria;
	private DAOProductos producto;
	
	
	
	private Vector<DAOProductos> productos;
	private Vector<DAOCategoria> categorias;
	
	Properties servicioElegido = new Properties();
	
	public ModeloAlmacen() {
		try {
			
			ServicioMySQL servicio = new ServicioMySQL();
			this.conexionBBDD= ServicioMySQL.obtenerConexion();
			
			this.sentencia = this.conexionBBDD.createStatement();
			
			DAOCategoria.setConexionBBDD(sentencia, null);
			DAOProductos.setConexionBBDD(sentencia, null);
			
		}catch (SQLException e) {
			System.err.println();
			e.printStackTrace();
		}

	}
	
	public void terminar() {
		try {
			sentencia.close();
			conexionBBDD.close();
		}catch (SQLException e) {
			System.err.print("Modelo: FALLO AL CERRAR LA CONEXION");
		}
	}

	public Vector<DAOProductos> obtenerProductos() throws Exception{
		try {				
		productos=DAOProductos.obtenerProductos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productos;
	}
	
	public Vector<DAOCategoria> obtenerCategorias() throws Exception{
		try {				
		categorias=DAOCategoria.obtenerCategorias();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorias;
	}
	
	
/////////////////////////////////////////////////MOSTRAR//////////////////////////////////////////////////////////////
	public static Vector<DAOProductos> mostrarTuercas() throws Exception {
		return DAOProductos.mostrarTuercas();
	}
	
	public static Vector<DAOProductos> mostrarTornillos() throws Exception {
		return DAOProductos.mostrarTornillos();
	}
	
	public static Vector<DAOProductos> mostrarPasador() throws Exception {
		return DAOProductos.mostrarPasador();
	}
	
	public static Vector<DAOProductos> mostrarBisagra() throws Exception {
		return DAOProductos.mostrarBisagra();
	}

	public Vector<DAOCategoria> obtenerCategoria() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

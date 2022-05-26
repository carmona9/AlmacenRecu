package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class DAOCategoria {

	private int cod_categoria;
	private String nombre_categoria;
	
	public DAOCategoria() {
		
	}
	
	public DAOCategoria(int cod_categoria, String nombre_categoria) {
		this.cod_categoria = cod_categoria;
		this.nombre_categoria = nombre_categoria;
	}
	
	public int getCod_categoria() {
		return cod_categoria;
	}
	
	public void setCod_categoria(int cod_categoria) {
		this.cod_categoria = cod_categoria;
	}
	
	public String getNombre_categoria() {
		return nombre_categoria;
	}
	
	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}
	
	private static Statement sentencia;
	private static ResultSet resultado;
	
	public static void setConexionBBDD(Statement sentencia, ResultSet resultado) {
		DAOCategoria.sentencia= sentencia;
		DAOCategoria.resultado = resultado;    
	}
	
	public static Vector<DAOCategoria> obtenerCategorias() throws Exception {
		String sqlQuery = "SELECT * FROM almacen.categoria;";
		return buscaResultadosConConsulta(sqlQuery);
	}
	
	
	public static DAOCategoria obtenerCategoria(String codCategoria) throws Exception {
		String sqlQuery = "select * from categoria WHERE cod_categoria= '" + codCategoria + "';";
		//Este metodo devolvera un vector tipo <CategoriaDAO>
		return buscaResultadosUnaCategoria(sqlQuery);
		
	}
	
	
	
	private static Vector<DAOCategoria> buscaResultadosConConsulta(String consulta) throws Exception{
		resultado = DAOCategoria.sentencia.executeQuery(consulta);
		return cargaResultSetToVector(resultado);
		
	}
	
	private static Vector<DAOCategoria> cargaResultSetToVector(ResultSet resultado) throws Exception {
		Vector<DAOCategoria> categorias = new Vector<DAOCategoria>();
		DAOCategoria categoria;
		
		while(resultado.next()) {
			int codCategoria = resultado.getInt(1);
			String nombreCategoria = resultado.getString(2);
			categoria = new DAOCategoria(codCategoria,nombreCategoria);
			categorias.addElement(categoria);
		}
		
		return categorias;
	}
	private static DAOCategoria buscaResultadosUnaCategoria(String consulta) throws Exception{
		resultado = DAOCategoria.sentencia.executeQuery(consulta);
		return cargaResultSetToCategoria(resultado);
		
	}
	
	private static DAOCategoria cargaResultSetToCategoria(ResultSet resultado) throws Exception {
		
		DAOCategoria categoria = null;
		
		while(resultado.next()) {
			int codCategoria = resultado.getInt(1);
			String nombreCategoria = resultado.getString(2);
			categoria = new DAOCategoria(codCategoria,nombreCategoria);			
		}
		
		return categoria;
	}
	
}

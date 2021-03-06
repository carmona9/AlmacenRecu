package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class DAOProductos {

	private int cod_categoria;
	private String cod_producto;
	private String nombre_producto;
	private String cantidad;
	private float precio;
	
	public DAOProductos() {
		
	}
	
	public DAOProductos(int cod_categoria,String cod_producto,
			String nombre_producto,String cantidad,float precio) {
		super();
		this.cod_categoria= cod_categoria;
		this.cod_producto= cod_producto;
		this.nombre_producto=nombre_producto;
		this.cantidad=cantidad;
		this.precio=precio;
	}

	public int getCod_categoria() {
		return cod_categoria;
	}

	public void setCod_categoria(int cod_categoria) {
		this.cod_categoria = cod_categoria;
	}

	public String getCod_producto() {
		return cod_producto;
	}

	public void setCod_producto(String cod_producto) {
		this.cod_producto = cod_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	private static Statement sentencia;
	private static ResultSet resultado;
	
	public static void setConexionBBDD(Statement sentencia, ResultSet resultado) {
		DAOProductos.sentencia= sentencia;
		DAOProductos.resultado = resultado;
	}
	
	public static Vector<DAOProductos> obtenerProductos() throws Exception{
		String sqlQuery = "select * from productos";
		//Este m?todo devolver? un vector de tipo <DAOLibro>
		return buscaResultadosConConsulta(sqlQuery);
	}
	
	/////////////////////////////////MOSTRAR///////////////////////////////////////////////////////////////////////////////
	
	public static Vector<DAOProductos> mostrarTuercas() throws Exception {
		String sqlQuery = "select * from productos WHERE cod_categoria='1' ";
		return buscaResultadosConConsulta(sqlQuery);
	}
	
	public static Vector<DAOProductos> mostrarTornillos() throws Exception {
		String sqlQuery = "select * from productos WHERE cod_categoria='2' ";
		return buscaResultadosConConsulta(sqlQuery);
	}
	
	public static Vector<DAOProductos> mostrarPasador() throws Exception {
		String sqlQuery = "select * from productos WHERE cod_categoria='3' ";
		return buscaResultadosConConsulta(sqlQuery);
	}
	
	public static Vector<DAOProductos> mostrarBisagra() throws Exception {
		String sqlQuery = "select * from productos WHERE cod_categoria='4' ";
		return buscaResultadosConConsulta(sqlQuery);
	}
	
	private static Vector<DAOProductos> buscaResultadosConConsulta(String consulta) throws Exception{
		resultado = DAOProductos.sentencia.executeQuery(consulta);
		return cargaResultSetToVector(resultado);
		
	}
	
	private static Vector<DAOProductos> cargaResultSetToVector(ResultSet resultado) throws Exception {
		Vector<DAOProductos> productos = new Vector<DAOProductos>();
		DAOProductos producto;
		
		while(resultado.next()) {
			int cod_categoria = resultado.getInt(1);
			String cod_producto = resultado.getString(2);
			String nombre_producto = resultado.getString(3);
			String cantidad = resultado.getString(4);
			float precio = resultado.getFloat(5);
			producto = new DAOProductos(cod_categoria,cod_producto,nombre_producto,cantidad,precio);
			productos.addElement(producto);
		}
		
		return productos;
	}
	private static DAOProductos buscaResultadosUnProducto(String consulta) throws Exception{
		resultado = DAOProductos.sentencia.executeQuery(consulta);
		return cargaResultSetToProducto(resultado);
		
	}
	
	private static DAOProductos cargaResultSetToProducto(ResultSet resultado) throws Exception {
		
		DAOProductos producto= null;
		
		while(resultado.next()) {
			int cod_categoria = resultado.getInt(1);
			String cod_producto = resultado.getString(2);
			String nombre_producto = resultado.getString(3);
			String cantidad = resultado.getString(4);
			float precio = resultado.getFloat(5);
			
			producto = new DAOProductos(cod_categoria,cod_producto,nombre_producto,cantidad,precio);
		}
		
		return producto;
	}
	
	
}
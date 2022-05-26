package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Vector;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import controlador.ContCategoria;
import controlador.ContProductos;
import dao.DAOCategoria;
import dao.DAOProductos;
import modelo.ModeloAlmacen;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class principal
 */
@WebServlet("/GenerarCarrito")
public class GenerarCarrito extends HttpServlet{

private static final long serialVersionUID = 1L;
	
	ModeloAlmacen modelo = new ModeloAlmacen();
	ContCategoria controladorCategoria = new ContCategoria(modelo);
	Vector<DAOCategoria> listadoCategorias = new Vector<DAOCategoria>();
	DAOCategoria categoria1 = listadoCategorias.firstElement();
	
	
	
	
	
}

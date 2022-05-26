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
@WebServlet("/GenerarTabla")
public class GenerarTabla extends HttpServlet {

	 private static final long serialVersionUID = 1L;
	
	ModeloAlmacen modelo = new ModeloAlmacen();
	ContCategoria contCategoria = new ContCategoria(modelo);
	ContProductos contProductos = new ContProductos(modelo);
	
	/**
     * @see HttpServlet#HttpServlet()
     */
	
	public GenerarTabla() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override
	public void init() throws ServletException {
		modelo = new ModeloAlmacen();
		contCategoria = new ContCategoria(modelo);
		contProductos = new ContProductos(modelo);
		
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		String objeto = request.getParameter("objeto");
		
		PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head></head>");         
        out.println("<body>");
        out.print("<a href='catalogo.jsp'>INICIO</a>");
        out.println("<br>");
        out.println("<table align='center' border='2'>");
        	out.println("<tr>");
        		out.println("<th>cod_categoria</th>");
        		out.println("<th>cod_producto</th>");
        		out.println("<th>nombre_producto</th>");
        		out.println("<th>cantidad</th>");
        		out.println("<th>precio</th>");
        		out.println("<th>precio_total</th>");
        out.println("</tr>");
        
        Vector<DAOProductos> listaProducto = new Vector();
      
        switch(objeto) {
    	case "Tuerca":
    		out.println(objeto);
    		try {
    			listaProducto =  contProductos.mostrarTuerca();
    			}catch(Exception e){
    				e.printStackTrace();
    			}
    		for(DAOProductos producto:listaProducto) {
    			out.println("<tr>");
    			out.println("<td>"+producto.getCod_categoria()+"</td>");
    			out.println("<td>"+producto.getCod_producto()+"</td>");
    			out.println("<td>"+producto.getNombre_producto()+"</td>");
    			out.println("<td>"+producto.getCantidad()+"</td>");
    			out.println("<td>"+producto.getPrecio()+"</td>");
    			out.println("<td>"+(Float.valueOf(producto.getCantidad())*Float.valueOf(producto.getPrecio())+"</td>"));
    			out.println("</tr>");
    			//Float.valueOf(producto.getCantidad())*Float.valueOf(producto.getPrecio())
    		}
    		break;
    	case "Tornillo":
    		out.println(objeto);
    		try {
    			listaProducto =  contProductos.mostrarTornillos();
    			}catch(Exception e){
    				e.printStackTrace();
    			}
    		for(DAOProductos producto:listaProducto) {
    			out.println("<tr>");
    			out.println("<td>"+producto.getCod_categoria()+"</td>");
    			out.println("<td>"+producto.getCod_producto()+"</td>");
    			out.println("<td>"+producto.getNombre_producto()+"</td>");
    			out.println("<td>"+producto.getCantidad()+"</td>");
    			out.println("<td>"+producto.getPrecio()+"</td>");
    			out.println("<td>"+(Float.valueOf(producto.getCantidad())*Float.valueOf(producto.getPrecio())+"</td>"));
    			out.println("</tr>");
    		}
    		break;
    	case "Pasador":
    		out.println(objeto);
    		try {
    			listaProducto =  contProductos.mostrarPasador();
    			}catch(Exception e){
    				e.printStackTrace();
    			}
    		for(DAOProductos producto:listaProducto) {
    			out.println("<tr>");
    			out.println("<td>"+producto.getCod_categoria()+"</td>");
    			out.println("<td>"+producto.getCod_producto()+"</td>");
    			out.println("<td>"+producto.getNombre_producto()+"</td>");
    			out.println("<td>"+producto.getCantidad()+"</td>");
    			out.println("<td>"+producto.getPrecio()+"</td>");
    			out.println("<td>"+(Float.valueOf(producto.getCantidad())*Float.valueOf(producto.getPrecio())+"</td>"));
    			out.println("</tr>");
    		}
    		break;
    	case "Bisagra":
    		out.println(objeto);
    		try {
    			listaProducto =  contProductos.mostrarBisagras();
    			}catch(Exception e){
    				e.printStackTrace();
    			}
    		for(DAOProductos producto:listaProducto) {
    			out.println("<tr>");
    			out.println("<td>"+producto.getCod_categoria()+"</td>");
    			out.println("<td>"+producto.getCod_producto()+"</td>");
    			out.println("<td>"+producto.getNombre_producto()+"</td>");
    			out.println("<td>"+producto.getCantidad()+"</td>");
    			out.println("<td>"+producto.getPrecio()+"</td>");
    			out.println("<td>"+(Float.valueOf(producto.getCantidad())*Float.valueOf(producto.getPrecio())+"</td>"));
    			out.println("</tr>");
    		}
    		break;
    	default:
    	}
        out.println("</table>");
        out.println("</body>");
        out.println("</html>"); 
        
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  
	}
}
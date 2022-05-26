<%@page import="dao.DAOCategoria"%>
<%@page import="dao.DAOProductos"%>
<%@page import="bbdd.ServicioMySQL"%>
<%@page import="beans.Producto"%>
<%@page import="controlador.ContCategoria"%>
<%@page import="controlador.ContProductos"%>
<%@page import="modelo.ModeloAlmacen"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  
<!DOCTYPE html>

	<%  ModeloAlmacen modelo = new ModeloAlmacen();
		ContProductos controlador = new ContProductos(modelo);
		Vector<DAOProductos> vectorProducto = controlador.obtenerProductos();
		DAOProductos producto1 = vectorProducto.firstElement();
		
		ContCategoria controladorCategoria = new ContCategoria(modelo);
		Vector<DAOCategoria> vectorCategorias = controladorCategoria.obtenerCategorias();
		DAOCategoria categoria1 = vectorCategorias.firstElement();
		
			
	%>
	
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web</title>
</head>
<body>

	<form method="post" action="/web/web">
	
			<a style="color:black;" href="catalogo.jsp">Inicio</a>
	 		<a style="color:black;text-size:20xp;" href="GenerarTabla?objeto=Tuerca">Tuerca</a>
            <a style="color:black;" href="GenerarTabla?objeto=Tornillo">Tornillo</a>
            <a style="color:black;" href="GenerarTabla?objeto=Pasador">Pasador</a>
            <a style="color:black;" href="GenerarTabla?objeto=Bisagra">Bisagra</a>
			<a style="color:black;" href="carrito.jsp">Carrito</a>
			
	</form>
	
	<div>
		
		
		
		<% for(DAOProductos producto : vectorProducto) {
			
			String nombre_categoria="";
			String conversion;
			
			for(DAOCategoria categoria : vectorCategorias){
				if(categoria.getCod_categoria() == producto.getCod_categoria()){
					nombre_categoria=nombre_categoria + categoria.getNombre_categoria();
				} 
					
			 
					
				} %>
			<table text-aling:left;>
				<tr>
					<td></td>
					<td> <%=nombre_categoria %> </td>
					
				
			
				
					<td> <%= producto.getNombre_producto() %> </td>
				
				
					<td>"<%= producto.getPrecio()  %> Euros" </td>
					
					<td><input type="submit" value="Comprar"></td>
						
				</tr>
			</table>
		<%} %>
	</div>

</body>
</html>
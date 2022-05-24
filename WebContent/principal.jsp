<%@page import="dao.DAOCategoria"%>
<%@page import="dao.DAOProductos"%>
<%@page import="bbdd.ServicioMySQL"%>
<%@page import="beans.Producto"%>
<%@page import="controlador.ContCategoria"%>
<%@page import="controlador.ContProductos"%>
<%@page import="modelo.ModeloAlmacen"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>

<title>Web</title>
</head>
<body>

	<form method="post" action="/web/web">

        <div style="background-color:red; ">
                
            <a style="color:black;text-size:20xp;" href="GenerarTabla?objeto=Tuerca">Tuerca</a>
            <a style="color:black;" href="GenerarTabla?objeto=Tornillo">Tornillo</a>
            <a style="color:black;" href="GenerarTabla?objeto=Pasador">Pasador</a>
            <a style="color:black;" href="GenerarTabla?objeto=Bisagra">Bisagra</a>

       </div>

</form>
</body>

</html>
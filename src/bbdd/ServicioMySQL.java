package bbdd;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	
	public class ServicioMySQL {
		private static ServicioMySQL servicio;
		private static Connection conexion;
		
	public ServicioMySQL() {
		try {
			//carga el driver para MySQL
			Class.forName("com.mysql.jdbc.Driver");
			
			//Datos para la conexcion
			String URL = "jdbc:mysql://localhost:3306/almacen?useSSL=false";
			String usuario = "root";
			String contrasenna = "romaol2";
			
			//Establecimiento de la conexcin de la BBDD
			this.conexion = DriverManager.getConnection(URL,usuario,contrasenna);
		}
		catch(ClassNotFoundException exc) {
			System.err.println("ServicioMySQL: DRIVER DE BBDD NO CARGADO");
			exc.printStackTrace();
		}
		catch(SQLException exc) {
			System.err.println("ServicioMySQL: FALLO AL ESTABLECER CONEXION");
			exc.printStackTrace();
		}
	}

	//Este metodo crea el servicio para la BBDD
	public static synchronized ServicioMySQL obtenerServicio() {
		if(servicio == null) {
			servicio = new ServicioMySQL();
			
		}
		return servicio;
	}
	
	//Este metodo proporciona la conexion
	public static Connection obtenerConexion() {
		return conexion;
	}
	}

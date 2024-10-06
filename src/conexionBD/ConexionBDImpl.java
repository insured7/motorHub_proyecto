package conexionBD;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionBDImpl implements ConexionBDInterfaz {

	@Override
	public Connection conexion() {
		
		Connection conexion = null; //Inicializo la conexion en null
		Properties properties = new Properties(); //cargo la informacion del archivo dbconfig.properties
		
		try (FileInputStream input = new FileInputStream("src/dbconfig.properties")) {
            properties.load(input);
        } catch (IOException e) {
            System.out.println(e);
        }
		
		try {
            // Obtengo propiedades
            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");

            // Establezco conexion
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al conectarse a la base de datos");
            e.printStackTrace();
        }
		
		return conexion;
	}

}

package controladores;
import java.sql.Connection;
import java.sql.SQLException;

import servicios.*;
public class App {

	public static void main(String[] args) {
		
		ConexionBDInterfaz cbdi = new ConexionBDImpl();
		
		Connection conexion = cbdi.conexion();
		
		if(conexion !=null ) {
			try {
				conexion.close();
				System.out.println("Conexion cerrada");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}

}

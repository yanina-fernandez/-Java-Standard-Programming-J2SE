package ar.com.educarionit.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import ar.com.educarionit.domain.Producto;
import ar.com.educarionit.domain.jdbc.AdministradorDeConexiones;

public class ProductoDAOJDBCImpl implements ProductoDAO {

	public Producto getProducto(){
		try {
			Connection conection = AdministradorDeConexiones.obtenerConexion();
		//	boolean alive = !conection.isClosed();
		//	System.out.println(alive);			
			Statement st = conection.createStatement();
			ResultSet rs =  st.executeQuery("SELECT * FROM producto");
			Producto producto = null;
			
			// Obtener datos desde el rs
			if (rs.next()) {
				Long id = rs.getLong(1);
				String descripcion = rs.getString(2);
				Float precio = rs.getFloat(3);
				String codigo = rs.getNString(4);
			
				producto = new Producto(id,descripcion,precio,codigo);
				//System.out.println(producto);
				//	System.out.println("Valor obtenido =" + id);
			}			
			conection.close();
			return producto;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	
	}

}

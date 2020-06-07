package ar.com.educarionit.services.main;

import ar.com.educarionit.domain.Producto;
import ar.com.educarionit.services.ProductoDAO;
import ar.com.educarionit.services.ProductoDAOJDBCImpl;

public class MainConection {

	public static void main(String[] args) {
		//interfaz i = new Clase()
		
		ProductoDAO pdao = new ProductoDAOJDBCImpl();
		
		Producto producto = pdao.getProducto();
		
		System.out.println(producto);
		

	}

}

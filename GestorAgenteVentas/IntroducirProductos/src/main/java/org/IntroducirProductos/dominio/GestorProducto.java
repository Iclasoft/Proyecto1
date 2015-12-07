package org.IntroducirProductos.dominio;

import java.sql.SQLException;

public class GestorProducto {
	public void aniadirProducto(String nombre, String descripcion, double precio) throws ClassNotFoundException, SQLException{
		new GestorAniadirProducto().aniadirProducto(nombre, descripcion, precio);
	}
}

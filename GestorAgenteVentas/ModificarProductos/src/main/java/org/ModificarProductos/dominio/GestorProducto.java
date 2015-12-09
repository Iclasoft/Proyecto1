package org.ModificarProductos.dominio;

import java.sql.SQLException;

import org.VisualizarProducto.dominio.Producto;

public class GestorProducto extends org.VisualizarProducto.dominio.GestorProducto{
	public void modificarProducto(Producto p) throws ClassNotFoundException, SQLException{
		new GestorModificarProducto().modificarProducto(p);
	}
}

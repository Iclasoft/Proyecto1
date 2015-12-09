package org.BorrarProductos.dominio;

import java.sql.SQLException;

import org.ModificarProductos.dominio.GestorModificarProducto;
import org.VisualizarProducto.dominio.Producto;

public class GestorProducto extends GestorModificarProducto {
	public void borrarProducto(Producto p) throws ClassNotFoundException, SQLException{
		new GestorBorrarProducto().borrarProducto(p);
	}
}

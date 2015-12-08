package org.VisualizarProducto.dominio;

import java.sql.SQLException;
import java.util.List;

public class GestorProducto extends org.IntroducirProductos.dominio.GestorProducto {

	public List<org.VisualizarProducto.dominio.Producto> visualizarProducto() throws ClassNotFoundException, SQLException{
		return new GestorVisualizarProducto().visualizarProducto();
	}
}

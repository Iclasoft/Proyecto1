package org.VisualizarPedidos.dominio;

import java.sql.SQLException;
import java.util.List;

public class GestorPedido {
	public List<Object> visualizarPedidos() throws ClassNotFoundException, SQLException{
		return new GestorVisualizarPedido().visualizarPedidos();
	}
}

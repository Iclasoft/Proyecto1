package org.BorrarProductos.dominio;

import java.sql.SQLException;

import org.IntroducirProductos.dominio.GestorAgente;
import org.IntroducirProductos.persistencia.Agente;
import org.VisualizarProducto.dominio.Producto;

public class GestorBorrarProducto {
	public void borrarProducto(Producto p) throws ClassNotFoundException, SQLException{
		GestorAgente gestor=new GestorAgente();
		gestor.connect();
		Agente a=Agente.getAgente();
		a.executeNonQuery("UPDATE producto SET disponible=False WHERE idproducto='"+ p.getIdProducto() +"'");
		gestor.disconect();
	}
}

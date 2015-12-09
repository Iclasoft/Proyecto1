package org.ModificarProductos.dominio;

import java.sql.SQLException;

import org.IntroducirProductos.dominio.GestorAgente;
import org.IntroducirProductos.persistencia.Agente;
import org.VisualizarProducto.dominio.Producto;

public class GestorModificarProducto {
	public void modificarProducto(Producto p) throws ClassNotFoundException, SQLException{
		GestorAgente gestor=new GestorAgente();
		gestor.connect();
		Agente a=Agente.getAgente();
		a.executeNonQuery("UPDATE producto SET disponible=false WHERE idproducto='"+ p.getIdProducto()+"'");
		a.executeNonQuery("INSERT INTO producto(nombre,descripcion,precio,disponible) VALUES('"+p.getNombre()+"','"+p.getDescripcion()+"','"+p.getPrecio()+",True)");
		gestor.disconect();
	}
}

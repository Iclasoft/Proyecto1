package org.IntroducirProductos.dominio;

import java.sql.SQLException;

import org.IntroducirProductos.persistencia.Agente;

public class GestorAniadirProducto {
	public void aniadirProducto(String nombre, String descripcion, double precio) throws SQLException, ClassNotFoundException{
		GestorAgente gestor=new GestorAgente();
		gestor.connect();
		Agente agente=Agente.getAgente();
		agente.executeNonQuery("INSERT INTO producto(nombre, descripcion,precio,disponible) VALUES('"+nombre+"','"+descripcion+"',"+precio+","+true+")");
		gestor.disconect();
	}
}

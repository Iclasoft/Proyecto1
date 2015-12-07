package org.IntroducirClientes.dominio;

import java.sql.SQLException;

import org.IntroducirProductos.dominio.GestorAgente;
import org.IntroducirProductos.persistencia.Agente;

public class GestorAniadirCliente {
	public void aniadirCliente(String DNI, String nombre, String apellidos, String direccion,String tfno, String email) throws ClassNotFoundException, SQLException{
		GestorAgente gestor=new GestorAgente();
		gestor.connect();
		Agente agente=Agente.getAgente();
		agente.executeNonQuery("INSERT INTO cliente(DNI,nombre, apellidos,direccion,tfno,email) VALUES('"+DNI+"','"+nombre+"','"+apellidos+"','"+direccion+"','"+tfno+"','"+email+"')");
		gestor.disconect();
	}
}

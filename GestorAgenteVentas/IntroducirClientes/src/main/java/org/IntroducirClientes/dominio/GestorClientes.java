package org.IntroducirClientes.dominio;

import java.sql.SQLException;

public class GestorClientes {
	public void aniadirCliente(String DNI, String nombre, String apellidos, String direccion,String tfno, String email) throws ClassNotFoundException, SQLException{
		new GestorAniadirCliente().aniadirCliente(DNI, nombre, apellidos, direccion, tfno, email);
	}
}

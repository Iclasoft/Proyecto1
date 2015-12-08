package org.RealizarPedidos.dominio;

import java.sql.SQLException;


public class GestorClientes extends org.IntroducirClientes.dominio.GestorClientes {

	public Cliente leerCliente(String dni) throws ClassNotFoundException, SQLException{
		return new GestorLeerCliente().leerCliente(dni);
	}
}

package org.RealizarPedidos.dominio;

import java.sql.SQLException;
import java.util.List;

import org.IntroducirProductos.dominio.GestorAgente;
import org.IntroducirProductos.persistencia.Agente;
import org.VisualizarProducto.dominio.Producto;

public class GestorLeerCliente {

	public Cliente leerCliente(String dni) throws ClassNotFoundException, SQLException{
		Cliente cli=null;
		GestorAgente gestor=new GestorAgente();
		gestor.connect();
		Agente agente=Agente.getAgente();
		List<List<Object>> la=agente.executeQuery("SELECT * FROM cliente WHERE dni='"+dni+"'");
		gestor.disconect();
		if(!la.isEmpty()){
			cli=new Cliente((String)la.get(0).get(0),(String)la.get(0).get(1),(String)la.get(0).get(2),(String)la.get(0).get(3),(String)la.get(0).get(4),(String)la.get(0).get(5));
		}
		return cli;
		
	}
}

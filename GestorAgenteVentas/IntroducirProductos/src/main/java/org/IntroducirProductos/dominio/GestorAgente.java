package org.IntroducirProductos.dominio;

import java.sql.SQLException;

import org.IntroducirProductos.persistencia.Agente;

public class GestorAgente {
	private static String ruta="datos";
	public void connect() throws ClassNotFoundException, SQLException{
		Agente.getAgente().connect(ruta);
	}
	
	public void disconect(){
		try {
			Agente.getAgente().disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

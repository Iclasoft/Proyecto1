package org.Configuracion.dominio;

import java.io.IOException;
import java.util.ArrayList;

import org.RealizarPedidos.persistencia.GestorXml;
import org.jdom.JDOMException;

public class GestorConfigurar {
	public void guardarconfiguracion(String emaildesde,String password,String emailpara) throws JDOMException, IOException{
		GestorXml gestorXml= GestorXml.getGestorXml();
	    gestorXml.escribir("emailsource",emaildesde);
	    gestorXml.escribir("password",password);
	    gestorXml.escribir("emaildestino", emailpara);
	}
	
	public ArrayList<String> cargarconfiguracion() throws JDOMException, IOException{
		ArrayList<String> config = new ArrayList<String>();
		GestorXml gestorXml= GestorXml.getGestorXml();
		
		
	    config.add(gestorXml.leer("emailsource"));
	    config.add(gestorXml.leer("password"));
	    config.add(gestorXml.leer("emaildestino"));
	    
	    return config;
	}
}

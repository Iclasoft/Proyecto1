package org.Configuracion.dominio;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class GestorConfigurar {
	public void guardarconfiguracion(String emaildesde,String password,String emailpara) throws JDOMException, IOException{
		SAXBuilder builder = new SAXBuilder();
	    File xmlFile = new File( "AgenteVentas.config" );
	    Document document = (Document) builder.build( xmlFile );
	    Element e=document.getRootElement();
	    e.setAttribute("emailsource",emaildesde);
	    e.setAttribute("password",password);
	    e.setAttribute("emaildestino", emailpara);
	}
	
	public ArrayList<String> cargarconfiguracion() throws JDOMException, IOException{
		ArrayList<String> config = new ArrayList<String>();
		SAXBuilder builder = new SAXBuilder();
	    File xmlFile = new File( "AgenteVentas.config" );
	    Document document = (Document) builder.build( xmlFile );
	    Element e=document.getRootElement();
		
	    config.add(e.getAttributeValue("emailsource"));
	    config.add(e.getAttributeValue("password"));
	    config.add(e.getAttributeValue("emaildestino"));
	    
	    return config;
	}
}

package org.RealizarPedidos.persistencia;

import java.io.File;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class GestorXml {
	private static String ruta="AgenteVentas.Config";
	private static GestorXml instancia;
	
	private GestorXml(){
		
	}
	
	public static GestorXml getGestorXml(){
		if(instancia==null){
			instancia=new GestorXml();
		}
		return instancia;
	}
	
	public void escribir(String etiqueta, String valor) throws JDOMException, IOException{
		SAXBuilder builder = new SAXBuilder();
	    File xmlFile = new File( ruta);
	    Document document = (Document) builder.build( xmlFile );
	    Element e=document.getRootElement();
	    e.setAttribute(etiqueta,valor);
	}
	
	public String leer(String etiqueta) throws JDOMException, IOException{
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File( ruta );
	    Document document = (Document) builder.build( xmlFile );
	    Element e=document.getRootElement();
		return e.getAttributeValue(etiqueta);
		
	}
}

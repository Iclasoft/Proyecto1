package org.RealizarPedidos.dominio;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.IntroducirProductos.dominio.GestorAgente;
import org.IntroducirProductos.persistencia.Agente;
import org.RealizarPedidos.persistencia.GestorXml;
import org.VisualizarProducto.dominio.Producto;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.sun.mail.smtp.SMTPTransport;

public class GestorRealizarPedido {

	public void realizarPedido(List<List<Object>> l, Cliente c) throws SQLException, ClassNotFoundException, AddressException, MessagingException, JDOMException, IOException{
		GestorAgente gestor=new GestorAgente();
		gestor.connect();
		Agente agente=Agente.getAgente();
		agente.executeNonQuery("INSERT INTO pedido(dni,entregado) VALUES('"+c.getDNI()+"',"+false+")");
		for(List<Object> list : l){
			agente.executeNonQuery("INSERT INTO pedidoproducto((SELECT MAX(idPedido) FROM pedido),"+((Producto)list.get(0)).getIdProducto()+","+(Integer)list.get(1)+")");
		}
		gestor.disconect();
		Pedido pe=new Pedido(0,c,false,l);
		GestorXml gestorXml=GestorXml.getGestorXml();
	    String emailsource=gestorXml.leer("emailsource");
	    String emaildestino=gestorXml.leer("emailsource");
	    String password=gestorXml.leer("emailsource");
	    
		Properties props = System.getProperties();
	        props.put("mail.smtps.host","smtp.gmail.com");
	        props.put("mail.smtps.auth","true");
	        Session session = Session.getInstance(props, null);
	        Message msg = new MimeMessage(session);
	        msg.setFrom(new InternetAddress(emailsource));;
	        msg.setRecipients(Message.RecipientType.TO,
	        InternetAddress.parse(emaildestino, false));
	        msg.setSubject("Nuevo pedido");
	        msg.setText(pe.toString());
	        msg.setHeader("Pedido", "Pedido");
	        msg.setSentDate(new Date());
	        SMTPTransport t =(SMTPTransport)session.getTransport("smtps");
	        t.connect("smtp.gmail.com", emailsource, password);
	        t.sendMessage(msg, msg.getAllRecipients());
	        System.out.println("Response: " + t.getLastServerResponse());
	        t.close();
		
	}
	
	
}

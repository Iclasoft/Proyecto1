package org.RealizarPedidos.dominio;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.jdom.JDOMException;

public class GestorPedido {

	public void realizarPedido(List<List<Object>> l, Cliente c) throws ClassNotFoundException, SQLException, AddressException, MessagingException, JDOMException, IOException{
		new GestorRealizarPedido().realizarPedido(l,c);
	}
}

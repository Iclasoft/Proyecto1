package org.VisualizarPedidos.dominio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.IntroducirProductos.dominio.GestorAgente;
import org.IntroducirProductos.persistencia.Agente;

public class GestorVisualizarPedido {
	
	public List<Object> visualizarPedidos() throws ClassNotFoundException, SQLException{
		int idpedido;
		String dnicliente;
		GestorAgente gestor=new GestorAgente();
		gestor.connect();
		Agente agente=Agente.getAgente();
		List<List<Object>> listaObject= agente.executeQuery("SELECT * FROM pedido");
		List<Object> listapedidos= new ArrayList<Object>();
		for(List<Object> l : listaObject){
			idpedido = (Integer)l.get(0);
			dnicliente = (String)l.get(1);
			List<List<Object>> listaObject2 = agente.executeQuery("SELECT * FROM cliente WHERE dni ='"+dnicliente+"'");
			List<List<Object>> listaObject3 = agente.executeQuery("SELECT * FROM pedidoproducto WHERE idpedido="+idpedido);
			List<List<Object>> listaObject4;
			List<Object> productos = new ArrayList<Object>();
			for(List<Object> k: listaObject3){
				listaObject4 = agente.executeQuery("SELECT * FROM producto WHERE idproducto="+k.get(1));
				productos.add(new org.VisualizarPedidos.dominio.Producto((Integer)listaObject4.get(0).get(0),(String)listaObject4.get(0).get(1),(String)listaObject4.get(0).get(2),(Double)listaObject4.get(0).get(3),(Boolean)listaObject4.get(0).get(4)));
			}
			List<List<Object>> productosintroducir = new ArrayList<List<Object>>();
			productosintroducir.add(productos);
			listapedidos.add(new org.VisualizarPedidos.dominio.Pedido(idpedido,new Cliente((String)listaObject2.get(0).get(0),(String)listaObject2.get(0).get(1),(String)listaObject2.get(0).get(2),(String)listaObject2.get(0).get(3),(String)listaObject2.get(0).get(4),(String)listaObject2.get(0).get(5)),(Boolean)l.get(2),productosintroducir));
		}
		gestor.disconect();
		return listapedidos;
	}
	
}

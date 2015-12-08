package org.VisualizarProducto.dominio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.IntroducirProductos.dominio.GestorAgente;
import org.IntroducirProductos.persistencia.Agente;

public class GestorVisualizarProducto {

		public List<Producto> visualizarProducto() throws SQLException, ClassNotFoundException{
			GestorAgente gestor=new GestorAgente();
			gestor.connect();
			Agente agente=Agente.getAgente();
			List<List<Object>> listaObject= agente.executeQuery("SELECT * FROM producto WHERE disponible=true");
			gestor.disconect();
			List<Producto> listaproductos= new ArrayList<Producto>();
			for(List<Object> l : listaObject){
				listaproductos.add(new Producto((Integer)l.get(0),(String)l.get(1),(String)l.get(2),(Double)l.get(3),(Boolean)l.get(4)));
			}
			return listaproductos ;
		}
}


package org.IntroducirProductos.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Agente {
	private static Agente instancia;
	private Connection conn;
	
	private Agente(){}
	
	public static Agente getAgente(){
		if(instancia==null){
			instancia=new Agente();
		}
		return instancia;
	}
	
	public void connect(String ruta) throws ClassNotFoundException, SQLException{
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		
		try{
			conn = DriverManager.getConnection("jdbc:derby:."+ruta+";create=false");
		}
		catch(SQLException e){
			conn = DriverManager.getConnection("jdbc:derby:."+ruta+";create=true");
			
			PreparedStatement pstm=conn.prepareStatement("CREATE TABLE PRODUCTO(IDPRODUCTO GENERATED ALWAYS AS IDENTITY (START 1, INCREMENT BY 1)"
														+ ", NOMBRE varchar(50) NOT NULL"
														+ ", DESCRIPCION varchar(500)"
														+ ", PRECIO DOUBLE NOT NULL"
														+ ", DISPONIBLE BOOLEAN"
														+ ", PRIMARY KEY(IDPRODUCTO))");
			pstm.execute();
			pstm.close();
			
			pstm=conn.prepareStatement("CREATE TABLE CLIENTE(DNI varchar(9)"
									+ ", NOMBRE varchar(50) NOT NULL"
									+ ", APELLIDOS varchar(70) NOT NULL"
									+ ", TFNO varchar(14)"
									+ ", EMAIL varchar(50)"
									+ ", DIRECCION varchar(50) NOT NULL"
									+ ", PRIMARY KEY(DNI))");
			pstm.execute();
			pstm.close();
			
			pstm=conn.prepareStatement("CREATE TABLE PEDIDO(IDPEDIDO GENERATED ALWAYS AS IDENTITY (START 1, INCREMENT BY 1)"
									+ ", DNI varchar(9) NOT NULL"
									+ ", ENTREGADO BOOLEAN NOT NULL"
									+ ", PRIMARY KEY(IDPEDIDO)"
									+ ", FOREIGN KEY(DNI) REFERENCES CLIENTE(DNI)");
			pstm.execute();
			pstm.close();
			
			pstm=conn.prepareStatement("CREATE TABLE PEDIDOPRODUCTO(IDPEDIDO INTEGER"
									+ ", IDPRODUCTO INTEGER"
									+ ", CANTIDAD INTEGER NOT NULL"
									+ ", PRIMARY KEY(IDPEDIDO, IDPRODUCTO)"
									+ ", FOREIGN KEY(IDPEDIDO) REFERENCES PEDIDO(IDPEDIDO)"
									+ ", FOREIGN KEY(IDPRODUCTO) REFERENCES PRODUCTO(IDPRODUCTO))");
			pstm.execute();
			pstm.close();
		}
	}
	public void disconnect() throws SQLException{
		if(conn!=null) conn.close();
	}
	public void executeNonQuery(String statement) throws SQLException{
		PreparedStatement pstm=conn.prepareStatement(statement);
		pstm.execute();
		pstm.close();
	}
	public List<List<Object>> executeQuery(String statement) throws SQLException{
		PreparedStatement pstm= conn.prepareStatement(statement);
		ResultSet resultado= pstm.executeQuery();
		List<List<Object>> listaResultados=new ArrayList<List<Object>>();
		int columnas=resultado.getMetaData().getColumnCount();
		while(resultado.next()){
			List<Object> listaTmp=new ArrayList<Object>();
			for(int i=1; i<=columnas ; i++) {
				listaTmp.add(resultado.getObject(i));
			}
			listaResultados.add(listaTmp);
		}
		pstm.close();
		return listaResultados;
	}
	
	
}

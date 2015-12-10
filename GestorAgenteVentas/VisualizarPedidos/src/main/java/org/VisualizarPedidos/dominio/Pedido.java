package org.VisualizarPedidos.dominio;

import java.util.List;


public class Pedido {
	private int IdPedido;
	private Cliente cliente;
	private boolean Entregado;
	private List<List<Object>> listaProductos;
	
	public Pedido(int idPedido, org.VisualizarPedidos.dominio.Cliente cliente, boolean entregado, List<List<Object>> listaProductos) {
		super();
		IdPedido = idPedido;
		this.cliente = cliente;
		Entregado = entregado;
		this.listaProductos = listaProductos;
	}

	public int getIdPedido() {
		return IdPedido;
	}

	public void setIdPedido(int idPedido) {
		IdPedido = idPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isEntregado() {
		return Entregado;
	}

	public void setEntregado(boolean entregado) {
		Entregado = entregado;
	}

	public List<List<Object>> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<List<Object>> listaProductos) {
		this.listaProductos = listaProductos;
	}

	@Override
	public String toString() {
		String txt="";
		txt+=cliente.toString()+"\n\n";
		for(List<Object> lo: listaProductos){
			txt+=lo.get(0).toString()+lo.get(1)+"\n";
		}
		return txt;
		
	}
}

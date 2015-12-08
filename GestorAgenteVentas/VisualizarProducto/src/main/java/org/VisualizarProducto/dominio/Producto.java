package org.VisualizarProducto.dominio;

public class Producto {

	private int IdProducto;
	private String Nombre;
	private String Descripcion;
	private double Precio;
	private boolean Disponible;
	
	public Producto(int idProducto, String nombre, String descripcion, double precio, boolean disponible) {
		super();
		IdProducto = idProducto;
		Nombre = nombre;
		Descripcion = descripcion;
		Precio = precio;
		Disponible = disponible;
	}

	public int getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}

	public boolean isDisponible() {
		return Disponible;
	}

	public void setDisponible(boolean disponible) {
		Disponible = disponible;
	}

	@Override
	public String toString() {
		return "Producto [IdProducto=" + IdProducto + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion
				+ ", Precio=" + Precio + ", Disponible=" + Disponible + "]";
	}
	
	
	
}

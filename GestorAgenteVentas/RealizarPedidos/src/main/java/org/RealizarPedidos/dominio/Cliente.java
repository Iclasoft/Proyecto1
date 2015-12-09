package org.RealizarPedidos.dominio;

public class Cliente {

	private String DNI;
	private String Nombre;
	private String Apellidos;
	private String Tfno;
	private String Email;
	private String Direccion;
	
	public Cliente(String dNI, String nombre, String apellidos, String tfno, String email, String direccion) {
		super();
		DNI = dNI;
		Nombre = nombre;
		Apellidos = apellidos;
		Tfno = tfno;
		Email = email;
		Direccion = direccion;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getTfno() {
		return Tfno;
	}

	public void setTfno(String tfno) {
		Tfno = tfno;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	@Override
	public String toString() {
		return "Cliente [DNI=" + DNI + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Tfno=" + Tfno + ", Email="
				+ Email + ", Direccion=" + Direccion + "]";
	}
	
	
}

package model;

public class Inicio {
	private String titulo;
	private String descripcion;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Inicio(String titulo, String descripcion) {
		
		this.titulo = titulo;
		this.descripcion = descripcion;
	}
	public Inicio() {
	}
	
	

}

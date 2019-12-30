package com.encuesta.model;

public class EncuestaModel {
	
	private String documento;
	private String email;
	private String comentarios;
	private String marca;
	
	public EncuestaModel(String documento, String email, String comentarios,String marca) {
		this.documento= documento;
		this.email= email;
		this.comentarios= comentarios;
		this.marca= marca;
	}
	
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
}

package com.example.pruebaedwin.bean;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class ContactoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private String nombre;
	private String correo;
	private String compania;
	private String tipocompania;
	private String celular;
	private String motivo;
	private String mensaje;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getCompania() {
		return compania;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}
	public String getTipocompania() {
		return tipocompania;
	}
	public void setTipocompania(String tipocompania) {
		this.tipocompania = tipocompania;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}

package com.example.pruebaedwin.service;

import com.example.pruebaedwin.bean.ContactoBean;

public interface EmailService {
	public void enviarEmailContacto(ContactoBean usuario) throws Exception;

	public void enviarEmailRespuestaContacto(ContactoBean contacto) throws Exception;

}

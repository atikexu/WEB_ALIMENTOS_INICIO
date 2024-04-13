package com.example.pruebaedwin.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.pruebaedwin.bean.CategoriaBean;
import com.example.pruebaedwin.bean.ContactoBean;
import com.example.pruebaedwin.bean.MensajeBean;
import com.example.pruebaedwin.bean.ProductoBean;
import com.example.pruebaedwin.service.CategoriaService;
import com.example.pruebaedwin.service.EmailService;
import com.example.pruebaedwin.service.ProductoService;
import com.example.pruebaedwin.bean.SubCategoriaBean;

@Controller
public class AppController {
	public static Logger log = LogManager.getLogger(AppController.class);
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	ProductoService productoService;
	
	@GetMapping("")
	public String inicio() {
		log.info("Inicio");
		return "inicio";
	}
	
	@GetMapping("somos")
	public String somos() {
		log.info("Somos");
		return "somos";
	}
	
	@GetMapping("productos")
	public String productos(Model model) throws Exception {
		log.info("Inicio Productos");
		List<SubCategoriaBean> subcategorias = categoriaService.listarSubCategoria(new SubCategoriaBean());
		model.addAttribute("subcategorias", subcategorias);
		log.info("Fin Productos");
		return "productos";
	}
	
	@GetMapping("contacto")
	public String contacto(Model model) {
		log.info("Inicio Contacto");
		model.addAttribute("contacto", new ContactoBean());
		model.addAttribute("mensaje", new MensajeBean());
		log.info("Inicio Contacto");
		return "contacto";
	}
	
	@PostMapping("/enviarEmailContacto")
	public String enviarEmailContacto(@ModelAttribute ContactoBean contacto, BindingResult result, Model model, RedirectAttributes rm) throws Exception {
		log.info("Inicio enviarEmailContacto");
		
		MensajeBean mensaje = new MensajeBean();

		if(!contacto.getCorreo().isEmpty() && !contacto.getMensaje().isEmpty() && !contacto.getCelular().isEmpty()) {
			emailService.enviarEmailContacto(contacto);
			emailService.enviarEmailRespuestaContacto(contacto);
			model.addAttribute("contacto", contacto);
			model.addAttribute("mensaje", mensaje);
			log.info("Fin enviarEmailContacto");
			return "redirect:/contacto";
		}else {
			mensaje.setMensaje1("Por favor ingrese todos los campos");
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("contacto", contacto);
			log.info("Fin error campos enviarEmailContacto");
			return "contacto";
		}
		
	}
	
	@GetMapping("/enviarEmailContacto")
	public String getEnviarEmailContacto(@ModelAttribute ContactoBean contacto, BindingResult result, Model model, RedirectAttributes rm) throws Exception {
		log.info("Inicio getenviarEmailContacto");
		MensajeBean mensaje = new MensajeBean();
		mensaje.setMensaje1("");
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("contacto", contacto);
		log.info("Fin getenviarEmailContacto");
		return "contacto";
		
	}
	
	@GetMapping(value="/precios")
	public String listarProductos(@RequestParam("categoria") String categoria, Model model) throws Exception {
		log.info("Inicio getPrecios");
		model.addAttribute("producto", new ProductoBean());
		List<CategoriaBean> categorias = categoriaService.listarCategoria(new CategoriaBean());
		CategoriaBean categoriaObtener = new CategoriaBean();
		categoriaObtener.setIdCategoria(Integer.parseInt(categoria));
		CategoriaBean categoriaSel = categoriaService.obtenerCategoriaXId(categoriaObtener);
		ProductoBean productoBean = new ProductoBean();
		productoBean.setIdCategoria(Integer.parseInt(categoria));
		List<ProductoBean> productos = productoService.listarProductosXCategoria(productoBean);
		List<SubCategoriaBean> subcategorias = categoriaService.listarSubCategoria(new SubCategoriaBean());
		model.addAttribute("totalProductos", productos.size());
		model.addAttribute("categoriaSel", categoriaSel);
		model.addAttribute("categorias", categorias);
		model.addAttribute("subcategorias", subcategorias);
		model.addAttribute("productos", productos);
		log.info("Fin getPrecios");
	    return "precios";
	}
	
	@PostMapping(value="/precios")
	public String verProducto(@RequestParam("categoria") String categoria, @RequestParam("producto") String producto, Model model) throws Exception {
		log.info("Inicio Precios");
		model.addAttribute("producto", new ProductoBean());
		List<CategoriaBean> categorias = categoriaService.listarCategoria(new CategoriaBean());
		CategoriaBean categoriaObtener = new CategoriaBean();
		categoriaObtener.setIdCategoria(Integer.parseInt(categoria));
		CategoriaBean categoriaSel = categoriaService.obtenerCategoriaXId(categoriaObtener);
		ProductoBean productoBean = new ProductoBean();
		productoBean.setIdCategoria(Integer.parseInt(categoria));
		List<ProductoBean> productos = productoService.listarProductosXCategoria(productoBean);
		List<SubCategoriaBean> subcategorias = categoriaService.listarSubCategoria(new SubCategoriaBean());
		model.addAttribute("categoriaSel", categoriaSel);
		model.addAttribute("totalProductos", productos.size());
		model.addAttribute("categorias", categorias);
		model.addAttribute("subcategorias", subcategorias);
		model.addAttribute("productos", productos);
		log.info("Fin Precios");
	    return "precios";
	}
	
	@GetMapping(value="/preciosub")
	public String verProducto2(@RequestParam("categoria") String categoria, @RequestParam("subcategoria") String subcategoria, Model model) throws Exception {
		log.info("Inicio preciosub");
		model.addAttribute("producto", new ProductoBean());
		List<CategoriaBean> categorias = categoriaService.listarCategoria(new CategoriaBean());
		CategoriaBean categoriaObtener = new CategoriaBean();
		categoriaObtener.setIdCategoria(Integer.parseInt(categoria));
		CategoriaBean categoriaSel = categoriaService.obtenerCategoriaXId(categoriaObtener);
		ProductoBean productoBean = new ProductoBean();
		productoBean.setIdCategoria(Integer.parseInt(categoria));
		productoBean.setIdSubCategoria(Integer.parseInt(subcategoria));
		List<ProductoBean> productos = productoService.listarProductosXSubCategoria(productoBean);
		List<SubCategoriaBean> subcategorias = categoriaService.listarSubCategoria(new SubCategoriaBean());
		model.addAttribute("categoriaSel", categoriaSel);
		model.addAttribute("totalProductos", productos.size());
		model.addAttribute("categorias", categorias);
		model.addAttribute("subcategorias", subcategorias);
		model.addAttribute("productos", productos); 
		log.info("Fin preciosub");
	    return "precios";
	} 
	
	//PARA OBTENER BUSQUEDA POR NOMBRE
	@PostMapping(value="/buscarprecios")
	public String buscarProductos(@ModelAttribute ProductoBean producto, BindingResult result, Model model, RedirectAttributes rm) throws Exception {
		log.info("Inicio buscarprecios");
		model.addAttribute("producto", new ProductoBean());
		List<CategoriaBean> categorias = categoriaService.listarCategoria(new CategoriaBean());
		CategoriaBean categoriaObtener = new CategoriaBean();
		ProductoBean productoBean = new ProductoBean();
		productoBean.setNombre(producto.getNombre());
		List<ProductoBean> productos = productoService.buscarProductosXNombre(productoBean);
		if(productos.size()>0) {
			categoriaObtener.setIdCategoria(productos.get(0).getIdCategoria());
		}else {
			categoriaObtener.setIdCategoria(1);
		}
		
		CategoriaBean categoriaSel = categoriaService.obtenerCategoriaXId(categoriaObtener);
		List<SubCategoriaBean> subcategorias = categoriaService.listarSubCategoria(new SubCategoriaBean());
		model.addAttribute("totalProductos", productos.size());
		model.addAttribute("categoriaSel", categoriaSel);
		model.addAttribute("categorias", categorias);
		model.addAttribute("subcategorias", subcategorias);
		model.addAttribute("productos", productos);
		log.info("Fin buscarprecios");
	    return "precios";
	}
	
	@GetMapping(value="/buscarprecios")
	public String getBuscarProductos(@ModelAttribute ProductoBean producto, BindingResult result, Model model, RedirectAttributes rm) throws Exception {
		log.info("Inicio getbuscarprecios");
		model.addAttribute("producto", new ProductoBean());
		List<CategoriaBean> categorias = categoriaService.listarCategoria(new CategoriaBean());
		CategoriaBean categoriaObtener = new CategoriaBean();
		ProductoBean productoBean = new ProductoBean();
		productoBean.setNombre(producto.getNombre());
		List<ProductoBean> productos = productoService.buscarProductosXNombre(productoBean);
		if(productos.size()>0) {
			categoriaObtener.setIdCategoria(productos.get(0).getIdCategoria());
		}else {
			categoriaObtener.setIdCategoria(1);
		}
		
		CategoriaBean categoriaSel = categoriaService.obtenerCategoriaXId(categoriaObtener);
		List<SubCategoriaBean> subcategorias = categoriaService.listarSubCategoria(new SubCategoriaBean());
		model.addAttribute("totalProductos", productos.size());
		model.addAttribute("categoriaSel", categoriaSel);
		model.addAttribute("categorias", categorias);
		model.addAttribute("subcategorias", subcategorias);
		model.addAttribute("productos", productos);
		log.info("Fin getbuscarprecios");
	    return "precios";
	}
}

package com.example.pruebaedwin.service;

import java.util.List;

import com.example.pruebaedwin.bean.ProductoBean;

public interface ProductoService {
	public List<ProductoBean> listarProducto(ProductoBean productoBean) throws Exception;
	public ProductoBean obtenerProductoXId(ProductoBean productoBean) throws Exception;
	public ProductoBean registrarProducto(ProductoBean productoBean) throws Exception;
	public ProductoBean actualizarProducto(ProductoBean productoBean) throws Exception;
	public List<ProductoBean> listarProductosXCategoria(ProductoBean productoBean) throws Exception;
	public List<ProductoBean> buscarProductosXNombre(ProductoBean productoBean) throws Exception;
	public List<ProductoBean> listarProductosXSubCategoria(ProductoBean productoBean) throws Exception;
}

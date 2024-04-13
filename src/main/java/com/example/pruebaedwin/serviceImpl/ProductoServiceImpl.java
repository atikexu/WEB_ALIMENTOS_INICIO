package com.example.pruebaedwin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebaedwin.bean.ProductoBean;
import com.example.pruebaedwin.dao.ProductoDao;
import com.example.pruebaedwin.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	ProductoDao productoDao;

	@Override
	public List<ProductoBean> listarProducto(ProductoBean productoBean) throws Exception {
		return productoDao.listarProducto(productoBean);
	}

	@Override
	public ProductoBean obtenerProductoXId(ProductoBean productoBean) throws Exception {
		return productoDao.obtenerProductoXId(productoBean);
	}

	@Override
	public ProductoBean registrarProducto(ProductoBean productoBean) throws Exception {
		return productoDao.registrarProducto(productoBean);
	}

	@Override
	public ProductoBean actualizarProducto(ProductoBean productoBean) throws Exception {
		return productoDao.actualizarProducto(productoBean);
	}
	
	@Override
	public List<ProductoBean> listarProductosXCategoria(ProductoBean productoBean) throws Exception {
		return productoDao.listarProductosXCategoria(productoBean);
	}
	
	@Override
	public List<ProductoBean> buscarProductosXNombre(ProductoBean productoBean) throws Exception {
		return productoDao.buscarProductosXNombre(productoBean);
	}

	@Override
	public List<ProductoBean> listarProductosXSubCategoria(ProductoBean productoBean) throws Exception {
		return productoDao.listarProductosXSubCategoria(productoBean);
	}
}

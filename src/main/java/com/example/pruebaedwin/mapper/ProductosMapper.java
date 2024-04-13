package com.example.pruebaedwin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.pruebaedwin.bean.ProductoBean;

public class ProductosMapper implements RowMapper<ProductoBean>{
	@Override
	public ProductoBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductoBean productoBean = new ProductoBean();
		productoBean.setIdProducto(rs.getInt("idproducto"));
		productoBean.setIdSubCategoria(rs.getInt("idsubcategoria"));
		productoBean.setIdCategoria(rs.getInt("idcategoria"));
		productoBean.setNombre(rs.getString("nombre"));
		productoBean.setDescripcion(rs.getString("descripcion"));
		productoBean.setPrecio(rs.getDouble("precio"));
		productoBean.setEstado(rs.getString("estado"));
		productoBean.setNombreImagen(rs.getString("nombreimagen"));
		return productoBean;
	}
}

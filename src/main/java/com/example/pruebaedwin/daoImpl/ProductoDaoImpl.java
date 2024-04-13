package com.example.pruebaedwin.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.pruebaedwin.bean.ProductoBean;
import com.example.pruebaedwin.dao.ProductoDao;
import com.example.pruebaedwin.mapper.ProductosMapper;

@Repository
public class ProductoDaoImpl implements ProductoDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<ProductoBean> listarProducto(ProductoBean productoBean) throws Exception {
		String sql="select * from alimentos.producto where estado='1'";
		List<ProductoBean> productos= jdbcTemplate.query(sql,new ProductosMapper());
		return productos;
	}
	
	@Override
	public ProductoBean obtenerProductoXId(ProductoBean productoBean) throws Exception {
		ProductoBean producto = new ProductoBean();
		String sql="select * from alimentos.producto where idproducto=? and estado='1'";
		List<ProductoBean> buscar= jdbcTemplate.query(sql,new ProductosMapper(),productoBean.getIdProducto());
		if(buscar.isEmpty()) {
			producto = null;
		}else {
			producto = buscar.get(0);
		}
		return producto;
	}
	
	@Override
	public ProductoBean registrarProducto(ProductoBean productoBean) throws Exception {
		String sql = "insert into alimentos.producto(nombre,descripcion,estado,precio) values(?,?,?,?)";
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, productoBean.getNombre());
                ps.setString(2, productoBean.getDescripcion());
                ps.setString(3, productoBean.getEstado());
                ps.setDouble(4, productoBean.getPrecio());
                return ps;
            }
        }, holder);
        if (holder.getKeys().size() > 1) {
        	Long newId2 = (Long) holder.getKeys().get("idproducto");
        	productoBean.setIdProducto(newId2.intValue());
        }
        return productoBean;
	}
	
	@Override
	public ProductoBean actualizarProducto(ProductoBean productoBean) throws Exception {
		String sql = "update alimentos.producto "
				+ "set estado=?, nombre=?, descripcion=?, precio=? where idproducto=?";
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, productoBean.getEstado());
                ps.setString(2, productoBean.getNombre());
                ps.setString(3, productoBean.getDescripcion());
                ps.setDouble(4, productoBean.getPrecio());
                ps.setInt(5, productoBean.getIdProducto());
                return ps;
            }
        }, holder);
        return productoBean;
	}
	
	@Override
	public List<ProductoBean> listarProductosXCategoria(ProductoBean productoBean) throws Exception {
		String sql="select * from alimentos.producto where idcategoria=? and estado='1'";
		List<ProductoBean> productos= jdbcTemplate.query(sql,new ProductosMapper(),productoBean.getIdCategoria());
		return productos;
	}
	
	@Override
	public List<ProductoBean> listarProductosXSubCategoria(ProductoBean productoBean) throws Exception {
		String sql="select * from alimentos.producto where idcategoria=? and idsubcategoria=? and estado='1'";
		List<ProductoBean> productos= jdbcTemplate.query(sql,new ProductosMapper(),productoBean.getIdCategoria(),productoBean.getIdSubCategoria());
		return productos;
	}
	
	@Override
	public List<ProductoBean> buscarProductosXNombre(ProductoBean productoBean) throws Exception {
		String sql="select * from alimentos.producto where UNACCENT(UPPER(nombre)) like UNACCENT(UPPER('%"+productoBean.getNombre()+"%')) and estado='1'";
		List<ProductoBean> productos= jdbcTemplate.query(sql,new ProductosMapper());
		return productos;
	}

}

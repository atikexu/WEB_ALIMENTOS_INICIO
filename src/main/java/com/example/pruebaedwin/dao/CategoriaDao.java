package com.example.pruebaedwin.dao;

import java.util.List;

import com.example.pruebaedwin.bean.CategoriaBean;
import com.example.pruebaedwin.bean.SubCategoriaBean;

public interface CategoriaDao {
	public abstract List<CategoriaBean> listarCategoria(CategoriaBean categoriaBean) throws Exception;
	public abstract CategoriaBean obtenerCategoriaXId(CategoriaBean categoriaBean) throws Exception;
	public abstract CategoriaBean registrarCategoria(CategoriaBean categoriaBean) throws Exception;
	public abstract CategoriaBean actualizarCategoria(CategoriaBean categoriaBean) throws Exception;
	public abstract List<SubCategoriaBean> listarSubCategoria(SubCategoriaBean subCategoriaBean);
}

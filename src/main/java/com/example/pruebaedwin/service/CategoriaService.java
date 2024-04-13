package com.example.pruebaedwin.service;

import java.util.List;

import com.example.pruebaedwin.bean.CategoriaBean;
import com.example.pruebaedwin.bean.SubCategoriaBean;

public interface CategoriaService {
	public List<CategoriaBean> listarCategoria(CategoriaBean categoriaBean) throws Exception;
	public CategoriaBean obtenerCategoriaXId(CategoriaBean categoriaBean) throws Exception;
	public CategoriaBean registrarCategoria(CategoriaBean categoriaBean) throws Exception;
	public CategoriaBean actualizarCategoria(CategoriaBean categoriaBean) throws Exception;
	public List<SubCategoriaBean> listarSubCategoria(SubCategoriaBean subCategoriaBean) throws Exception;
}

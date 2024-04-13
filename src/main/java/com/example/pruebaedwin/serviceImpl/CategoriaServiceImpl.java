package com.example.pruebaedwin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebaedwin.bean.CategoriaBean;
import com.example.pruebaedwin.bean.SubCategoriaBean;
import com.example.pruebaedwin.dao.CategoriaDao;
import com.example.pruebaedwin.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	CategoriaDao categoriaDao;

	@Override
	public List<CategoriaBean> listarCategoria(CategoriaBean categoriaBean) throws Exception {
		return categoriaDao.listarCategoria(categoriaBean);
	}

	@Override
	public CategoriaBean obtenerCategoriaXId(CategoriaBean categoriaBean) throws Exception {
		return categoriaDao.obtenerCategoriaXId(categoriaBean);
	}

	@Override
	public CategoriaBean registrarCategoria(CategoriaBean categoriaBean) throws Exception {
		return categoriaDao.registrarCategoria(categoriaBean);
	}

	@Override
	public CategoriaBean actualizarCategoria(CategoriaBean categoriaBean) throws Exception {
		return categoriaDao.actualizarCategoria(categoriaBean);
	}

	@Override
	public List<SubCategoriaBean> listarSubCategoria(SubCategoriaBean subCategoriaBean) throws Exception {
		return categoriaDao.listarSubCategoria(subCategoriaBean);
	}
}

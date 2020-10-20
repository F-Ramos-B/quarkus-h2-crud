package br.com.stefanini.maratonadev.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.stefanini.maratonadev.dao.TodoDao;


@RequestScoped
public class TodoService {

	@Inject
	TodoDao dao;
	
	private void validar() {
		//validar regra de negocio
	}
	@Transactional(rollbackOn = Exception.class)
	public void inserir() {
		//validação
		validar();
		//chamada da dao
	}
	
	public void listar() {
		//chamada da dao
	}


}

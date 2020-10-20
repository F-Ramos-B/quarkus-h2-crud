package br.com.stefanini.maratonadev.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.stefanini.maratonadev.dao.TodoDao;
import br.com.stefanini.maratonadev.model.Todo;


@RequestScoped
public class TodoService {

	@Inject
	TodoDao todoDAO;
	
	@Transactional(rollbackOn = Exception.class)
	public List<Todo> inserir(Todo todo) {
		Todo.persist(todo);
		return this.listar();
	}
	
	public List<Todo> listar() {
		return todoDAO.listar();
	}
	
	public Optional<Todo> recuperarPorId(Long id) {
		return todoDAO.recuperarPorId(id);
	}
	
	@Transactional(rollbackOn = Exception.class)
	public boolean remover(Long id) {
		if (this.todoInexistente(id)) {
			return false;
		}
		
		todoDAO.remover(id);
		
		return true;
	}
	
	@Transactional(rollbackOn = Exception.class)
	public boolean alterar(Todo todo) {
		if (this.todoInexistente(todo.getId())) {
			return false;
		}
		
		todoDAO.alterar(todo);
		
		return true;
	}
	
	private boolean todoInexistente(Long id) {
		return this.recuperarPorId(id).isEmpty();
	}

}

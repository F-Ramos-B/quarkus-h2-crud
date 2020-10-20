package br.com.stefanini.maratonadev.dao;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;

import br.com.stefanini.maratonadev.model.Todo;

@RequestScoped
public class TodoDao {

	public void inserir(Todo todo) {
		Todo.persist(todo);
	}
	
	public List<Todo> listar() {
		return Todo.listAll();
	}
	
	public Optional<Todo> recuperarPorId(Long id) {
		return Todo.findByIdOptional(id);
	}
	
	public void remover(Long id) {
		Todo.deleteById(id);
	}
	
	public void alterar(Todo todo) {
		Todo.update("nome = ?1 where id = ?2", todo.getNome(), todo.getId());
	}
	
	
}

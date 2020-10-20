package br.com.stefanini.maratonadev.dao;

import java.util.List;

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
	
}

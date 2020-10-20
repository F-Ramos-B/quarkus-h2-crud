package br.com.stefanini.maratonadev.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.stefanini.maratonadev.model.Todo;
import br.com.stefanini.maratonadev.service.TodoService;

@Path("todo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoRest {
	
	@Inject
	TodoService todoService;
	
	@GET
	public Response listarTodos() {
		return Response.ok(todoService.listar()).build();
	}
	
	@POST
	public Response inserirTodo(Todo todo) {
		return Response.ok(todoService.inserir(todo)).build();
	}
	

}

package br.com.stefanini.maratonadev.rest;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
	
	@GET
	@Path("/{id}")
	public Response listarPorId(@PathParam("id") Long id) {
		Optional<Todo> todo = todoService.recuperarPorId(id);
		if (todo.isPresent()) {
			return Response.ok(todo.get()).build();
		}
		
		return Response.status(Status.NO_CONTENT).build();
	}
	
	@POST
	public Response inserirTodo(Todo todo) {
		return Response.ok(todoService.inserir(todo)).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removerTodo(@PathParam("id") Long id) {
		if (todoService.remover(id)) {
			return Response.ok().build();
		}
		
		return Response.status(Status.NOT_FOUND).build();
	}
	
	@PUT
	public Response alterarTodo(Todo todo) {
		if (todoService.alterar(todo)) {
			return Response.ok().build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	

}

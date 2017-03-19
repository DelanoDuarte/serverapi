/**
 * 
 */
package br.simpleapp.rest;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.simpleapp.bussiness.FuncionarioBusiness;
import br.simpleapp.domain.Funcionario;

/**
 * @author delano.duarte
 *
 */
@Stateless
@Path("/funcionario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FuncionarioResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioBusiness funcionarioBusiness;

	@Path("/all")
	@GET
	public Response all() {
		try {
			List<Funcionario> funcionarios = funcionarioBusiness.all();
			return Response.ok().entity(funcionarios).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@Path("/new")
	@POST
	public Response save(Funcionario funcionario) {
		try {
			funcionarioBusiness.save(funcionario);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@Path("/{id}")
	@GET
	public Response findById(@PathParam(value = "id") Long id) {
		try {
			Funcionario funcionario = funcionarioBusiness.findById(id);
			return Response.ok().entity(funcionario).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
}

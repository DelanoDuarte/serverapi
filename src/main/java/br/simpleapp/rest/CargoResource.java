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

import br.simpleapp.bussiness.CargoBusiness;
import br.simpleapp.domain.Cargo;

/**
 * @author delano.duarte
 *
 */
@Stateless
@Path("/cargo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CargoResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CargoBusiness cargoBusiness;

	@Path("/new")
	@POST
	public Response save(Cargo cargo) {
		try {
			cargoBusiness.save(cargo);
			return Response.ok().entity(cargo).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@Path("/all")
	@GET
	public Response all() {
		try {
			List<Cargo> cargos = cargoBusiness.all();
			return Response.ok().entity(cargos).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@Path("/{id}")
	@GET
	public Response findById(@PathParam(value = "id") Long id) {
		try {
			Cargo cargo = cargoBusiness.findById(id);
			return Response.ok().entity(cargo).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
}

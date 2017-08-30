/**
 * 
 */
package br.simpleapp.rest;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.simpleapp.jobs.JobTask;

/**
 * @author Delano Jr
 *
 */
@Stateless
@Path("/simplejob")
@Produces(MediaType.APPLICATION_JSON)
public class JobTaskResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private JobTask jobTask;

	@Path("runJob")
	@GET
	public Response runJob() {
		try {
			jobTask.setFutureTimer(new Date());

			return Response.ok().build();
		} catch (ParseException e) {
			e.printStackTrace();

			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}

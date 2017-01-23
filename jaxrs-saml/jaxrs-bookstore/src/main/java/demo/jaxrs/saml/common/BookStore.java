package demo.jaxrs.saml.common;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/bookstore")
@Produces("application/json")
@Consumes("application/json")
public interface BookStore
{
	@GET
	@Path("/books/{id}")
	Response getBook(@PathParam("id") Long id);

	@PUT
	@Path("/books/{id}")
	Response updateBook(@PathParam("id") Long id, Book book);

	@POST
	@Path("/books")
	Response createBook(Book book);

	@DELETE
	@Path("/books/{id}")
	Response removeBook(@PathParam("id") Long id);
}
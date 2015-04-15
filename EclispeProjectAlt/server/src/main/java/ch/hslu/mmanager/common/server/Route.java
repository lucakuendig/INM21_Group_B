package ch.hslu.mmanager.common.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
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

import ch.hslu.mmanager.common.dao.DAO;
import ch.hslu.mmanager.common.model.*;;




@Path("/")
public class Route {

	private Map<String, DAO<?, Integer>> hm = new HashMap<String, DAO<?, Integer>>();

	public Route() {
		hm.put("person", new Controller<Person, Integer>(Person.class));
		hm.put("user", new Controller<User, Integer>(User.class));
		
	}

	@RolesAllowed("Administrator")
	@GET
	@Path("{entity}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public IModel getEntityById(@PathParam("entity") String entity,
			@PathParam("id") int id) {
		return (IModel) hm.get(entity).getById(id);
	}

	@PermitAll
	@SuppressWarnings("unchecked")
	@GET
	@Path("{entity}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<IModel> getAll(@PathParam("entity") String entity) {
		return (List<IModel>) hm.get(entity).getAll();
	}

	
	/**
	 * Person
	 */
	@RolesAllowed("Administrator")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DELETE
	@Path("person/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletePerson(@PathParam("id") int id) {
		((DAO) hm.get("person")).delete(((DAO) hm.get("person")).getById(id));
		return Response.status(Status.OK).entity("Person deleted").build();
	}

	@RolesAllowed("Administrator")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PUT
	@Path("person")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePerson(Person t) {
		((DAO) hm.get("person")).update(t);
		return Response.status(Status.OK).entity("Person updated").build();
	}

	@RolesAllowed("Administrator")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@POST
	@Path("person")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response persistPerson(Person t) {
		((DAO) hm.get("person")).persist(t);
		return Response.status(Status.OK).entity("Person added").build();
	}

	

	/**
	 * User
	 */
	@RolesAllowed("Administrator")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DELETE
	@Path("user/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("id") int id) {
		((DAO) hm.get("user")).delete(((DAO) hm.get("user")).getById(id));
		return Response.status(Status.OK).entity("User deleted").build();
	}

	@RolesAllowed("Administrator")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PUT
	@Path("user")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(User t) {
		((DAO) hm.get("user")).update(t);
		return Response.status(Status.OK).entity("User updated").build();
	}

	@RolesAllowed("Administrator")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@POST
	@Path("user")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response persistUser(User t) {
		((DAO) hm.get("user")).persist(t);
		return Response.status(Status.OK).entity("User added").build();
	}

	
//	@PermitAll
//	@SuppressWarnings({ "unchecked" })
//	@POST
//	@Path("login")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response login(User user) {
//
//		List<User> users = ((List<User>) hm.get("user").getAll()).stream()
//				.filter(p -> p.getEmail().equals(user.getEmail()))
//				.filter(p -> p.getPassword().equals(user.getPassword()))
//				.collect(Collectors.toList());
//
//		if (users.size() == 1) {
//			return Response.status(Status.OK).entity(users.get(0)).build();
//		} else {
//			return Response.status(Status.UNAUTHORIZED).build();
//		}
//	}

	
}

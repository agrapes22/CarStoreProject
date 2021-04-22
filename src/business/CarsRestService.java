package business;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Car;

@RequestScoped
@Path("")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class CarsRestService {
	@Inject
	BusinessServiceInterface bs;
	
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Car> getAllCarsAsJson() {
		return bs.readAll();
	}
	
	@GET
	@Path("/getjsonbyid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public Car getOneCarAsJson(@PathParam("id") int id) {
		return bs.readOne(id);
	}
}

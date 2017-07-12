package cn.sky.test.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import cn.sky.test.webservice.client.entity.City;

@Path("/location")
@Produces({ "application/json", "application/xml" })
public interface Location {

	@GET
	@POST
	@Path("/city")
	@Produces({ "application/json", "application/xml" })
	public City city();

}

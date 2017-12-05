package com.BugFinder;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Produces({"application/json" })
public interface WebService {

	@POST
	@Path("/sendRequest/")
	public abstract ResponseToBot initiateSearch(Example example);

	
//	@POST
//	@Path("/addBug/id")
//	public abstract String addBug(String id);
}
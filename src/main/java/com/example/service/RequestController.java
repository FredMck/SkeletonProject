package com.example.service;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.example.beans.dao.ExampleDaoBean;
import com.example.entity.TblEmployee;

@Path("/example")
public class RequestController {
	
	static Logger logger = Logger.getLogger(RequestController.class);
	
	@EJB
	ExampleDaoBean exampleDaoBean;
	
	@Context 
	private HttpHeaders httpHeaders;
	@Context 
	private HttpServletRequest request;
	
	
	
	@GET
	//@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getTest")
	public Response serviceTest () {
		logger.info("Test Message");
		
		List<TblEmployee> returnList = exampleDaoBean.readAllEmployeesWithFirstName("freddie");
		return Response.status(Response.Status.OK).entity(returnList).build();
	}

}

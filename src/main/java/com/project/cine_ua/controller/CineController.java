package com.project.cine_ua.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import com.project.cine_ua.dao.CineDao;
import com.project.cine_ua.model.Cine;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("cine")
public class CineController {

	private CineDao cineDao = new CineDao();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cine> findAll(){
		List<Cine> cineList = cineDao.findAll();
		
		return cineList;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") Long id) {
		Cine cine = cineDao.findById(id);
		
		GenericEntity<Cine> entity = new GenericEntity<Cine>(cine, Cine.class);
		return Response.ok().entity(entity).build();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response  save(Cine cine) throws URISyntaxException {
		Cine cine1 = cineDao.save(cine);
		
		GenericEntity<Cine> entity = new GenericEntity<Cine>(cine, Cine.class);
		return Response.created(new URI("/portal/api/Cine/"+cine1.getCineId())).entity(entity).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response  save(@PathParam("id") Long id,Cine cine){
		Cine cine1 = cineDao.update(id, cine);
		
		GenericEntity<Cine> entity = new GenericEntity<Cine>(cine1, Cine.class);
		return Response.ok().entity(entity).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		cineDao.delete(id);
		
		return Response.status(202).entity("Deleted Cine"+id).build();
	}
}

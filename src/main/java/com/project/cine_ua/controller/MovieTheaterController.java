package com.project.cine_ua.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.glassfish.jersey.internal.guava.RemovalCause;

import com.project.cine_ua.dao.MovieTheaterDao;

import com.project.cine_ua.model.MovieTheater;

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

@Path("movie-theater")
public class MovieTheaterController {

	
	private MovieTheaterDao movieTheaterDao = new MovieTheaterDao();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<MovieTheater> findAll(){
		List<MovieTheater> movieTheaterList = movieTheaterDao.findAll();
		
		return movieTheaterList ;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") Long id) {
		MovieTheater movieTheater = movieTheaterDao.findById(id);
		
		GenericEntity<MovieTheater> entity = new GenericEntity<MovieTheater>(movieTheater, MovieTheater.class);
		return Response.ok().entity(entity).build();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response  save(MovieTheater movieTheater) throws URISyntaxException {
		MovieTheater movieTheater2 = movieTheaterDao.save(movieTheater);
		
		GenericEntity<MovieTheater> entity = new GenericEntity<MovieTheater>(movieTheater2, MovieTheater.class);
		return Response.created(new URI("/portal/api/Cine/"+movieTheater2.getCineId())).entity(entity).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response  save(@PathParam("id") Long id,MovieTheater movieTheater){
		MovieTheater movieTheater2 = movieTheaterDao.update(id, movieTheater);
		
		GenericEntity<MovieTheater> entity = new GenericEntity<MovieTheater>(movieTheater2, MovieTheater.class);
		return Response.ok().entity(entity).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		movieTheaterDao.delete(id);
		
		return Response.status(202).entity("Deleted movie theater"+id).build();
	}
	
}

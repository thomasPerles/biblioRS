package com.m2i.bibliors.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.bibliocommon.bo.LivreAvis;
import com.m2i.bibliocommon.exception.BiblioException;
import com.m2i.bibliocommon.service.ILivreAvisService;
import com.m2i.bibliors.exception.BiblioNotFoundException;

@Service
@Path("/livreAvis")
public class LivreAvisRS {

	@Autowired
	private ILivreAvisService livreAvisService;

	public LivreAvisRS() {
		super();
	}

	public ILivreAvisService getLivreAvisService() {
		return this.livreAvisService;
	}

	public void setLivreAvisService(ILivreAvisService livreAvisService) {
		this.livreAvisService = livreAvisService;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<LivreAvis> findAll() {
		List<LivreAvis> livreAviss;
		try {
			livreAviss = this.livreAvisService.findAll();
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
		return livreAviss;
	}

	@GET
	@Path("{ id }")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public LivreAvis get(@PathParam("id") Integer id) {
		LivreAvis livreAvis;
		try {
			livreAvis = this.livreAvisService.get(id);
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
		return livreAvis;
	}

	@DELETE
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void delete(LivreAvis livreAvis) {
		try {
			this.livreAvisService.delete(livreAvis);
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
	}

	@DELETE
	@Path("{ id }")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void delete(@PathParam("id") Integer id) {
		try {
			this.livreAvisService.delete(new LivreAvis(id));
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public LivreAvis save(LivreAvis livreAvis) {
		try {
			this.livreAvisService.save(livreAvis);
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
		return livreAvis;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public LivreAvis update(LivreAvis livreAvis) {
		try {
			this.livreAvisService.update(livreAvis);
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
		return livreAvis;
	}

}

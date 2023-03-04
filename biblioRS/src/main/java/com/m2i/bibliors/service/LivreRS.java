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

import com.m2i.bibliocommon.bo.Livre;
import com.m2i.bibliocommon.exception.BiblioException;
import com.m2i.bibliocommon.service.ILivreService;
import com.m2i.bibliors.exception.LivreNotFoundException;

@Service
@Path("/livre")
public class LivreRS {

	@Autowired
	private ILivreService livreService;

	public LivreRS() {
		super();
	}

	public ILivreService getLivreService() {
		return this.livreService;
	}

	public void setLivreService(ILivreService livreService) {
		this.livreService = livreService;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Livre> findAll() {
		List<Livre> livres;
		try {
			livres = this.livreService.findAll();
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new LivreNotFoundException();
		}
		return livres;
	}

	@GET
	@Path("{ id }")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Livre get(@PathParam("id") Integer id) {
		Livre livre;
		try {
			livre = this.livreService.get(id);
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new LivreNotFoundException();
		}
		return livre;
	}

	@DELETE
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void delete(Livre livre) {
		try {
			this.livreService.delete(livre);
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new LivreNotFoundException();
		}
	}

	@DELETE
	@Path("{ id }")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void delete(@PathParam("id") Integer id) {
		try {
			this.livreService.delete(new Livre(id));
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new LivreNotFoundException();
		}
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Livre save(Livre livre) {
		try {
			this.livreService.save(livre);
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new LivreNotFoundException();
		}
		return livre;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Livre update(Livre livre) {
		try {
			this.livreService.update(livre);
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new LivreNotFoundException();
		}
		return livre;
	}

}

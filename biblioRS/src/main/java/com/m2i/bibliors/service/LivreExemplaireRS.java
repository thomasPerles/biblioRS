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

import com.m2i.bibliocommon.bo.LivreExemplaire;
import com.m2i.bibliocommon.exception.BiblioException;
import com.m2i.bibliocommon.service.ILivreExemplaireService;
import com.m2i.bibliors.exception.BiblioNotFoundException;

@Service
@Path("/livreExemplaire")
public class LivreExemplaireRS {

	@Autowired
	private ILivreExemplaireService livreExemplaireService;

	public LivreExemplaireRS() {
		super();
	}

	public ILivreExemplaireService getLivreExemplaireService() {
		return this.livreExemplaireService;
	}

	public void setLivreExemplaireService(ILivreExemplaireService livreExemplaireService) {
		this.livreExemplaireService = livreExemplaireService;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<LivreExemplaire> findAll() {
		List<LivreExemplaire> livreExemplaires;
		try {
			livreExemplaires = this.livreExemplaireService.findAll();
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
		return livreExemplaires;
	}

	@GET
	@Path("{ id }")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public LivreExemplaire get(@PathParam("id") Integer id) {
		LivreExemplaire livreExemplaire;
		try {
			livreExemplaire = this.livreExemplaireService.get(id);
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
		return livreExemplaire;
	}

	@DELETE
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void delete(LivreExemplaire livreExemplaire) {
		try {
			this.livreExemplaireService.delete(livreExemplaire);
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
			this.livreExemplaireService.delete(new LivreExemplaire(id));
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public LivreExemplaire save(LivreExemplaire livreExemplaire) {
		try {
			this.livreExemplaireService.save(livreExemplaire);
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
		return livreExemplaire;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public LivreExemplaire update(LivreExemplaire livreExemplaire) {
		try {
			this.livreExemplaireService.update(livreExemplaire);
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
		return livreExemplaire;
	}

}

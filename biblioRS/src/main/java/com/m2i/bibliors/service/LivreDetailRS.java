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

import com.m2i.bibliocommon.bo.LivreDetail;
import com.m2i.bibliocommon.exception.BiblioException;
import com.m2i.bibliocommon.service.ILivreDetailService;
import com.m2i.bibliors.exception.BiblioNotFoundException;

@Service
@Path("/livreDetail")
public class LivreDetailRS {

	@Autowired
	private ILivreDetailService livreDetailService;

	public LivreDetailRS() {
		super();
	}

	public ILivreDetailService getLivreDetailService() {
		return this.livreDetailService;
	}

	public void setLivreDetailService(ILivreDetailService livreDetailService) {
		this.livreDetailService = livreDetailService;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<LivreDetail> findAll() {
		List<LivreDetail> livreDetails;
		try {
			livreDetails = this.livreDetailService.findAll();
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
		return livreDetails;
	}

	@GET
	@Path("{ id }")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public LivreDetail get(@PathParam("id") Integer id) {
		LivreDetail livreDetail;
		try {
			livreDetail = this.livreDetailService.get(id);
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
		return livreDetail;
	}

	@DELETE
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void delete(LivreDetail livreDetail) {
		try {
			this.livreDetailService.delete(livreDetail);
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
			this.livreDetailService.delete(new LivreDetail(id));
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public LivreDetail save(LivreDetail livreDetail) {
		try {
			this.livreDetailService.save(livreDetail);
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
		return livreDetail;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public LivreDetail update(LivreDetail livreDetail) {
		try {
			this.livreDetailService.update(livreDetail);
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
		return livreDetail;
	}

}

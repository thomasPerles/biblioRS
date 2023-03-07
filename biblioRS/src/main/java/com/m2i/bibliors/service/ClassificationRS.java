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

import com.m2i.bibliocommon.bo.Classification;
import com.m2i.bibliocommon.exception.BiblioException;
import com.m2i.bibliocommon.service.IClassificationService;
import com.m2i.bibliors.exception.BiblioNotFoundException;

@Service
@Path("/classification")
public class ClassificationRS {

	@Autowired
	private IClassificationService classificationService;

	public ClassificationRS() {
		super();
	}

	public IClassificationService getClassificationService() {
		return this.classificationService;
	}

	public void setClassificationService(IClassificationService classificationService) {
		this.classificationService = classificationService;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Classification> findAll() {
		List<Classification> classifications;
		try {
			classifications = this.classificationService.findAll();
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
		return classifications;
	}

	@GET
	@Path("{ id }")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Classification get(@PathParam("id") Integer id) {
		Classification classification;
		try {
			classification = this.classificationService.get(id);
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
		return classification;
	}

	@DELETE
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void delete(Classification classification) {
		try {
			this.classificationService.delete(classification);
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
			this.classificationService.delete(new Classification(id));
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Classification save(Classification classification) {
		try {
			this.classificationService.save(classification);
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
		return classification;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Classification update(Classification classification) {
		try {
			this.classificationService.update(classification);
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
		return classification;
	}

}

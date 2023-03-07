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

import com.m2i.bibliocommon.bo.Section;
import com.m2i.bibliocommon.exception.BiblioException;
import com.m2i.bibliocommon.service.ISectionService;
import com.m2i.bibliors.exception.BiblioNotFoundException;

@Service
@Path("/section")
public class SectionRS {

	@Autowired
	private ISectionService sectionService;

	public SectionRS() {
		super();
	}

	public ISectionService getSectionService() {
		return this.sectionService;
	}

	public void setSectionService(ISectionService sectionService) {
		this.sectionService = sectionService;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Section> findAll() {
		List<Section> sections;
		try {
			sections = this.sectionService.findAll();
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
		return sections;
	}

	@GET
	@Path("{ id }")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Section get(@PathParam("id") Integer id) {
		Section section;
		try {
			section = this.sectionService.get(id);
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
		return section;
	}

	@DELETE
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void delete(Section section) {
		try {
			this.sectionService.delete(section);
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
			this.sectionService.delete(new Section(id));
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Section save(Section section) {
		try {
			this.sectionService.save(section);
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
		return section;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Section update(Section section) {
		try {
			this.sectionService.update(section);
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BiblioNotFoundException();
		}
		return section;
	}

}

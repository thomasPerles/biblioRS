package com.m2i.bibliors.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.bibliocommon.bo.Utilisateur;
import com.m2i.bibliocommon.exception.AuthentificationException;
import com.m2i.bibliocommon.service.IUtilisateurService;
import com.m2i.bibliors.exception.WebAuthentificationException;

@Service
@Path("/authentification")
public class AuthentificationRS {

	@Autowired
	private IUtilisateurService utilisateurService;

	public AuthentificationRS() {
		super();
	}

	public IUtilisateurService getUtilisateurService() {
		return utilisateurService;
	}

	public void setUtilisateurService(IUtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Utilisateur save(Utilisateur utilisateur) {
		Utilisateur retour;
		try {
			retour = this.utilisateurService.chercher(utilisateur);
		} catch (AuthentificationException e) {
			e.printStackTrace();
			throw new WebAuthentificationException(e.getMessage());
		}
		return retour;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Utilisateur update(Utilisateur utilisateur) {
		Utilisateur retour;
		try {
			retour = this.utilisateurService.creer(utilisateur);
		} catch (AuthentificationException e) {
			e.printStackTrace();
			throw new WebAuthentificationException(e.getMessage());
		}
		return retour;
	}

}

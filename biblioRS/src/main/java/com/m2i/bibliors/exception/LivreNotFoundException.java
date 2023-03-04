package com.m2i.bibliors.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class LivreNotFoundException extends WebApplicationException {

	private static final long serialVersionUID = 3033757862846279028L;

	public LivreNotFoundException() {
		super(Response.status(Status.NOT_FOUND).type("text/plain").build());
	}

	public LivreNotFoundException(String message) {
		super(message);
	}
}

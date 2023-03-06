package com.m2i.bibliors.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class WebAuthentificationException extends WebApplicationException {

	private static final long serialVersionUID = 720244407297981836L;

	public WebAuthentificationException() {
		super(Response.status(Status.NOT_FOUND).type("text/plain").build());
	}

	public WebAuthentificationException(String message) {
		super(message);
	}
}

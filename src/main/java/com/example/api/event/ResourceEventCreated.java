package com.example.api.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class ResourceEventCreated extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	private HttpServletResponse response;

	private Long code;

	public ResourceEventCreated(Object source, HttpServletResponse response, Long code) {
		super(source);
		this.response = response;
		this.code = code;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}
}

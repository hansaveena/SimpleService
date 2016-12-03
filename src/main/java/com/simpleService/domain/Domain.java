package com.simpleService.domain;

public class Domain {
	private final long id;
	private final String content;

	public Domain(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}

package com.subscriber.domain;

import java.util.UUID;

public class Content {
	private UUID id = UUID.randomUUID();

	private String title;

	private String message;

	private UUID author_id;

	public UUID getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UUID getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(UUID author_id) {
		this.author_id = author_id;
	}

	@Override
	public String toString() {
		return "Content [id=" + id + ", title=" + title + ", message=" + message + ", author_id=" + author_id + "]";
	}

}

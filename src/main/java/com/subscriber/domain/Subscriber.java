package com.subscriber.domain;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("subscriber")
public class Subscriber {
	@PrimaryKey
	private UUID id = UUID.randomUUID();

	@Column("name")
	private String name;

	@Column("email")
	private String email;

	@Column("author_id")
	private UUID author_Id;

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UUID getAuthor_Id() {
		return author_Id;
	}

	public void setAuthor_Id(UUID author_Id) {
		this.author_Id = author_Id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Subscriber [id=" + id + ", name=" + name + ", email=" + email + ", author_Id=" + author_Id + "]";
	}

}

package com.subscriber.domain;

import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("subscription")
public class Subscription {

	private UUID id = UUID.randomUUID();

	@PrimaryKey
	private SubscriptionKey subscriptionKey;
	
	@Column("subscriber_email")
	private String subscriber_email;
	@Column("author_id")
	private UUID author_id;

	public UUID getId() {
		return id;
	}

	public String getSubscriber_email() {
		return subscriber_email;
	}

	public void setSubscriber_email(String subscriber_email) {
		this.subscriber_email = subscriber_email;
	}

	public UUID getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(UUID author_id) {
		this.author_id = author_id;
	}

	@Override
	public String toString() {
		return "Subscription [id=" + id + ", subscriber_email=" + subscriber_email + ", author_id=" + author_id + "]";
	}

}

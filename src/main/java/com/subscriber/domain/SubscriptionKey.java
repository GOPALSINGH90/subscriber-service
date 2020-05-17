package com.subscriber.domain;

import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class SubscriptionKey {

	public SubscriptionKey() {
	}

	@PrimaryKeyColumn(name = "subscriber_email", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String subscriber_email;

	@PrimaryKeyColumn(name = "author_id", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private UUID author_id;

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
}

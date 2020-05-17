package com.subscriber.respository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.subscriber.domain.Subscriber;

@Repository
public interface SubscriberRepository extends CassandraRepository<Subscriber, UUID> {
	@Query("SELECT * FROM subscriber WHERE publisherid = ?0 ALLOW FILTERING")
	public List<Subscriber> findByPublisherId(UUID publisherId);
}

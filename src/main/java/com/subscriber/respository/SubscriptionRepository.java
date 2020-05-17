package com.subscriber.respository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.subscriber.domain.Subscription;

@Repository
public interface SubscriptionRepository extends CassandraRepository<Subscription, UUID> {

	@Query("SELECT * from subscription WHERE author_id = ?0 and subscriber_email= ?1 ALLOW FILTERING")
	public Subscription findBySubscriber_email(UUID author_id, String subscriber_email);
	
	
	@Query("SELECT  subscriber_email from subscription WHERE author_id = ?0  ALLOW FILTERING") 
	public List<Subscription> findByAuthorId(UUID author_id);
}

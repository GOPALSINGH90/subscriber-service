package com.subscriber.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.subscriber.domain.Subscription;

@Service
public interface SubscriptionService {
	public Subscription addSubscription(Subscription subscription);
	public List<Subscription> getSubscription();
	void removeSubscription(UUID id , String subscriber_email);
	
}

package com.subscriber.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.subscriber.domain.Subscriber;

@Service
public interface SubscriberService {
	public Subscriber createSubscriber(Subscriber subscriber);
	public List<Subscriber> getSubscriber();
	public Subscriber updateSubscriber(Subscriber subscriber , UUID id);
	public void deleteSubscriber(UUID id);
	
}

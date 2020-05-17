package com.subscriber.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.subscriber.domain.Content;
import com.subscriber.domain.Subscriber;
import com.subscriber.respository.SubscriberRepository;
import com.subscriber.service.SubscriberService;

@Service
public class SubscriberServiceImpl implements SubscriberService {
	@Autowired
	private SubscriberRepository subscriberRepository;

	@Override
	public Subscriber createSubscriber(Subscriber subscriber) {
		Subscriber createdSubs = subscriberRepository.save(subscriber);
		return createdSubs;
	}

	@Override
	public List<Subscriber> getSubscriber() {

		List<Subscriber> subscribers = subscriberRepository.findAll();

		return subscribers;
	}

	@Override
	public Subscriber updateSubscriber(Subscriber subscriber, UUID id) {
		Subscriber updatedSubscriber;
		Optional<Subscriber> optionalPublisher = subscriberRepository.findById(id);
		if (!optionalPublisher.isEmpty()) {
			Subscriber dbPublisher = optionalPublisher.get();
			dbPublisher.setEmail(subscriber.getEmail());
			dbPublisher.setName(subscriber.getName());
			updatedSubscriber = subscriberRepository.save(dbPublisher);
		} else {
			updatedSubscriber = subscriberRepository.save(subscriber);
		}

		return updatedSubscriber;
	}

	@Override
	public void deleteSubscriber(UUID id) {
		Optional<Subscriber> optionalPublisher = subscriberRepository.findById(id);
		if (!optionalPublisher.isEmpty()) {
			subscriberRepository.deleteById(id);
		}
	}

}

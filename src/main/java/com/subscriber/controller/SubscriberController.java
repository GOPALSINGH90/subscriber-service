package com.subscriber.controller;

import java.util.List;
import java.util.UUID;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.subscriber.domain.Subscriber;
import com.subscriber.serviceImpl.SubscriberServiceImpl;

@RestController
@RequestMapping("api/subscriber")
public class SubscriberController {

	@Autowired
	private SubscriberServiceImpl subscriberServiceImpl;

	@PostMapping("")
	public Subscriber creatSubscriber(@RequestBody Subscriber subscriber) {
		Subscriber createdSubscriber = subscriberServiceImpl.createSubscriber(subscriber);
		return createdSubscriber;
	}

	@GetMapping("")
	public List<Subscriber> getSubscribers() {
		return subscriberServiceImpl.getSubscriber();
	}

	@PutMapping("/{id}")
	public Subscriber updateSubscriber(@RequestBody Subscriber subscriber, @PathVariable UUID id) {
		return subscriberServiceImpl.updateSubscriber(subscriber, id);

	}
	
	@DeleteMapping("/{id}")
	public void deleteSubscriber(@PathVariable UUID id) {
		subscriberServiceImpl.deleteSubscriber(id);

	}
}

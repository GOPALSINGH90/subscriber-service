package com.subscriber.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subscriber.domain.Subscription;
import com.subscriber.serviceImpl.SubscriptionServiceImpl;

@RestController
@RequestMapping("api/subscription")
public class SubscriptionController {

	@Autowired
	private SubscriptionServiceImpl subscriptionServiceImpl;

	@PostMapping()
	public Subscription addSubscription(@RequestBody Subscription subscription) {
		return subscriptionServiceImpl.addSubscription(subscription);
	}

	@GetMapping()
	public List<Subscription> getSubscription() {
		return subscriptionServiceImpl.getSubscription();
	}

	@DeleteMapping("/{id}/{subs_email}")
	public void deleSubscriptions(@PathVariable UUID id, @PathVariable String subs_email) {
		subscriptionServiceImpl.removeSubscription(id, subs_email);
	}
}

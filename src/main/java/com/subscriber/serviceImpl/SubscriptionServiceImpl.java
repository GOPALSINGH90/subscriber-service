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
import com.subscriber.domain.Subscription;
import com.subscriber.respository.SubscriptionRepository;
import com.subscriber.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	private JavaMailSender javaMailSender;

	@Autowired
	public void NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public Subscription addSubscription(Subscription subscription) {
		return subscriptionRepository.save(subscription);
	}

	@Override
	public void removeSubscription(UUID author_id, String subscriber_email) {
		Subscription subscription = subscriptionRepository.findBySubscriber_email(author_id, subscriber_email);
		if (subscription != null) {
			subscriptionRepository.delete(subscription);
		}
	}

	@Override
	public List<Subscription> getSubscription() {
		return subscriptionRepository.findAll();
	}

	@KafkaListener(topics = "nineleaps", groupId = "group_id")
	public void consume(String message) throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		Content content = objectMapper.readValue(message, Content.class);
		List<Subscription> subscription = subscriptionRepository.findByAuthorId(content.getAuthor_id());
		sendNotification(subscription, content);

	}

	private void sendNotification(List<Subscription> subscriptions, Content content) {
		try {
			for (Subscription subscription : subscriptions) {
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setTo(subscription.getSubscriber_email());
				mailMessage.setFrom("gopals020290@gmail.com");
				mailMessage.setSubject("" + content.getTitle());
				mailMessage.setText("Hi , " + content.getMessage());
				javaMailSender.send(mailMessage);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void sendNotification(List<Subscriber> subscribers) {

	}

}

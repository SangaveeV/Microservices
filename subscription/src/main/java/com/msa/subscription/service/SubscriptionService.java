package com.msa.subscription.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.msa.subscription.model.Subscription;
import com.msa.subscription.repository.SubscriptionRepo;

@Service
@Transactional
public class SubscriptionService {

	@Autowired
	public SubscriptionRepo subscriptionRepo;
	
	public List<Subscription> getSubscriptions(){
		List<Subscription> getList = new ArrayList<>();
		getList = subscriptionRepo.findAll();
		return getList;
	}
	

	public Subscription addSubscription(Subscription subscription) {
			
			subscriptionRepo.save(subscription);			
			updateBookCount(subscription.getBookId());
			
		
		return subscription;
	}
	
	public void updateBookCount(String bookId) {
		String uri = "http://localhost:8062/book/updateBookCount/{bookId}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(uri, null, bookId);
	}
	
	public String getBookCount(String bookId) {
		String uri = "http://localhost:8062/book/getbookcount/" + bookId;
		RestTemplate restTemplate = new RestTemplate();
		 //restTemplate.get(uri, null, bookId);
		 return restTemplate.getForObject(uri, String.class);
	}
	
	
	public Subscription updateSubscription(Subscription subscription) {
		
		subscriptionRepo.updateReturnDate(subscription.getSubscriberName(), subscription.getDateReturned(), subscription.getBookId());	
		addBookCount(subscription.getBookId());
		
		return subscriptionRepo.findById(subscription.getSubscriberName()).get();
}
	
	public void addBookCount(String bookId) {
		String uri = "http://localhost:8062/book/addBookCount/{bookId}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(uri, null, bookId);
	}
	
}

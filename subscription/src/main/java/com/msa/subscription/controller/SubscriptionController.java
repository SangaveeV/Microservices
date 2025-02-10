package com.msa.subscription.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msa.subscription.model.Subscription;
import com.msa.subscription.service.SubscriptionService;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

	@Autowired
	public SubscriptionService subscriptionService;
	
	@PostMapping("/addsubscription")
	public ResponseEntity<Subscription> addSubscription(@RequestBody Subscription subscription) {
		System.out.println("book count : " +Integer.parseInt(subscriptionService.getBookCount(subscription.getBookId())));
		
		
		if(Integer.parseInt(subscriptionService.getBookCount(subscription.getBookId())) >0) {
			subscriptionService.addSubscription(subscription);
			return new ResponseEntity<Subscription>(subscription, HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<Subscription>(subscription, HttpStatus.UNPROCESSABLE_ENTITY);
		}	
		
	}
	
	@GetMapping("/getsubscriptions")
	public ResponseEntity<List<Subscription>> getSubscriptions(){
		List<Subscription> subscriptions = new ArrayList<Subscription>();
		subscriptions = subscriptionService.getSubscriptions();
		return new ResponseEntity<List<Subscription>>(subscriptions,HttpStatus.OK);
	}
	
	@PutMapping("/returnsubscription")
	public Subscription returnSubscription(@RequestBody Subscription subscription) {
		
		Subscription sub =subscriptionService.updateSubscription(subscription);
		
		return sub;
	}
	
}

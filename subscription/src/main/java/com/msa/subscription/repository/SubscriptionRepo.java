package com.msa.subscription.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.msa.subscription.model.Subscription;

import jakarta.transaction.Transactional;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription, String> {

	@Transactional
	@Modifying
	@Query("update Subscription b set b.dateReturned = ?2 where b.subscriberName =?1 and b.bookId = ?3")
	void updateReturnDate(String subscriberName, Date dateReturned, String bookId);

}
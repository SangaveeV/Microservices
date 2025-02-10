package com.msa.subscription.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "SUBSCRIPTION")
public class Subscription implements Serializable {

	@Id
	@NotNull
	@JsonProperty("subscriberName")
	private String subscriberName;
	
	@NotNull
	@JsonProperty("bookId")
	private String bookId;
	
	@NotNull
	@PastOrPresent
	@JsonProperty("dateSubscribed")
	@JsonFormat(pattern = "yyyy-mm-dd")	
	private Date dateSubscribed;
	
	@JsonProperty("dateReturned")
	@JsonFormat(pattern = "yyyy-mm-dd")
	@PastOrPresent
	private Date dateReturned;
	
	
	public Subscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subscription(@NotNull String subscriberName, @NotNull String bookId, @NotNull Date dateSubscribed,
			Date dateReturned) {
		super();
		this.subscriberName = subscriberName;
		this.bookId = bookId;
		this.dateSubscribed = dateSubscribed;
		this.dateReturned = dateReturned;
	}
	@Override
	public String toString() {
		return "Subcription [subscriberName=" + subscriberName + ", bookId=" + bookId + ", dateSubscribed="
				+ dateSubscribed + ", dateReturned=" + dateReturned + "]";
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getSubscriberName() {
		return subscriberName;
	}
	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}
	public Date getDateSubscribed() {
		return dateSubscribed;
	}
	public void setDateSubscribed(Date dateSubscribed) {
		this.dateSubscribed = dateSubscribed;
	}
	public Date getDateReturned() {
		return dateReturned;
	}
	public void setDateReturned(Date dateReturned) {
		this.dateReturned = dateReturned;
	}
	
	
	
	
}

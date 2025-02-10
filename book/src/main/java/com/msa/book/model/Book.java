package com.msa.book.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "BOOK")
public class Book implements Serializable  {
	
	@Id
	@NotNull
	@JsonProperty("bookId")
	private String bookId;
	
	@Size(min = 3, max =45, message = "Book name must be between 3 to 45 characters")
	@JsonProperty("name")
	private String name;
	
	@Size(min = 3, max =45, message = "Author name must be between 3 to 45 characters")
	@JsonProperty("author")
	private String author;
	
	@PositiveOrZero
	@JsonProperty("copiesAvailable")
	private int copiesAvailable;
	
	@PositiveOrZero
	@JsonProperty("totalCopies")
	private int totalCopies;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(@NotNull String bookId,
			@Size(min = 3, max = 45, message = "Book name must be between 3 to 45 characters") String name,
			@Size(min = 3, max = 45, message = "Author name must be between 3 to 45 characters") String author,
			@PositiveOrZero int copiesAvailable, @PositiveOrZero int totalCopies) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.author = author;
		this.copiesAvailable = copiesAvailable;
		this.totalCopies = totalCopies;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", author=" + author + ", copiesAvailable="
				+ copiesAvailable + ", totalCopies=" + totalCopies + "]";
	}

	public int getCopiesAvailable() {
		return copiesAvailable;
	}

	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}
	
	
	

}

package com.msa.book.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msa.book.model.Book;
import com.msa.book.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	public BookService bookservice;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> books = new ArrayList<Book>();
		books = bookservice.getBooksList();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@RequestMapping(path ="/addBook",method = RequestMethod.POST ,consumes =  "application/json")
	public Book addBook(@RequestBody @Valid Book book) {
		 bookservice.addBook(book);
		 return book;
		
	}
	
	@PutMapping("/updateBookCount/{bookId}")
	public ResponseEntity<HttpStatus> updateAvailableBook(@PathVariable String bookId){
		bookservice.updateAvailableBook(bookId);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@GetMapping("/getbookcount/{bookId}")
	public int getAvailableBookCount(@PathVariable String bookId) {
		return bookservice.getAvailableCopies(bookId);
	}
	
	@PutMapping("/addBookCount/{bookId}")
	public ResponseEntity<HttpStatus> addAvailableBook(@PathVariable String bookId){
		bookservice.addAvailableBook(bookId);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}

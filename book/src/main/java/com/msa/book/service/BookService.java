package com.msa.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msa.book.model.Book;
import com.msa.book.model.RecordNotFoundException;
import com.msa.book.repo.BookRepository;

@Service
@Transactional
public class BookService {

	@Autowired
	public BookRepository bookRepository;
	
	public List<Book> getBooksList()
	{
		List<Book> books= new ArrayList<Book>();
		books =bookRepository.findAll();
		if(books.isEmpty()) {
			throw new RecordNotFoundException("No Books Available");
		}
		return bookRepository.findAll();
	}
	
	
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Optional<Book> getBook(String bookId) {
		return bookRepository.findById(bookId);
		
	}
	
	public void updateAvailableBook(String bookId) {
		bookRepository.updateAvailableCopies(bookId);
	}
	
	public int getAvailableCopies(String bookId) {
		
		Book book = bookRepository.getById(bookId);
		return book.getCopiesAvailable();
	}
	
	public void addAvailableBook(String bookId) {
		bookRepository.addAvailableCopies(bookId);
	}
	
	
}

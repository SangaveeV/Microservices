package com.msa.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.msa.book.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
	
	@Transactional
	@Modifying
	@Query("update Book b set b.copiesAvailable = b.copiesAvailable - 1 where b.bookId =?1 ")
	void updateAvailableCopies(String bookId);
	
	@Transactional
	@Modifying
	@Query("update Book b set b.copiesAvailable = b.copiesAvailable + 1 where b.bookId =?1 ")
	void addAvailableCopies(String bookId);

}

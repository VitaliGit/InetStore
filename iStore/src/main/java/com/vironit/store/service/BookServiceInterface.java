package com.vironit.store.service;

import java.util.List;
import java.util.Optional;

import com.vironit.store.dto.BookSearchDTO;
import com.vironit.store.entity.book.Book;

public interface BookServiceInterface {
	void add(Book phone) throws Exception ;
	void entireUpdate(Book book) throws Exception;
	void remove(int id) throws Exception;
	void updatePrice(int id, int price) throws Exception ;
	void updateAvailable(int id, boolean available) throws Exception ;
	void updateDiscount(int id, int discount) throws Exception;
	List<Book> getAllBooks() throws Exception;
	
	Optional<Book> searchById(int id) throws Exception;
	List<Book> searchByPrice(int price) throws Exception;
	List<Book> searchByAvailable(boolean available) throws Exception;
	List<Book> searchByDiscount(int discount) throws Exception;
	List<Book> searchByTitle(String title) throws Exception;
	List<Book> searchByAuthor(String author) throws Exception;
	List<Book> searchByAgeGroup(String ageGroup) throws Exception;
	List<Book> searchByGenre(String genre) throws Exception;
	List<Book> searchBySeveralOptions(BookSearchDTO allDto) throws Exception;
	
	
}

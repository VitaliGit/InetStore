package com.vironit.store.dao;

import java.util.List;
import java.util.Optional;

import com.vironit.store.dto.BookSearchDTO;
import com.vironit.store.entity.book.Book;

public interface BookDAO {
	void add(Book phone) throws Exception ;
	void remove(int id) throws Exception;
	void entireUpdate(Book book);
	void updatePrice(int id, int price) throws Exception ;
	void updateAvailable(int id, boolean available) throws Exception ;
	void updateDiscount(int id, int discount) throws Exception;
	List<Book> getAllBooks();
	
	Optional<Book> searchById(int id);
	
	List<Book> searchByPrice(int price);
	List<Book> searchByAvailable(boolean available);
	List<Book> searchByDiscount(int discount);
	List<Book> searchByTitle(String title);
	List<Book> searchByAuthor(String author);
	List<Book> searchByAgeGroup(String ageGroup);
	List<Book> searchByGenre(String genre);
	List<Book> searchBySeveralOptions(BookSearchDTO allDto);
	
	
	

}

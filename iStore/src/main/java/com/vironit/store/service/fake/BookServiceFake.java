package com.vironit.store.service.fake;

import java.util.List;
import java.util.Optional;

import com.vironit.store.dao.fake.BookDAOFake;
import com.vironit.store.dto.BookSearchDTO;
import com.vironit.store.entity.book.Book;
import com.vironit.store.exception.NoUniqueIdException;
import com.vironit.store.exception.SearchException;
import com.vironit.store.service.BookServiceInterface;

public class BookServiceFake implements BookServiceInterface {
	
	BookDAOFake bookAccess;
	
	public BookServiceFake(){
		bookAccess = new BookDAOFake();
	}
	@Override
	public void add(Book book) throws NoUniqueIdException {
		bookAccess.add(book);
	}
	@Override
	public void remove(int id) throws SearchException {
		bookAccess.remove(id);
	}
	@Override
	public void updatePrice(int id, int price) throws SearchException {
		bookAccess.updatePrice(id, price);
	}
	@Override
	public void updateAvailable(int id, boolean available) throws SearchException {
		bookAccess.updateAvailable(id, available);
	}
	@Override
	public void updateDiscount(int id, int discount) throws SearchException {
		bookAccess.updateDiscount(id, discount) ;
	}

	@Override
	public Optional<Book> searchById(int id) {
		return bookAccess.searchById(id) ;
	}

	@Override
	public List<Book> searchByPrice(int price) {
		return bookAccess.searchByPrice(price);
	}

	@Override
	public List<Book> searchByAvailable(boolean available) {
		return bookAccess.searchByAvailable(available);
	}

	@Override
	public List<Book> searchByDiscount(int discount) {
		return bookAccess.searchByDiscount(discount);
	}

	@Override
	public List<Book> searchByTitle(String title) {
		return bookAccess.searchByTitle(title);
	}

	@Override
	public List<Book> searchByAuthor(String author) {
		return bookAccess.searchByAuthor(author);
	}

	@Override
	public List<Book> searchByAgeGroup(String ageGroup){
		return bookAccess.searchByAgeGroup(ageGroup);
	}

	@Override
	public List<Book> searchByGenre(String genre) {
		return bookAccess.searchByGenre(genre);
	}
	@Override
	public List<Book> getAllBooks() {
		return bookAccess.getAllBooks();
	}
	@Override
	public void entireUpdate(Book book) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Book> searchBySeveralOptions(BookSearchDTO allDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

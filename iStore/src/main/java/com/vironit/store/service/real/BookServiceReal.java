package com.vironit.store.service.real;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vironit.store.dao.BookDAO;
import com.vironit.store.dao.real.BookDAOReal;
import com.vironit.store.dto.BookSearchDTO;
import com.vironit.store.entity.book.Book;
import com.vironit.store.service.BookServiceInterface;

@Service
public class BookServiceReal implements BookServiceInterface {
		
		@Autowired
		private BookDAO bookAccess;
		
		public BookServiceReal() {
			bookAccess = new BookDAOReal();
		}
		@Override
		@Transactional
		public	List<Book>  getAllBooks() throws Exception {
			return bookAccess.getAllBooks();
		}
		@Override
		@Transactional
		public void add(Book book) throws Exception  {
			bookAccess.add(book);
		}
		@Override
		public void entireUpdate(Book book) throws Exception {
			bookAccess.entireUpdate(book);	
		}
		@Override
		@Transactional
		public void remove(int id) throws Exception {
			bookAccess.remove(id);
		}
		@Override
		@Transactional
		public void updatePrice(int id, int price) throws Exception {
			bookAccess.updatePrice(id, price);
		}
		@Override
		@Transactional
		public void updateAvailable(int id, boolean available) throws Exception {
			bookAccess.updateAvailable(id, available);
		}
		@Override
		@Transactional
		public void updateDiscount(int id, int discount) throws Exception {
			bookAccess.updateDiscount(id, discount) ;
		}
		@Override
		@Transactional
		public Optional<Book> searchById(int id) throws Exception {
			return bookAccess.searchById(id) ;
		}

		@Override
		@Transactional
		public List<Book> searchByPrice(int price) throws Exception {
			return bookAccess.searchByPrice(price);
		}

		@Override
		@Transactional
		public List<Book> searchByAvailable(boolean available) throws Exception {
			return bookAccess.searchByAvailable(available);
		}

		@Override
		@Transactional
		public List<Book> searchByDiscount(int discount) throws Exception {
			return bookAccess.searchByDiscount(discount);
		}
		@Override
		@Transactional
		public List<Book> searchByAgeGroup(String ageGroup) throws Exception {
			return bookAccess.searchByAgeGroup(ageGroup);
		}
		@Override
		@Transactional
		public List<Book> searchByAuthor(String author) throws Exception {
			return bookAccess.searchByAuthor(author);
		}
		@Override
		@Transactional
		public List<Book> searchByGenre(String genre) throws Exception {
			return bookAccess.searchByGenre(genre);
		}
		@Override
		@Transactional
		public List<Book> searchByTitle(String title) throws Exception {
			return bookAccess.searchByTitle(title);
		}
		
		@Override
		@Transactional
		public List<Book> searchBySeveralOptions(BookSearchDTO allDto) throws Exception{
			return bookAccess.searchBySeveralOptions(allDto);
		}
		
}
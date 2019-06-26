package com.vironit.store.dao.fake;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.vironit.store.dao.BookDAO;
import com.vironit.store.dto.BookSearchDTO;
import com.vironit.store.entity.book.Book;
import com.vironit.store.entity.builder.BookBuilder;
import com.vironit.store.exception.NoUniqueIdException;
import com.vironit.store.exception.SearchException;

public class BookDAOFake implements BookDAO {
	private static BookDAOFake bookFake= new BookDAOFake();
	private static List<Book> bookList = new ArrayList<>();
	
	public static void main(String[] args) throws NoUniqueIdException {
		BookBuilder bb= new  BookBuilder();
		Book dumas = bb.withID(1).withPrice(20).withAgeGroup("All groups").withAuthor("Alexandre Dumas").withAvailable(true).withGenre("Roman").withDiscount(85)
				.withTitle("Le comte de Monté-Cristo").build();
		Book hugo = bb.withID(2).withPrice(18).withAgeGroup("All groups").withAuthor("Victor Hugo").withAvailable(false).withGenre("Roman").withDiscount(85)
				.withTitle("Notre-Dame de Paris").build();
		bookFake.add(dumas);bookFake.add(hugo);
		bookFake.getAllBooks().forEach(System.out::println);
	}
	
	@Override
	public List<Book> getAllBooks(){
		return bookList;
	}
	@Override
	public void add(Book book) throws NoUniqueIdException {
		if (bookList.stream().anyMatch(x -> x.getId() == book.getId())) {
			throw new NoUniqueIdException();
		}
		bookList.add(book);
	}

	@Override
	public void remove(int id) throws SearchException{
		Optional<Book> book = searchById(id);
		bookList.remove(book.orElseThrow(SearchException::new)); 
	}
	
	@Override
	public Optional<Book> searchById(int id) {
		return bookList.stream().filter(book->book.getId()==id).findAny();
	}

	@Override
	public List<Book> searchByPrice(int price){
		return bookList.stream().filter(book->price==book.getPrice()).collect(Collectors.toList());
	}

	@Override
	public List<Book> searchByAvailable(boolean available){
		return bookList.stream().filter(book->available==book.isAvailable()).collect(Collectors.toList());
	}

	@Override
	public List<Book> searchByDiscount(int discount) {
		return bookList.stream().filter(book->discount==book.getDiscount()).collect(Collectors.toList());
	}
	
	@Override
	public List<Book> searchByTitle(String title) {
		return bookList.stream().filter(book->title==book.getTitle()).collect(Collectors.toList());
	}

	@Override
	public List<Book> searchByAuthor(String author) {
		return bookList.stream().filter(book->author==book.getAuthor()).collect(Collectors.toList());
	}

	@Override
	public List<Book> searchByAgeGroup(String ageGroup){
		return bookList.stream().filter(book->ageGroup==book.getAgeGroup()).collect(Collectors.toList());
}

	@Override
	public List<Book> searchByGenre(String genre) {
		return bookList.stream().filter(book->genre==book.getGenre()).collect(Collectors.toList());
}
	@Override
	public void updatePrice(int id, int price) throws SearchException {
		Optional<Book> book = searchById(id);
		book.orElseThrow(SearchException::new).setPrice(price);
	}

	@Override
	public void updateAvailable(int id, boolean available)  throws SearchException {
		Optional<Book> book = searchById(id);
		book.orElseThrow(SearchException::new).setAvailable(available);
	}

	@Override
	public void updateDiscount(int id, int discount)  throws SearchException {
		Optional<Book> book = searchById(id);
		book.orElseThrow(SearchException::new).setDiscount(discount);
	}

	@Override
	public void entireUpdate(Book book) {
		
	}

	@Override
	public List<Book> searchBySeveralOptions(BookSearchDTO allDto) {
		return null;
	}
}
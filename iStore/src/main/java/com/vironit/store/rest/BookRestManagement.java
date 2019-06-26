package com.vironit.store.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vironit.store.entity.book.Book;
import com.vironit.store.exception.rest.GoodNotFoundException;
import com.vironit.store.service.BookServiceInterface;

//@CrossOrigin("*")
@RestController
@RequestMapping("/rest_api")
public class BookRestManagement {

@Autowired
private BookServiceInterface bookService;


@GetMapping("/book/{id}")
	public Book foundById(@PathVariable int id) throws Exception {
	Book book =bookService.searchById(id).orElseThrow(()->new GoodNotFoundException("The terrible parameter has not been found - " + id)); 
	System.out.println("My Book"+book);
	return book;
}

@GetMapping("/book")
	public List<Book> foundAll() throws Exception{
	return bookService.getAllBooks();
}

@GetMapping("/books")
	public ResponseEntity<List<Book>> all() throws Exception{
	List<Book> list=bookService.getAllBooks();
	return ResponseEntity.ok().body(list);
}

@PostMapping("/book")
	public Book addItem(@RequestBody Book theBook) throws Exception {
	bookService.add(theBook);
	return theBook;
	
}
//@PutMapping(value = "/book/{id}")
//	public Book updateItem(@PathVariable int id, @RequestBody Book theBook) throws Exception {
//	bookService.entireUpdate(theBook);
//	return theBook;
//}
@PutMapping("/book/{id}")
public ResponseEntity<?> updateItem(@PathVariable int id, @RequestBody Book theBook) throws Exception {
	bookService.entireUpdate(theBook);
	return ResponseEntity.ok().body("Book has been updated");
}

@DeleteMapping("/book/{id}")
	public String removeById(@PathVariable int id) throws Exception {
	Book book =bookService.searchById(id).orElseThrow(()->new GoodNotFoundException("The terrible parameter has not been found - " + id));
	System.out.println(book);
	bookService.remove(id);
	return "Eliminated item #"+id;
}
}
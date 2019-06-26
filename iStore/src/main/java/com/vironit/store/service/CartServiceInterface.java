package com.vironit.store.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.vironit.store.entity.Status;
import com.vironit.store.entity.book.Book;
import com.vironit.store.entity.cart.Cart;
import com.vironit.store.entity.laptop.Laptop;
import com.vironit.store.entity.person.User;
import com.vironit.store.entity.phone.Phone;
import com.vironit.store.exception.SearchException;

public interface CartServiceInterface {
	void add(Cart cart) throws Exception;
	void remove(int id)throws Exception;
	void updateTotalPrice(int id, int totalPrice)throws Exception;
	Optional<Cart> searchById(int id) throws SearchException;
	List<Cart> searchByUpdatedDate(LocalDateTime updatedDate);
	List<Cart> searchByCreatedDate(LocalDateTime createdDate);
	
	Optional<Cart> searchByUserId(int userId);
	Optional<Cart> searchByGoodId(int goodId);
	List<Cart> searchByOrderDate(LocalDateTime orderDate);
	List<Cart> searchByTotalPrice(int totalPrice);
	Optional<Cart> searchByIdSession (int idSession);
	List<Cart> getAllCarts();
	void addLaptop(Cart cart, Laptop idLaptop, User userName) throws Exception;
	void addBook(Cart cart, Book idBook, User userName) throws Exception;
	void addPhone(Cart cart, Phone idPhone, User userName) throws Exception;
	List<Cart> foundPhoneForUser(User userName) throws Exception;
	List<Cart> foundBookForUser(User userName) throws Exception;
	List<Cart> foundLaptopForUser(User userName) throws Exception;

	void removeBook(int a) throws Exception;
	void updateStatus(int id, Status status) throws Exception;
	


}

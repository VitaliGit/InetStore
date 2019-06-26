package com.vironit.store.dao;

import java.util.List;
import java.util.Optional;

import com.vironit.store.entity.Status;
import com.vironit.store.entity.book.Book;
import com.vironit.store.entity.cart.Cart;
import com.vironit.store.entity.laptop.Laptop;
import com.vironit.store.entity.person.User;
import com.vironit.store.entity.phone.Phone;

public interface CartDAO {
	
	void add(Cart cart) throws Exception;
	void remove(int id)throws Exception;
	void updateTotalPrice(int id, int totalPrice)throws Exception;
	Optional<Cart> searchById(int id)throws Exception;
	List<Cart> getAllCarts()throws Exception;
	void addPhone(Cart cart, Phone idPhone, User userName) throws Exception;
	void addLaptop(Cart cart, Laptop idLaptop, User userName) throws Exception;
	void addBook(Cart cart, Book idBook, User userName) throws Exception;
	List<Cart> foundForUser(User userName)throws Exception;
	List<Cart> foundPhoneForUser(User userName);
	List<Cart> foundBookForUser(User userName);
	List<Cart> foundLaptopForUser(User userName);
	void removeBook(Book book, User username) throws Exception;
	public void removeBook(int a) throws Exception;
	void updateStatus(int id, Status status) throws Exception;

}

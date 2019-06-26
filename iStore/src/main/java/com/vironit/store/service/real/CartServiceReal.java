package com.vironit.store.service.real;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vironit.store.dao.real.CartDAOReal;
import com.vironit.store.entity.Status;
import com.vironit.store.entity.book.Book;
import com.vironit.store.entity.cart.Cart;
import com.vironit.store.entity.laptop.Laptop;
import com.vironit.store.entity.person.User;
import com.vironit.store.entity.phone.Phone;
import com.vironit.store.exception.SearchException;
import com.vironit.store.service.CartServiceInterface;

@Service
public class CartServiceReal implements  CartServiceInterface{

	@Autowired
	private CartDAOReal cartAccess;
	
	@Override
	@Transactional
	public void add(Cart cart) throws Exception {
		
	}

	@Override
	public void remove(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	@Transactional
	public void removeBook(int a) throws Exception{
		cartAccess.removeBook(a);	
	}


	@Override
	public Optional<Cart> searchById(int id) throws SearchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> searchByUpdatedDate(LocalDateTime updatedDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> searchByCreatedDate(LocalDateTime createdDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cart> searchByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cart> searchByGoodId(int goodId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> searchByOrderDate(LocalDateTime orderDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> searchByTotalPrice(int totalPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cart> searchByIdSession(int idSession) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> getAllCarts() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	@Transactional
	public void updateTotalPrice(int id, int totalPrice) throws Exception {
		cartAccess.updateTotalPrice(id, totalPrice);
	}
	@Override
	@Transactional
	public void updateStatus(int id, Status status) throws Exception {
		cartAccess.updateStatus(id, status);
	}
	@Override
	@Transactional
	public void addPhone(Cart cart, Phone idPhone, User userName) throws Exception {
		cartAccess.addPhone( cart, idPhone, userName);
	}
	@Override
	@Transactional
	public void addLaptop(Cart cart, Laptop idLaptop, User userName) throws Exception {
		cartAccess.addLaptop( cart, idLaptop, userName);
	}
	@Override
	@Transactional
	public void addBook(Cart cart, Book idBook, User userName) throws Exception {
		cartAccess.addBook( cart, idBook, userName);
	}

	@Override
	@Transactional
	public List<Cart> foundPhoneForUser(User userName) throws Exception {
		return cartAccess.foundPhoneForUser(userName);
	}
	@Override
	@Transactional
	public List<Cart> foundBookForUser(User userName) throws Exception {
		return cartAccess.foundBookForUser(userName);
	}
	@Override
	@Transactional
	public List<Cart> foundLaptopForUser(User userName) throws Exception {
		return cartAccess.foundLaptopForUser(userName);
	}
}

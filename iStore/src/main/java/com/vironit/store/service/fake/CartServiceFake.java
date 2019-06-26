package com.vironit.store.service.fake;
/*
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.vironit.store.dao.fake.CartDAOFake;
import com.vironit.store.entity.cart.Cart;
import com.vironit.store.exception.NoUniqueIdException;
import com.vironit.store.exception.SearchException;
import com.vironit.store.service.CartServiceInterface;

public class CartServiceFake implements CartServiceInterface{
	CartDAOFake cartAccess;
	public CartServiceFake(){
		cartAccess = new CartDAOFake();
	}
	@Override
	public void add(Cart cart) throws NoUniqueIdException  {
		cartAccess.add(cart);
	}

	@Override
	public void remove(int id) throws SearchException   {
		cartAccess.remove(id);
	}

	@Override
	public void updateTotalPrice(int id, int totalPrice) throws SearchException {
		cartAccess.updateTotalPrice(id, totalPrice);
	}

	@Override
	public Optional<Cart> searchById(int id) {
		return cartAccess.searchById(id);
	}

	@Override
	public List<Cart> searchByUpdatedDate(LocalDateTime updatedDate){
		return cartAccess.searchByUpdatedDate(updatedDate);
	}

	@Override
	public List<Cart> searchByCreatedDate(LocalDateTime createdDate) {
		return cartAccess.searchByCreatedDate(createdDate);
	}

	@Override
	public Optional<Cart> searchByUserId(int userId){
		return cartAccess.searchByUserId(userId);
	}

	@Override
	public Optional<Cart> searchByGoodId(int goodId) {
		return cartAccess.searchByGoodId(goodId);
	}

	@Override
	public List<Cart> searchByOrderDate(LocalDateTime orderDate){
		return cartAccess.searchByOrderDate(orderDate);
	}

	@Override
	public List<Cart> searchByTotalPrice(int totalPrice){
		return cartAccess.searchByTotalPrice(totalPrice);
	}

	@Override
	public Optional<Cart> searchByIdSession(int idSession){
		return cartAccess.searchByIdSession(idSession);
	}

	@Override
	public List<Cart> getAllCarts() {
		return cartAccess.getAllCarts();
	}
}
*/
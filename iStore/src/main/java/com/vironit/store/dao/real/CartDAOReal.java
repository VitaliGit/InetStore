package com.vironit.store.dao.real;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vironit.store.dao.CartDAO;
import com.vironit.store.entity.Status;
import com.vironit.store.entity.book.Book;
import com.vironit.store.entity.cart.Cart;
import com.vironit.store.entity.laptop.Laptop;
import com.vironit.store.entity.person.User;
import com.vironit.store.entity.phone.Phone;
@Repository
public class CartDAOReal implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private LocalDateTime time = LocalDateTime.now();
	
	@Override
	public void updateStatus(int id, Status status) {
		Session currentSession=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("UPDATE Cart SET status=:status WHERE id =:id");
		theQuery.setParameter("status", status);
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();
		
	}
	@Override
	public void removeBook(int a) throws Exception {
		Session currentSession=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = currentSession.createQuery("DELETE from t_cart WHERE id="+a);
        query.executeUpdate();
	}

	@Override
	public void updateTotalPrice(int id, int totalPrice) throws Exception {
		Session currentSession=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("UPDATE Cart SET totalPrice=:totalPrice WHERE id =:id");
		theQuery.setParameter("totalPrice", totalPrice);
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();
	}



	@Override
	public List<Cart> getAllCarts() {
		return null;
	}

	@Override
	public void add(Cart cart) throws Exception {
		
	}
	@Override
	public List<Cart> foundPhoneForUser(User userName) {
		Session currentSession=sessionFactory.getCurrentSession();
		//Query<Cart> theQuery = currentSession.createQuery("SELECT (t1.user_name, t1.total_price, t1.id, t2.phone_id) FROM t_order AS t2  JOIN t_cart t1 ON t2.cart_id = t1.id WHERE t1.user_name = 'Spring'", Cart.class);
		Query<Cart> theQueryPhone =currentSession.createQuery("FROM Cart cart JOIN FETCH cart.idPhone   WHERE cart.userName =:userName", Cart.class);
		theQueryPhone .setParameter("userName", userName);	
		List<Cart> list = theQueryPhone .getResultList();
		return list;
	}
	
	@Override
	public List<Cart> foundBookForUser(User userName) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Cart> theQueryBook =currentSession.createQuery("FROM Cart cart JOIN FETCH cart.idBook   WHERE cart.userName =:userName", Cart.class);
		theQueryBook .setParameter("userName", userName);	
		List<Cart> list = theQueryBook .getResultList();
		return list;
	}

	@Override
	public List<Cart> foundLaptopForUser(User userName) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Cart> theQueryLaptop=currentSession.createQuery("FROM Cart cart JOIN FETCH cart.idLaptop  WHERE cart.userName =:userName", Cart.class);
		theQueryLaptop.setParameter("userName", userName);
		List<Cart> list = theQueryLaptop.getResultList();
		return list;
	}
	@Override
	public void addPhone(Cart cart, Phone idPhone, User userName) throws Exception {
		Session currentSession=sessionFactory.getCurrentSession();
		cart.setOrderDate(time);
		cart.setUpdatedDate(time);
		cart.setCreatedDate(time);
		cart.setUserName(userName);
		cart.setStatus(Status.UNCONFIRMED);
		cart.setTotalPrice(idPhone.getPrice()-idPhone.getDiscount());
		cart.addPhone(idPhone);
		currentSession.save(cart);
		
	}
	@Override
	public void addBook(Cart cart, Book idBook, User userName) throws Exception {
		Session currentSession=sessionFactory.getCurrentSession();
		cart.setOrderDate(time);
		cart.setUpdatedDate(time);
		cart.setCreatedDate(time);
		cart.setUserName(userName);
		cart.setStatus(Status.UNCONFIRMED);
		cart.setTotalPrice(idBook.getPrice()-idBook.getDiscount());
		cart.addBook(idBook);
		currentSession.save(cart);
		
	}
	@Override
	public void addLaptop(Cart cart, Laptop idLaptop, User userName) throws Exception {
		Session currentSession=sessionFactory.getCurrentSession();
		cart.setOrderDate(time);
		cart.setUpdatedDate(time);
		cart.setCreatedDate(time);
		cart.setUserName(userName);
		cart.setStatus(Status.UNCONFIRMED);
		cart.setTotalPrice(idLaptop.getPrice()-idLaptop.getDiscount());
		cart.addLaptop(idLaptop);
		currentSession.save(cart);
		
	}
	@Override
	public Optional<Cart> searchById(int id) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Cart> theQuery = currentSession.createQuery("FROM Cart WHERE id=:id", Cart.class);
		theQuery.setParameter("id", id);
		Optional<Cart> opt = theQuery.getResultList().stream().filter(cart->cart.getId()==id).findAny();
		return opt;
	}

	@Override
	public List<Cart> foundForUser(User userName) throws Exception {
		return null;
	}

	@Override
	public void remove(int id) throws Exception {
		
	}

	@Override
	public void removeBook(Book book, User username) throws Exception {
		
	}
}

package com.vironit.store.dao.real;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vironit.store.dao.BookDAO;
import com.vironit.store.dto.BookSearchDTO;
import com.vironit.store.entity.book.Book;
import com.vironit.store.exception.SearchException;

@Repository
public class BookDAOReal implements BookDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void add(Book book) {
		Session currentSession=sessionFactory.getCurrentSession();
		currentSession.save(book);
	}
	
	@Override
	@Transactional
	public void entireUpdate(Book book) {
		Session currentSession=sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(book);
		currentSession.flush();
	}

	@Override
	@Transactional
	public void remove(int id){
		Session currentSession=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("DELETE FROM Book b WHERE b.id =:id");
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();	
	}

	@Override
	@Transactional
	public void updatePrice(int id, int price) throws SearchException{
		Session currentSession=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("UPDATE Book SET price=:price WHERE id =:id");
		
		theQuery.setParameter("price", price);
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();	
	}

	@Override
	@Transactional
	public void updateAvailable(int id, boolean available) throws SearchException{
		Session currentSession=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("UPDATE Book SET available=:available WHERE id =:id");
		
		theQuery.setParameter("available", available);
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();
	}

	@Override
	@Transactional
	public void updateDiscount(int id, int discount) throws SearchException{
		Session currentSession=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("UPDATE Book SET discount=:discount WHERE id =:id");
		
		theQuery.setParameter("discount", discount);
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();
	}

	@Override
	@Transactional
	public Optional<Book> searchById(int id){
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Book> theQuery = currentSession.createQuery("FROM Book WHERE id=:id", Book.class);
		theQuery.setParameter("id", id);
		Optional<Book> opt = theQuery.getResultList().stream().filter(book->book.getId()==id).findAny();
		return opt;
	}

	@Override
	@Transactional
	public List<Book> searchByPrice(int price) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Book> theQuery = currentSession.createQuery("FROM Book b WHERE b.price <=:price", Book.class);
		theQuery.setParameter("price", price);
		List<Book> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Book> searchByAvailable(boolean available) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Book> theQuery = currentSession.createQuery("FROM Book b WHERE b.available =:available", Book.class);
		theQuery.setParameter("available", available);
		List<Book> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Book> searchByDiscount(int discount) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Book> theQuery = currentSession.createQuery("FROM Book b WHERE b.discount >=:discount", Book.class);
		theQuery.setParameter("discount", discount);
		List<Book> list = theQuery.getResultList();
		return list;
	}
	@Override
	@Transactional
	public List<Book> searchByAgeGroup(String ageGroup) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Book> theQuery = currentSession.createQuery("FROM Book b WHERE b.ageGroup =:ageGroup", Book.class);
		theQuery.setParameter("ageGroup", ageGroup);
		List<Book> list = theQuery.getResultList();
		return list;
	}
	@Override
	@Transactional
	public List<Book> searchByAuthor(String author) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Book> theQuery = currentSession.createQuery("FROM Book b WHERE b.author =:author", Book.class);
		theQuery.setParameter("author", author);
		List<Book> list = theQuery.getResultList();
		return list;
	}
	@Override
	@Transactional
	public List<Book> searchByGenre(String genre) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Book> theQuery = currentSession.createQuery("FROM Book b WHERE b.genre =:genre", Book.class);
		theQuery.setParameter("genre", genre);
		List<Book> list = theQuery.getResultList();
		return list;
	}
	@Override
	@Transactional
	public List<Book> searchByTitle(String title) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Book> theQuery = currentSession.createQuery("FROM Book b WHERE b.title =:title", Book.class);
		theQuery.setParameter("title", title);
		List<Book> list = theQuery.getResultList();
		return list;
	}
	@Override
	@Transactional
	public List<Book> getAllBooks() {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Book> theQuery = currentSession.createQuery("FROM Book ORDER BY id ASC", Book.class);
		List<Book> list = theQuery.getResultList();
		return list;
	}
	@Override
	@Transactional
	public List<Book> searchBySeveralOptions(BookSearchDTO allDto){
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Book> theQuery = currentSession.createQuery("FROM Book WHERE ageGroup=:ageGroup AND author=:author AND genre=:genre AND title=:title AND available =:available AND discount >=:discount AND price <=:price",  Book.class);
		theQuery.setParameter("ageGroup", allDto.getAgeGroup());
		theQuery.setParameter("author", allDto.getAuthor());
		theQuery.setParameter("genre", allDto.getGenre());
		theQuery.setParameter("title", allDto.getTitle());
		theQuery.setParameter("available", allDto.isAvailable());
		theQuery.setParameter("discount", allDto.getDiscount());
		theQuery.setParameter("price", allDto.getPrice());

		List<Book> list = theQuery.getResultList();
		return list;
	}
}

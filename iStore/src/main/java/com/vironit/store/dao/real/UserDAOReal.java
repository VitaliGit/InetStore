package com.vironit.store.dao.real;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vironit.store.dao.UserDAO;
import com.vironit.store.entity.person.User;
import com.vironit.store.exception.rest.GoodNotFoundException;
@Repository
public class UserDAOReal implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private LocalDateTime time = LocalDateTime.now();
	
	@Override
	public void add(User user) throws Exception {
		Session currentSession=sessionFactory.getCurrentSession();
		user.setEnabled((short)1);
		user.setCharacter("Pretty normal");
		user.setCreatedDate(time);
		user.setUpdatedDate(time);
		currentSession.save(user);
	}

	@Override
	public void remove(String userName) throws Exception {
		Session currentSession=sessionFactory.getCurrentSession();
		
		User user = searchByUserName( userName).orElseThrow(()->new GoodNotFoundException("The terrible parameter has not been found - "));
		currentSession.delete(user);

	}



	@Override
	public List<User> getAllUsers() throws Exception {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<User> theQuery = currentSession.createQuery("FROM User ORDER BY id ASC", User.class);
		List<User> list = theQuery.getResultList();
		return list;
	}

	@Override
	public Optional<User> searchByUserName(String userName) throws Exception {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<User> theQuery = currentSession.createQuery("FROM User WHERE userName=:userName", User.class);
		theQuery.setParameter("userName", userName);
		Optional<User> opt = theQuery.getResultList().stream().filter(user->user.getUserName().equals(userName)).findAny();
		return opt;
	}

	@Override
	public List<User> searchByCharacter(String character) throws Exception {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<User> theQuery = currentSession.createQuery("FROM User u WHERE u.character =:character", User.class);
		theQuery.setParameter("character", character);
		List<User> list = theQuery.getResultList();
		return list;
	}

	@Override
	public List<User> searchByPhoneNumber(String phoneNumber) throws Exception {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<User> theQuery = currentSession.createQuery("FROM User u WHERE u.phoneNumber =:phoneNumber", User.class);
		theQuery.setParameter("phoneNumber", phoneNumber);
		List<User> list = theQuery.getResultList();
		return list;
	}

	@Override
	public void updatePassword(String userName, String password) {
		Session currentSession=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("UPDATE User SET password=:password WHERE userName =:userName");
		theQuery.setParameter("userName", userName);
		theQuery.setParameter("password", password);
		theQuery.executeUpdate();
		
	}
	@Override
	public void updateCharacter(String userName, String character) throws Exception {
		Session currentSession=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("UPDATE User SET character=:character WHERE userName =:userName");
		theQuery.setParameter("userName", userName);
		theQuery.setParameter("character", character);
		theQuery.executeUpdate();
	}

	@Override
	public void updatePhoneNumber(String userName, String phoneNumber) throws Exception {
		Session currentSession=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("UPDATE User SET phoneNumber=:phoneNumber WHERE userName =:userName");
		theQuery.setParameter("userName", userName);
		theQuery.setParameter("phoneNumber", phoneNumber);
		theQuery.executeUpdate();
		
	}

	@Override
	public void updateUpdatedDate(String userName, LocalDateTime updatedDate) throws Exception {
		Session currentSession=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("UPDATE User SET updatedDate=:updatedDate WHERE userName =:userName");
		theQuery.setParameter("userName", userName);
		theQuery.setParameter("updatedDate", updatedDate);
		theQuery.executeUpdate();
	}

	@Override
	public void updateEnabled(String userName, short enabled) throws Exception {
		Session currentSession=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("UPDATE User SET enabled=:enabled WHERE userName =:userName");
		theQuery.setParameter("userName", userName);
		theQuery.setParameter("enabled", enabled);
		theQuery.executeUpdate();
	}

	@Override
	public void updateConnectionNumber(String userName, int connectionNumber) throws Exception {
		Session currentSession=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("UPDATE User SET connectionNumber=:connectionNumber WHERE userName =:userName");
		theQuery.setParameter("userName", userName);
		theQuery.setParameter("connectionNumber", connectionNumber);
		theQuery.executeUpdate();
	}

	@Override
	public void updateUserName(String userName, String reName) throws Exception {
		User user = searchByUserName(userName).orElseThrow(()->new GoodNotFoundException("The terrible parameter has not been found - "));
		user.setUserName(reName);
		
	}
}

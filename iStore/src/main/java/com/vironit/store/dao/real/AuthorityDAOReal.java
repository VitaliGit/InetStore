package com.vironit.store.dao.real;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vironit.store.dao.AuthorityDAO;
import com.vironit.store.entity.person.Authority;
import com.vironit.store.entity.person.User;

@Repository
public class AuthorityDAOReal implements AuthorityDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Authority> getAllAuthorities() {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Authority> theQuery = currentSession.createQuery("FROM Authority ORDER BY id ASC", Authority.class);
		List<Authority> list = theQuery.getResultList();
		return list;
	}

	@Override
	public Optional<Authority> searchByUserName(User userName) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Authority> theQuery = currentSession.createQuery("FROM Authority WHERE userName=:userName", Authority.class);
		theQuery.setParameter("userName", userName);
		Optional<Authority> opt = theQuery.getResultList().stream().filter(authority->authority.getUserName().equals(userName)).findAny();
		return opt;
	}
	@Override
	public Optional<Authority> searchById(int id) throws Exception {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Authority> theQuery = currentSession.createQuery("FROM Authority WHERE id=:id", Authority.class);
		theQuery.setParameter("id", id);
		Optional<Authority> opt = theQuery.getResultList().stream().filter(authority->authority.getId()==id).findAny();
		return opt;
	}
	@Override
	public List<Authority> searchByRole(String authority) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Authority> theQuery = currentSession.createQuery("FROM Authority WHERE authority=:authority ORDER BY id ASC", Authority.class);
		theQuery.setParameter("authority", authority);
		List<Authority> list = theQuery.getResultList();
		return list;
	}

	@Override
	public void add(User userName) throws Exception {
		Session currentSession=sessionFactory.getCurrentSession();
		Authority authority = new Authority();
		authority.setUserName(userName);
		authority.setAuthority("ROLE_REGULAR");
		currentSession.save(authority);

	}

	@Override
	public void update(int id, String authority) {
		Session currentSession=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("UPDATE Authority SET authority=:authority WHERE id =:id");
		theQuery.setParameter("id", id);
		theQuery.setParameter("authority", authority);
		theQuery.executeUpdate();
		
	}

}

package com.vironit.store.dao.fake;

import java.util.List;
import java.util.Optional;

import com.vironit.store.dao.AuthorityDAO;
import com.vironit.store.entity.person.Authority;
import com.vironit.store.entity.person.User;

public class AuthorityDAOFake implements AuthorityDAO {


	@Override
	public List<Authority> getAllAuthorities() {
		return null;
	}

	@Override
	public void update(int id, String authority) {
		
	}

	@Override
	public Optional<Authority> searchByUserName(User userName) {
		return null;
	}

	@Override
	public void add(User userName) throws Exception {

	}

	@Override
	public List<Authority> searchByRole(String authority) {
		return null;
	}

	@Override
	public Optional<Authority> searchById(int id) throws Exception {
		return null;
	}


	
}
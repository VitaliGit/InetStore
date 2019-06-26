package com.vironit.store.service.fake;

import java.util.List;
import java.util.Optional;

import com.vironit.store.dao.fake.AuthorityDAOFake;
import com.vironit.store.entity.person.Authority;
import com.vironit.store.entity.person.User;
import com.vironit.store.service.AuthorityServiceInterface;

public class AuthorityServiceFake implements AuthorityServiceInterface {
	private  AuthorityDAOFake accessAuthority;
	
	public AuthorityServiceFake(){
		accessAuthority= new AuthorityDAOFake();
	}

	@Override
	
	public List<Authority> getAllAuthorities() {
		return accessAuthority.getAllAuthorities();
	}

	@Override
	public Optional<Authority> searchByUserName(User userName) {
		return accessAuthority.searchByUserName(userName);
	}

	@Override
	public void add(User userName) throws Exception {
		accessAuthority.add(userName);
	}

	@Override
	public void update(int id, String authority) {
		accessAuthority.update(id, authority);
		
	}

	@Override
	public List<Authority> searchByRole(String authority) throws Exception {
		return accessAuthority.searchByRole(authority);
	}

	@Override
	public Optional<Authority> searchById(int id) throws Exception {
		return null;
	}
	

}

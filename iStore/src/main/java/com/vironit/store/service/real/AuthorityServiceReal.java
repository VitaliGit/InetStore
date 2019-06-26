package com.vironit.store.service.real;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vironit.store.dao.AuthorityDAO;
import com.vironit.store.entity.person.Authority;
import com.vironit.store.entity.person.User;
import com.vironit.store.service.AuthorityServiceInterface;

@Service
public class AuthorityServiceReal implements AuthorityServiceInterface {

	@Autowired
	private AuthorityDAO authorityAccess;
	

	@Override
	@Transactional
	public void update(int id, String authority) throws Exception {
		authority = "ROLE_"+ authority.toUpperCase();
		authorityAccess.update(id, authority);
	}

	@Override
	@Transactional
	public List<Authority> getAllAuthorities() throws Exception {
		return authorityAccess.getAllAuthorities();
	}

	@Override
	@Transactional
	public Optional<Authority> searchByUserName(User userName) throws Exception {
		return authorityAccess.searchByUserName(userName);
	}

	@Override
	@Transactional
	public void add(User userName) throws Exception {
		authorityAccess.add(userName);
	}

	@Override
	@Transactional
	public List<Authority> searchByRole(String authority) throws Exception {
		if(authority!=null) {
			authority = "ROLE_"+ authority.toUpperCase();
		}
		
		return authorityAccess.searchByRole(authority);
	}

	@Override
	@Transactional
	public Optional<Authority> searchById(int id) throws Exception {
		return authorityAccess.searchById(id);
	}

}

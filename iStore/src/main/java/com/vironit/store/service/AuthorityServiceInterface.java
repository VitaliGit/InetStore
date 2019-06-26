package com.vironit.store.service;

import java.util.List;
import java.util.Optional;

import com.vironit.store.entity.person.Authority;
import com.vironit.store.entity.person.User;

public interface AuthorityServiceInterface {
	public void update(int id, String authority) throws Exception;
	List<Authority> getAllAuthorities() throws Exception;
	void add(User userName) throws Exception;
	Optional<Authority> searchByUserName(User userName) throws Exception;
	Optional<Authority> searchById(int id) throws Exception;
	List<Authority> searchByRole(String authority) throws Exception;
	//no removal
}

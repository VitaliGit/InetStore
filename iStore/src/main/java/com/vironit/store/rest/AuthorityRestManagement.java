package com.vironit.store.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vironit.store.entity.person.Authority;
import com.vironit.store.entity.person.User;
import com.vironit.store.exception.rest.GoodNotFoundException;
import com.vironit.store.service.AuthorityServiceInterface;

@RestController
@RequestMapping("/rest_api")
public class AuthorityRestManagement {

	@Autowired
	private AuthorityServiceInterface authorityService;

	
	@GetMapping("/authority/{role}")
	public List<Authority> foundByRole(@PathVariable String role) throws Exception {
		List<Authority>  authority = authorityService.searchByRole(role);
		if (authority.isEmpty()) {
		throw new GoodNotFoundException("The terrible parameter has not been found - " + role);}
		else{System.out.println("My authorities"+authority);
		return authority;}
	}
	@GetMapping("/authority")
	public List<Authority> foundAllAuthorities() throws Exception {
		List<Authority>  authority = authorityService.getAllAuthorities();
		if (authority.isEmpty()) {
		throw new GoodNotFoundException("Still empty - ");}
		else{System.out.println("My authorities"+authority);
		return authority;}
	}
	@PutMapping("/authority")
	public Authority updateUser(@RequestBody Authority authority) throws Exception{
		User user = authority.getUserName();
		System.out.println("For authority"+user);
		authority.setUserName(user);
		return authority;
	}
}
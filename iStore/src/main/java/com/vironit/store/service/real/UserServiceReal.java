package com.vironit.store.service.real;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vironit.store.dao.AuthorityDAO;
import com.vironit.store.dao.UserDAO;
import com.vironit.store.entity.person.User;
import com.vironit.store.service.UserServiceInterface;

@Service
public class UserServiceReal implements UserServiceInterface{

	@Autowired
	private UserDAO userAccess;
	
	@Autowired
	private AuthorityDAO authorityAccees;
	

	@Override
	@Transactional
	public void add(User user) throws Exception {
		userAccess.add(user);
		authorityAccees.add(user);
	}

	@Override
	@Transactional
	public void remove(String userName) throws Exception {
		userAccess.remove(userName);		
	}



	@Override
	@Transactional
	public List<User> getAllUsers() throws Exception {
		return userAccess.getAllUsers();
	}

	@Override
	@Transactional
	public Optional<User> searchByUserName(String userName) throws Exception {
		return userAccess.searchByUserName(userName);
	}

	@Override
	@Transactional
	public List<User> searchByCharacter(String character) throws Exception {
		return userAccess.searchByCharacter(character);
	}

	@Override
	@Transactional
	public List<User> searchByPhoneNumber(String phoneNumber) throws Exception {
		return userAccess.searchByPhoneNumber(phoneNumber);
	}

	@Override
	@Transactional
	public void updatePassword(String userName, String password) throws Exception {
		userAccess.updatePassword(userName, password);
		
	}

	@Override
	@Transactional
	public void updateUserName(String userName, String reName) throws Exception {
		userAccess.updateUserName(userName, reName);
		
	}

	@Override
	@Transactional
	public void updateCharacter(String userName, String character) throws Exception {
		userAccess.updateCharacter(userName, character);		
	}

	@Override
	@Transactional
	public void updatePhoneNumber(String userName, String phoneNumber) throws Exception {
		userAccess.updatePhoneNumber(userName, phoneNumber);
		
	}

	@Override
	@Transactional
	public void updateUpdatedDate(String userName, LocalDateTime updatedDate) throws Exception {
		userAccess.updateUpdatedDate(userName, updatedDate);		
	}

	@Override
	@Transactional
	public void updateEnabled(String userName, short enabled) throws Exception {
		userAccess.updateEnabled(userName, enabled);
		
	}

	@Override
	@Transactional
	public void updateConnectionNumber(String userName, int connectionNumber) throws Exception {
		userAccess.updateConnectionNumber(userName, connectionNumber);
	}

}

package com.vironit.store.service.fake;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.vironit.store.dao.fake.UserDAOFake;
import com.vironit.store.entity.person.User;
import com.vironit.store.exception.NoUniqueUserNameException;
import com.vironit.store.service.UserServiceInterface;

public class UserServiceFake implements UserServiceInterface {
	private UserDAOFake userAccess;
	
	public UserServiceFake(){
		userAccess= new UserDAOFake();
	}
	
	@Override
	public void add(User user) throws NoUniqueUserNameException  {
		userAccess.add(user);
	}
	@Override
	public List<User> searchByCharacter(String character){
		return userAccess.searchByCharacter(character);
	}

	@Override
	public List<User> searchByPhoneNumber(String phoneNumber){
		return userAccess.searchByPhoneNumber(phoneNumber);
	}

	@Override
	public List<User> getAllUsers() {
		return userAccess.getAllUsers();
	}

	@Override
	public void remove(String userName) throws Exception {
		userAccess.remove(userName);
	}

	

	@Override
	public Optional<User> searchByUserName(String userName) throws Exception {
		return userAccess.searchByUserName(userName);
	}

	@Override
	public void updatePassword(String userName, String password) throws Exception {
		
	}


	@Override
	public void updateUserName(String userName, String reName) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCharacter(String userName, String character) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePhoneNumber(String userName, String phoneNumber) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUpdatedDate(String userName, LocalDateTime updatedDate) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEnabled(String userName, short enabled) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateConnectionNumber(String userName, int connectionNumber) throws Exception {
		// TODO Auto-generated method stub
		
	}


}

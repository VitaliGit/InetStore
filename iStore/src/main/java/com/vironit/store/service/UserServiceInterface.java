package com.vironit.store.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.vironit.store.entity.person.User;

public interface UserServiceInterface {
	void add(User user) throws Exception;
	void remove(String userName) throws Exception;
	List<User> getAllUsers()throws Exception;
	
	Optional<User> searchByUserName(String userName)throws Exception;
	List <User> searchByCharacter(String character)throws Exception;
	List <User> searchByPhoneNumber(String phoneNumber)throws Exception;
	void updateCharacter(String userName, String character) throws Exception;
	void updateUserName(String userName, String reName)throws Exception;
	void updatePassword(String userName, String password)throws Exception;
	
	void updatePhoneNumber(String userName, String phoneNumber) throws Exception;
	void updateUpdatedDate(String userName, LocalDateTime updatedDate) throws Exception;
	void updateEnabled(String userName, short enabled)throws Exception;
	void updateConnectionNumber(String userName, int connectionNumber) throws Exception;
	
	
	
}

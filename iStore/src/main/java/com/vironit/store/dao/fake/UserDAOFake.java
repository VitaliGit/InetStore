package com.vironit.store.dao.fake;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import com.vironit.store.dao.UserDAO;
import com.vironit.store.entity.person.User;
import com.vironit.store.exception.NoUniqueUserNameException;
import com.vironit.store.exception.SearchException;

public class UserDAOFake implements UserDAO{
	//private static UserDAOFake userFake= new UserDAOFake();
	private static List<User> userList = new ArrayList<>();
//	private static LocalDateTime date = LocalDateTime.now();
	
	public static void main(String[] args) throws Exception{
				
/*		User admin = new User(1, date, date, "Vitali", "mine", 10, "Best", "+37517025868");
		User unknown = new User(2, date, date, "Demo Admin", "forgotten", 4, "Undefined", "+37517025868");
		User user  = new User(4, date, date, "488log", "pass", 0,"Pretty normal", "+37518881215");
		User user2 = new User(10, date, date, "login2", "pass2", 15,"Loyal", "+3300052458");
		User user3 = new User(8, date, date, "log3", "pass2", 19,"Fraud", "+10856885668");
		User user4 = new User(9, date, date, "log9", "pass2", 0,"Loyal", "+44893558647");
		userList.sort((a,b)->a.compareTo(b));
		
		userFake.add(user);
		userFake.add(admin);
		userFake.add(user2);
		userFake.add(user3);
		userFake.remove(8);
		userFake.update(4, "The worst");
		userFake.add(user4);
		userFake.add(unknown);
		userFake.update(9, "Extremely loyal");
		//System.out.println(userFake.searchByConnectionNumber(0));
		userFake.getAllUsers().forEach(System.out::println);;*/
		
	}

	@Override
	public void add(User user) throws NoUniqueUserNameException{
		if (userList.stream().anyMatch(x -> x.getUserName().equals(user.getUserName()))) {
			throw new NoUniqueUserNameException();
		}
		userList.add(user);
	}
	@Override
	public void remove(String userName) throws SearchException {
		Optional<User> user = searchByUserName(userName);
		userList.remove(user.orElseThrow(SearchException::new)); 
	}

	@Override
	public Optional<User> searchByUserName(String userName){
		return userList.stream().filter(user->user.getUserName()==userName).findAny();
		}


	@Override
	public List <User> searchByCharacter(String character) {
		return userList.stream().filter(user->character.equals(user.getCharacter())).collect(Collectors.toList());
		}

	@Override
	public List <User> searchByPhoneNumber(String phoneNumber) {
		return userList.stream().filter(user->phoneNumber.equals(user.getPhoneNumber())).collect(Collectors.toList());

		}



	@Override
	public List<User> getAllUsers() {
		return userList;
	}

	@Override
	public void updatePassword(String userName, String password) {
		
	}

	@Override
	public void updateCharacter(String userName, String character) throws Exception {
		
	}

	@Override
	public void updateUserName(String userName, String reName) throws Exception {
		
	}

	@Override
	public void updatePhoneNumber(String userName, String phoneNumber) throws Exception {
		
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
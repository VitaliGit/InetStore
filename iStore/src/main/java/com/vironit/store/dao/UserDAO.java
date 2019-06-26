package com.vironit.store.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.vironit.store.entity.person.User;

public interface UserDAO {
	void add(User user) throws Exception;
	void remove(String userName) throws Exception;
	List<User> getAllUsers()throws Exception;
	
	Optional<User> searchByUserName(String userName)throws Exception;
	List <User> searchByCharacter(String character)throws Exception;
	List <User> searchByPhoneNumber(String phoneNumber)throws Exception;
	//whole update (saveOrUpdate) does not make any sense as an admin can hack users . The same for "authorities" since the usernames have to be totally equal.
	void updateUserName(String userName, String reName)throws Exception;
	void updatePassword(String userName, String password)throws Exception;
	void updatePhoneNumber(String userName, String phoneNumber) throws Exception;
	void updateUpdatedDate(String userName, LocalDateTime updatedDate) throws Exception;
	void updateEnabled(String userName, short enabled)throws Exception;
	void updateConnectionNumber(String userName, int connectionNumber) throws Exception;
	void updateCharacter(String userName, String character) throws Exception;
	
	
}




























/*
 * 
	public static User isValidLogin(String login, String password) throws Exception {
		try(Connection connection = DriverManager.getConnection(dbURL, dbLogin, dbPassword)){
				String sql = "SELECT * FROM T_Users WHERE login=? AND password=?";
				try(PreparedStatement state = connection.prepareStatement(sql)){
					state.setString(1, login);
					state.setString(2, password);
					try(ResultSet result = state.executeQuery()){
						if(result.next()) {
							return new User(result.getInt("id"), result.getString(2), result.getString(3), result.getInt(4));
						}else {
							return null;
						}
					}
				}
			}
}*/
 
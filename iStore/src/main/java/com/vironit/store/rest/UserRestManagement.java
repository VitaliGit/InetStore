package com.vironit.store.rest;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vironit.store.entity.person.User;
import com.vironit.store.exception.rest.GoodNotFoundException;
import com.vironit.store.service.UserServiceInterface;

@RestController
@RequestMapping("/rest_api")
public class UserRestManagement {

	@Autowired
	private UserServiceInterface userService;
	private LocalDateTime time = LocalDateTime.now();
	
	@GetMapping("/user/{userName}")
	public User foundByUserName(@PathVariable String userName) throws Exception {
		User user = userService.searchByUserName(userName).orElseThrow(()->new GoodNotFoundException("The terrible parameter has not been found - " + userName));
		System.out.println("My User"+user);
		return user;
	}
	@GetMapping("/user")
	public List<User> foundByUserName() throws Exception {
		List<User> user = userService.getAllUsers();
		System.out.println("My User"+user);
		return user;
	}
	@PutMapping("/user")
	public User updateUser(@RequestBody User user) throws Exception{
		user.setUpdatedDate(time);
		userService.updateEnabled(user.getUserName(), user.getEnabled());
		userService.updatePhoneNumber(user.getUserName(), user.getPhoneNumber());
		userService.updateCharacter(user.getUserName(), user.getCharacter());
		return user;
	}
	@DeleteMapping("/user/{userName}")
	public String deleteByUserName(@PathVariable String userName) throws Exception {
		User user = userService.searchByUserName(userName).orElseThrow(()->new GoodNotFoundException("The terrible parameter has not been found - " + userName));
		System.out.println(user);
		userService.remove(userName);
		return "Eliminated item # "+userName;
	}
}
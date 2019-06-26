package com.vironit.store.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vironit.store.entity.phone.Phone;
import com.vironit.store.exception.rest.GoodNotFoundException;
import com.vironit.store.service.PhoneServiceInterface;

@RestController
@RequestMapping("/rest_api")
public class PhoneRestManagement {

@Autowired
private PhoneServiceInterface phoneService;

@GetMapping("/phone/{id}")
	public Phone foundById(@PathVariable int id) throws Exception {
	Phone phone =phoneService.searchById(id).orElseThrow(()->new GoodNotFoundException("The terrible parameter has not been found - " + id)); 
	System.out.println("My Phone"+phone);
	return phone;
}

@GetMapping("/phone")
	public List<Phone> foundAll() throws Exception{
	return phoneService.getAllPhones();
}
@PostMapping("/phone")
	public Phone addItem(@RequestBody Phone thePhone) throws Exception {
	phoneService.add(thePhone);
	return thePhone;
	
}
@PutMapping("/phone")
	public Phone updateItem(@RequestBody Phone thePhone) throws Exception {
	phoneService.entireUpdate(thePhone);
	return thePhone;
}
@DeleteMapping("/phone/{id}")
	public String removeById(@PathVariable int id) throws Exception {
	Phone phone =phoneService.searchById(id).orElseThrow(()->new GoodNotFoundException("The terrible parameter has not been found - " + id));
	System.out.println(phone);
	phoneService.remove(id);
	return "Eliminated item #"+id;
}
}
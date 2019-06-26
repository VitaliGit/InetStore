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
import com.vironit.store.entity.laptop.Laptop;
import com.vironit.store.exception.rest.GoodNotFoundException;
import com.vironit.store.service.LaptopServiceInterface;

@RestController
@RequestMapping("/rest_api")
public class LaptopRestManagement {

@Autowired
private LaptopServiceInterface laptopService;

@GetMapping("/laptop/{id}")
	public Laptop foundById(@PathVariable int id) throws Exception {
	Laptop laptop =laptopService.searchById(id).orElseThrow(()->new GoodNotFoundException("The terrible parameter has not been found - " + id)); 
	System.out.println("My Laptop"+laptop);
	return laptop;
}

@GetMapping("/laptop")
	public List<Laptop> foundAll() throws Exception{
	return laptopService.getAllLaptops();
}
@PostMapping("/laptop")
	public Laptop addItem(@RequestBody Laptop theLaptop) throws Exception {
	laptopService.add(theLaptop);
	return theLaptop;
	
}
@PutMapping("/laptop")
	public Laptop updateItem(@RequestBody Laptop theLaptop) throws Exception {
	laptopService.entireUpdate(theLaptop);
	return theLaptop;
}
@DeleteMapping("/laptop/{id}")
	public String removeById(@PathVariable int id) throws Exception {
	Laptop laptop =laptopService.searchById(id).orElseThrow(()->new GoodNotFoundException("The terrible parameter has not been found - " + id));
	System.out.println(laptop);
	laptopService.remove(id);
	return "Eliminated item #"+id;
}
}
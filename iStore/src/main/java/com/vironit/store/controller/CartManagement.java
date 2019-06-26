package com.vironit.store.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vironit.store.entity.book.Book;
import com.vironit.store.entity.cart.Cart;
import com.vironit.store.entity.laptop.Laptop;
import com.vironit.store.entity.person.User;
import com.vironit.store.entity.phone.Phone;
//import com.vironit.store.entity.tablet.Tablet;
import com.vironit.store.service.BookServiceInterface;
import com.vironit.store.service.CartServiceInterface;
import com.vironit.store.service.LaptopServiceInterface;
import com.vironit.store.service.PhoneServiceInterface;
//import com.vironit.store.service.TabletServiceInterface;
import com.vironit.store.service.UserServiceInterface;
import com.vironit.store.entity.Status;

@Controller
@RequestMapping("/cart")
public class CartManagement {

	@Autowired
	private CartServiceInterface cartService;
	@Autowired
	private UserServiceInterface userService;
	@Autowired
	private PhoneServiceInterface phoneService;
	@Autowired
	private BookServiceInterface bookService;
	@Autowired
	private LaptopServiceInterface laptopService;
	
	@GetMapping("/remove_book")
	public String cartRemoveBook(@RequestParam("bookId") int id, @RequestParam("userName") String username, HttpSession session) throws Exception {

		cartService.removeBook(5);
		return "redirect:/cart/observation_book?userName="+username;
		
	}
	@GetMapping("/payment_book")
	public String payBook(@RequestParam("bookId") int id, @RequestParam("userName") String username, HttpSession session) throws Exception {
		cartService.updateStatus(id, Status.PAID);
		return "redirect:/cart/observation_book?userName="+username;
		
	}
	@GetMapping("/payment_phone")
	public String payPhone(@RequestParam("phoneId") int id, @RequestParam("userName") String username, HttpSession session) throws Exception {
		cartService.updateStatus(id, Status.PAID);
		return "redirect:/cart/observation_phone?userName="+username;
		
	}
	@GetMapping("/payment_laptop")
	public String payLaptop(@RequestParam("laptopId") int id, @RequestParam("userName") String username, HttpSession session) throws Exception {
		cartService.updateStatus(id, Status.PAID);
		return "redirect:/cart/observation_laptop?userName="+username;
		
	}
	@GetMapping("/add_phone")
	public String cartAddPhone(@RequestParam("phoneId") int id, @RequestParam("userName") String username, HttpSession session) throws Exception {
		User user = userService.searchByUserName(username).get();
		Phone phone = phoneService.searchById(id).get();
		cartService.addPhone(new Cart(), phone, user);
		return "redirect:/phone/search";
		
	}
	@GetMapping("/add_book")
	public String cartAddBook(@RequestParam("bookId") int id, @RequestParam("userName") String username, HttpSession session) throws Exception {
		User user = userService.searchByUserName(username).get();
		Book book = bookService.searchById(id).get();
		cartService.addBook(new Cart(), book, user);
		return "redirect:/book/search";
		
	}
	@GetMapping("/add_laptop")
	public String cartAddLaptop(@RequestParam("laptopId") int id, @RequestParam("userName") String username, HttpSession session) throws Exception {
		User user = userService.searchByUserName(username).get();
		Laptop laptop = laptopService.searchById(id).get();
		cartService.addLaptop(new Cart(), laptop, user);
		return "redirect:/laptop/search";
		
	}
	@GetMapping("/observation_phone")
	public String observationPhone(Model theModel,@RequestParam("userName") String username) throws Exception {
		User user = userService.searchByUserName(username).get();
		List <Cart> listPhone =cartService.foundPhoneForUser(user);
		theModel.addAttribute("list", listPhone);
		return "cart_phone";
	}
	@GetMapping("/observation_book")
	public String observationBook(Model theModel,@RequestParam("userName") String username) throws Exception {
		User user = userService.searchByUserName(username).get();
		List <Cart> listBook =cartService.foundBookForUser(user);
		theModel.addAttribute("list", listBook);
		return "cart_book";
	}
	@GetMapping("/observation_laptop")
	public String observationLaptop(Model theModel,@RequestParam("userName") String username) throws Exception {
		User user = userService.searchByUserName(username).get();
		System.out.println("log 1");
		List <Cart> listLaptop =cartService.foundLaptopForUser(user);
		theModel.addAttribute("list", listLaptop);
		return "cart_laptop";
	}
	
}

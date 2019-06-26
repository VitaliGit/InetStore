package com.vironit.store.controller.person;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vironit.store.entity.person.Authority;
import com.vironit.store.entity.person.User;
import com.vironit.store.service.AuthorityServiceInterface;
import com.vironit.store.service.UserServiceInterface;

@Controller
@RequestMapping("/authority")
public class AuthorityManagement {

	@Autowired
	private AuthorityServiceInterface authorityService;
	@Autowired
	private UserServiceInterface userService;
	
	private LocalDateTime time = LocalDateTime.now();
	
	@InitBinder
	private void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor  ste = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, ste);
	}
	
	@GetMapping("/management")
	public String authorityAction(Model theModel) throws Exception{
		List <Authority> wholeList = authorityService.getAllAuthorities();
		theModel.addAttribute("wholeList",wholeList);
		return "authority_management";
	}
	@PostMapping("/search")
	public String searchCustomers(@RequestParam("userName") String userName, @RequestParam("authorities") String authorities, Model theModel) throws Exception {
		Authority authority1 = new Authority(); 
		
		User user = new User();
		System.out.println("outside search");
		List <Authority> authority2=authorityService.searchByRole(authorities);
		
		System.out.println("List exception");
	    Set <Authority> set = new HashSet<>(); // in order not to repeat results of the search
	    set.addAll(authority2);

		if(userService.searchByUserName(userName).isPresent()) {
	       user=userService.searchByUserName(userName).get();
	       authority1=authorityService.searchByUserName(user).get();
	       set.add(authority1); 
	       }

	        theModel.addAttribute("set", set);
	        return "authority_management";        
	    } 

	@GetMapping("/update")
	public String updateRoleForm(@RequestParam("id") int id, HttpServletRequest request, Model theModel) throws Exception {
		Authority authority = authorityService.searchById(id).get();
		String role = request.getParameter("role"); if (role==null) role="";
		theModel.addAttribute("authority", authority);
		theModel.addAttribute("role", role);
		return "role";
	}
	@PostMapping("/update")
	public String updateRole(@RequestParam("id") int id, @RequestParam("role") String role, Model theModel) throws Exception {
		authorityService.update(id, role);
		Authority authority = authorityService.searchById(id).get();
		User user = authority.getUserName();
		userService.updateUpdatedDate(user.getUserName(), time);
		System.out.println("Fuck"+user);
		return "redirect:/authority/management";	
	}
	
	
	
}

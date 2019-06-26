package com.vironit.store.controller.person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.vironit.store.entity.person.User;
import com.vironit.store.service.AuthorityServiceInterface;
import com.vironit.store.service.UserServiceInterface;

@Controller
@RequestMapping("/user")
public class UserManagement {
	
	@Autowired
	private UserServiceInterface userService;
	@Autowired
	private AuthorityServiceInterface authorityService;
	
	private  PasswordEncoder encode= new BCryptPasswordEncoder();
	private LocalDateTime time = LocalDateTime.now();
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor ste= new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, ste);
	}
	
	@GetMapping("/registration")
	public String registrationForm( Model theModel) throws Exception {
		theModel.addAttribute("user", new User());
		return "registration";
	}
	@PostMapping("/registration")
	public String registration (@Valid @ModelAttribute("user") User user, BindingResult br, Model theModel) throws Exception  {
		System.out.println("Hello "+user);
		if(br.hasErrors()) 	{
			return "registration";
		}
		else if(userService.searchByUserName(user.getUserName()).isPresent()) 	{
			theModel.addAttribute("hiberExc", "Cet identifiant existe déjà ");
			return "registration";
		}
		else {
			System.out.println("Hello "+user);
			userService.add(user);
			if(userService.getAllUsers().size()==1) {
				authorityService.update(1,"ADMIN");
			}
			userService.updatePassword(user.getUserName(), "{bcrypt}"+encode.encode(user.getPassword()));
			return "redirect:/login";
		}
	}
	@GetMapping("/management")
	public String userAction(Model theModel) throws Exception{
		List <User> wholeList = userService.getAllUsers();
		theModel.addAttribute("wholeList",wholeList);
		return "user_management";
	}
    @PostMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName, @RequestParam("phoneNumber") String phoneNumber,@RequestParam("character") String character, Model theModel) throws Exception {

        User user1 = new User(); List <User> user2 = userService.searchByPhoneNumber(phoneNumber); List <User> user3 = userService.searchByCharacter(character);
        Set <User> set = new HashSet<>(); // in order not to repeat results of the search
        if(userService.searchByUserName(theSearchName).isPresent()) {
        	user1=userService.searchByUserName(theSearchName).get();
        	set.add(user1);        }
           	set.addAll(user2);
           	set.addAll(user3);
            theModel.addAttribute("set", set);
        return "user_management";        
    }
    @GetMapping("/enable")
	public String disAble(@RequestParam("userName") String userName) throws Exception {
    	if(userService.searchByUserName(userName).get().getEnabled()==1) {
    	userService.updateEnabled(userName, (short)0);
    	userService.updateUpdatedDate(userName, time);}
    	else {userService.updateEnabled(userName, (short)1);
    	userService.updateUpdatedDate(userName, time);}
		return "redirect:management";	

	}
    @GetMapping("/update_character")
	public String updateCharacterForm(@RequestParam("userName") String userName,  HttpServletRequest request,  Model theModel) throws Exception {
    	String character = request.getParameter("character"); if (character==null) character="";
    	User theUser = userService.searchByUserName(userName).get();
    	theModel.addAttribute("theUser", theUser);
    	userService.updateUpdatedDate(userName, time);
		return "character";	
	}
    @PostMapping("/update_character")
    public String updateCharacter(@RequestParam("userName") String userName, @RequestParam("character") String character, Model theModel) throws Exception {
    	userService.updateCharacter(userName, character);
    	userService.updateUpdatedDate(userName, time);
    	return "redirect:management";	
	}
    @GetMapping("/verify_present")
	public String passwordVerifyForm(HttpServletRequest request,  Model theModel) throws Exception {
		String userName = request.getParameter("userName"); if (userName==null) userName="";
		System.out.println();
		theModel.addAttribute("userName", userName);
		return "pass_verification";
	}
	@PostMapping("/verify_present")
	public String passwordVerify(@RequestParam("userName") String userName, Model theModel) throws Exception {
		if(userService.searchByUserName(userName).isPresent()==true) {
			User user= userService.searchByUserName(userName).get();
			theModel.addAttribute("user", user);
			theModel.addAttribute("userName", userName);
			return "redirect:/user/password_change";	
		}
		else return "pass_verification";
	}
	@GetMapping("/password_change")
	public String passwordChangeForm(@RequestParam("userName") String userName,  Model theModel) throws Exception {
		
		User user = userService.searchByUserName(userName).get();
		String password = user.getPassword();
		System.out.println("Hello pass"+password);
		user.setPassword("");
		theModel.addAttribute("user", user);
		theModel.addAttribute("password", "");
		return "pass_forgotten";
	}
	@PostMapping("/password_change")
	public String passwordChange (@Valid @ModelAttribute("user") User user, BindingResult br) throws Exception {
		System.out.println("Hello "+user);
		if(br.hasErrors()) {	
			System.out.println("Got an error"); 
			return "pass_forgotten";}
		else {
			userService.updateUpdatedDate(user.getUserName(), time);
			System.out.println("Hello here"+user);
			userService.updatePassword(user.getUserName(), "{bcrypt}"+encode.encode(user.getPassword()));
			return "redirect:/login";
		}
	}
	
}
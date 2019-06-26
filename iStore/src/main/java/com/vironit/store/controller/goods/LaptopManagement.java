package com.vironit.store.controller.goods;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.vironit.store.entity.builder.LaptopBuilder;
import com.vironit.store.entity.laptop.Laptop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vironit.store.dto.LaptopSearchDTO;
import com.vironit.store.dto.LaptopSearchDTOBuilder;
import com.vironit.store.service.LaptopServiceInterface;

@Controller
@RequestMapping("/laptop")
public class LaptopManagement {
	
	@Autowired
	private LaptopServiceInterface laptopService;
	
	
	@GetMapping("/search")
	public String foundBySeveralOptionsForm(HttpServletRequest request, Model theModel) throws Exception {
		// meant for our checkboxes
		String price = request.getParameter("price"); 									if(price==null) price="";
		String discount=request.getParameter("discount");								if(discount==null) discount="";
		String available = request.getParameter("available");							if(available==null) available="";
		String os = request.getParameter("os");											if(os==null) os="";
		String color = request.getParameter("color");									if(color==null) color="";
		String display = request.getParameter("display");								if(display==null) display="";
		String brand = request.getParameter("brand");									if(brand==null) brand="";
		String ram = request.getParameter("ram");										if(ram==null) ram="";
		
		String memory = request.getParameter("memory");									if(memory==null) memory="";
		String cpu = request.getParameter("cpu");										if(cpu==null) cpu="";
		String camera = request.getParameter("camera");									if(camera==null) camera="";
		String frontCamera = request.getParameter("frontCamera");						if(frontCamera==null) frontCamera="";
		
		System.out.println("In the doGet");
		theModel.addAttribute("price", price);
		theModel.addAttribute("discount", discount);
		theModel.addAttribute("available", available);
		theModel.addAttribute("display", display);
		theModel.addAttribute("brand", brand);
		theModel.addAttribute("os", os);
		theModel.addAttribute("color", color);
		theModel.addAttribute("ram", ram);
		theModel.addAttribute("memory", memory);
		theModel.addAttribute("cpu", cpu);
		theModel.addAttribute("camera", camera);
		theModel.addAttribute("frontCamera", frontCamera);
		return "laptop_search";
	}
	@PostMapping("/search")
	public String foundBySeveralOptions(HttpServletRequest request, Model theModel) throws Exception {
		Boolean available;
		if(request.getParameter("available")==null) 	available=false; 				else available=true;
	
		//for the others as they are far less complicated
		Integer price = Integer.parseInt(request.getParameter("price")); 									
		Integer discount=Integer.parseInt(request.getParameter("discount"));
		String os = request.getParameter("os");																
		String color = request.getParameter("color");														
		Float display = Float.parseFloat(request.getParameter("display"));									
		String brand = request.getParameter("brand");														
		Integer ram = Integer.parseInt(request.getParameter("ram"));										

		Integer memory = Integer.parseInt(request.getParameter("memory"));									
		Float cpu = Float.parseFloat(request.getParameter("cpu"));											
		Integer camera = Integer.parseInt(request.getParameter("camera"));									
		Float frontCamera = Float.parseFloat(request.getParameter("frontCamera"));							
		
		System.out.println("In the doPost");
		
		System.out.println(price);
		System.out.println(available);
		System.out.println(discount);
		System.out.println(os);
		System.out.println(brand);
		System.out.println(color);
		System.out.println(ram);
		System.out.println(display);
		System.out.println(memory);
		System.out.println(camera);
		System.out.println(cpu);
		System.out.println(frontCamera);

		
		LaptopSearchDTOBuilder lsdtoBuilder = new LaptopSearchDTOBuilder();
		LaptopSearchDTO lsdto = lsdtoBuilder.withPrice(price).withDiscount(discount).withAvailable(available).
		withOs(os).withColor(color).withDisplay(display).withBrand(brand).withRam(ram).
		withMemory(memory).withCpu(cpu).withCamera(camera).withFrontCamera(frontCamera).build();
		
		List<Laptop> searchList= laptopService.searchBySeveralOptions(lsdto);
		System.out.println(searchList);
		theModel.addAttribute("list", searchList);
		String forReturn = "";
		if(!searchList.isEmpty()) forReturn= "laptop_found";
		else return forReturn= "not_found";
		return forReturn;
		
	}
	

	@GetMapping("/management")
	public String foundAllLaptops(HttpServletRequest request, Model theModel) throws Exception {
		List<Laptop> wholeList= laptopService.getAllLaptops();
		
		theModel.addAttribute("wholeList",wholeList);
		return "laptop_management";
	}
	
	@GetMapping("/addition")
	public String addLaptopsForm(HttpServletRequest request, Model theModel) throws Exception {
	String id = request.getParameter("id"); 										if(id==null) id="";
	String price = request.getParameter("price"); 									if(price==null) price="";
	String discount=request.getParameter("discount");								if(discount==null) discount="";
	String available = request.getParameter("available");							if(available==null) available="";
	String os = request.getParameter("os");											if(os==null) os="";
	String color = request.getParameter("color");									if(color==null) color="";
	String display = request.getParameter("display");								if(display==null) display="";
	String brand = request.getParameter("brand");									if(brand==null) brand="";
	String ram = request.getParameter("ram");										if(ram==null) ram="";
	
	String memory = request.getParameter("memory");									if(memory==null) memory="";
	String cpu = request.getParameter("cpu");										if(cpu==null) cpu="";
	String camera = request.getParameter("camera");									if(camera==null) camera="";
	String frontCamera = request.getParameter("frontCamera");						if(frontCamera==null) frontCamera="";
	return "laptop_addition";
}
	@PostMapping("/addition")
	public String addLaptops(HttpServletRequest request, Model theModel) throws Exception {
		Boolean available;
		if(request.getParameter("available")==null) 	available=false; 				else available=true;

		//for the others as they are far less complicated
		Integer id = Integer.parseInt(request.getParameter("id")); 
		Integer price = Integer.parseInt(request.getParameter("price")); 									
		Integer discount=Integer.parseInt(request.getParameter("discount"));
		String os = request.getParameter("os");																
		String color = request.getParameter("color");														
		Float display = Float.parseFloat(request.getParameter("display"));									
		String brand = request.getParameter("brand");														
		Integer ram = Integer.parseInt(request.getParameter("ram"));										

		Integer memory = Integer.parseInt(request.getParameter("memory"));									
		Float cpu = Float.parseFloat(request.getParameter("cpu"));											
		Integer camera = Integer.parseInt(request.getParameter("camera"));									
		Float frontCamera = Float.parseFloat(request.getParameter("frontCamera"));							
		LaptopBuilder pb = new LaptopBuilder();
		Laptop added = pb.withID(id).withAvailable(available).withBrand(brand).withCamera(camera).withColor(color).
				withCPU(cpu).withDiscount(discount).withDisplay(display).withFrontCamera(frontCamera).
				withMemory(memory).withOS(os).withPrice(price).withRam(ram).build();
		theModel.addAttribute("added", added);
		System.out.println(added);
		laptopService.add(added);
		return "redirect:/laptop/management";
	}
	@GetMapping("/removal")
	public String removeLaptops(@RequestParam("laptopId") int id) throws Exception {
		laptopService.remove(id);
		return "redirect:management";	

	}
	@GetMapping("/update")
	public String updateLaptopsForm(HttpServletRequest request, @RequestParam("laptopId") int id,	Model theModel) throws Exception {
		String price = request.getParameter("price"); if (price==null) price="0";
		String discount = request.getParameter("discount"); if (discount==null) discount="0";
		String available = request.getParameter("available"); if (available==null) available="true";
		Laptop laptop = laptopService.searchById(id).get();
		System.out.println(laptop+"foundLaptop");
		theModel.addAttribute("theLaptop", laptop);
		theModel.addAttribute("laptopId", id);
		theModel.addAttribute("price", price);
		theModel.addAttribute("discount", discount);
		theModel.addAttribute("available", available);
		return "laptop_updateform";
	}
	
	@PostMapping("/update")
	public String updateLaptops(HttpServletRequest request, @ModelAttribute("theLaptop") Laptop laptop) throws Exception {
		int id =laptop.getId();
		Integer price = Integer.parseInt(request.getParameter("price")); 
		Integer discount = Integer.parseInt(request.getParameter("discount"));
		Boolean available = Boolean.parseBoolean(request.getParameter("available")); 
		laptopService.updatePrice(id, price);
		laptopService.updateDiscount(id, discount);
		laptopService.updateAvailable(id, available);
		return "redirect:management";	
	}
	}



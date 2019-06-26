package com.vironit.store.controller.goods;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.vironit.store.entity.builder.PhoneBuilder;
import com.vironit.store.entity.phone.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vironit.store.dto.PhoneSearchDTO;
import com.vironit.store.dto.PhoneSearchDTOBuilder;
import com.vironit.store.service.PhoneServiceInterface;

@Controller
@RequestMapping("/phone")
public class PhoneManagement {
	
	@Autowired
	private PhoneServiceInterface phoneService;
	
	
	@GetMapping("/search")
	public String foundBySeveralOptionsForm(HttpServletRequest request, Model theModel) throws Exception {
		// meant for our checkboxes
		String price = request.getParameter("price"); 									if(price==null) price="";
		String discount=request.getParameter("discount");								if(discount==null) discount="";
		String available = request.getParameter("available");							if(available==null) available="";
		String bluetooth = request.getParameter("bluetooth");							if(bluetooth==null) bluetooth="";
		String os = request.getParameter("os");											if(os==null) os="";
		String color = request.getParameter("color");									if(color==null) color="";
		String display = request.getParameter("display");								if(display==null) display="";
		String brand = request.getParameter("brand");									if(brand==null) brand="";
		String ram = request.getParameter("ram");										if(ram==null) ram="";
		
		String memory = request.getParameter("memory");									if(memory==null) memory="";
		String cpu = request.getParameter("cpu");										if(cpu==null) cpu="";
		String camera = request.getParameter("camera");									if(camera==null) camera="";
		String frontCamera = request.getParameter("frontCamera");						if(frontCamera==null) frontCamera="";
		String backCamera = request.getParameter("backCamera");						 	if(backCamera==null) backCamera="";
		
		System.out.println("In the doGet");
		theModel.addAttribute("price", price);
		theModel.addAttribute("discount", discount);
		theModel.addAttribute("available", available);
		theModel.addAttribute("bluetooth", bluetooth);
		theModel.addAttribute("display", display);
		theModel.addAttribute("brand", brand);
		theModel.addAttribute("os", os);
		theModel.addAttribute("color", color);
		theModel.addAttribute("ram", ram);
		theModel.addAttribute("memory", memory);
		theModel.addAttribute("cpu", cpu);
		theModel.addAttribute("camera", camera);
		theModel.addAttribute("frontCamera", frontCamera);
		theModel.addAttribute("backCamera", backCamera);
		return "phone_search";
	}
	@PostMapping("/search")
	public String foundBySeveralOptions(HttpServletRequest request, Model theModel) throws Exception {
		Boolean available;
		if(request.getParameter("available")==null) 	available=false; 				else available=true;
		Boolean bluetooth;
		if(request.getParameter("bluetooth")==null) 	bluetooth=false; 				else bluetooth=true;	
		Boolean keyboard;
		if(request.getParameter("keyboard")==null) 		keyboard=false; 				else keyboard=true;

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
		Float backCamera = Float.parseFloat(request.getParameter("backCamera"));
		
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
		System.out.println(backCamera);
		System.out.println(bluetooth);
		System.out.println(keyboard);
		
		
		PhoneSearchDTOBuilder psdtoBuilder = new PhoneSearchDTOBuilder();
		PhoneSearchDTO psdto = psdtoBuilder.withPrice(price).withDiscount(discount).withAvailable(available).withBluetooth(bluetooth).
		withOs(os).withColor(color).withDisplay(display).withBrand(brand).withRam(ram).
		withMemory(memory).withCpu(cpu).withCamera(camera).withFrontCamera(frontCamera).withBackCamera(backCamera).build();
		
		List<Phone> searchList= phoneService.searchBySeveralOptions(psdto);
		System.out.println(searchList);
		theModel.addAttribute("list", searchList);
		String forReturn = "";
		if(!searchList.isEmpty()) forReturn= "phone_found";
		else return forReturn= "not_found";
		return forReturn;
		
	}
	

	@GetMapping("/management")
	public String foundAllPhones(HttpServletRequest request, Model theModel) throws Exception {
		List<Phone> wholeList= phoneService.getAllPhones();
		
		theModel.addAttribute("wholeList",wholeList);
		return "phone_management";
	}
	
	@GetMapping("/addition")
	public String addPhonesForm(HttpServletRequest request, Model theModel) throws Exception {
	String id = request.getParameter("id"); 										if(id==null) id="";
	String price = request.getParameter("price"); 									if(price==null) price="";
	String discount=request.getParameter("discount");								if(discount==null) discount="";
	String available = request.getParameter("available");							if(available==null) available="";
	String bluetooth = request.getParameter("bluetooth");							if(bluetooth==null) bluetooth="";
	String os = request.getParameter("os");											if(os==null) os="";
	String color = request.getParameter("color");									if(color==null) color="";
	String display = request.getParameter("display");								if(display==null) display="";
	String brand = request.getParameter("brand");									if(brand==null) brand="";
	String ram = request.getParameter("ram");										if(ram==null) ram="";
	
	String memory = request.getParameter("memory");									if(memory==null) memory="";
	String cpu = request.getParameter("cpu");										if(cpu==null) cpu="";
	String camera = request.getParameter("camera");									if(camera==null) camera="";
	String frontCamera = request.getParameter("frontCamera");						if(frontCamera==null) frontCamera="";
	String backCamera = request.getParameter("backCamera");						 	if(backCamera==null) backCamera="";
	return "phone_addition";
}
	@PostMapping("/addition")
	public String addPhones(HttpServletRequest request, Model theModel) throws Exception {
		Boolean available;
		if(request.getParameter("available")==null) 	available=false; 				else available=true;
		Boolean bluetooth;
		if(request.getParameter("bluetooth")==null) 	bluetooth=false; 				else bluetooth=true;	


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
		Float backCamera = Float.parseFloat(request.getParameter("backCamera"));
		PhoneBuilder pb = new PhoneBuilder();
		Phone added = pb.withID(id).withAvailable(available).withBackCamera(backCamera).withBluetooth(bluetooth).withBrand(brand).
				withCamera(camera).withColor(color).withCPU(cpu).withDiscount(discount).withDisplay(display).withFrontCamera(frontCamera).
				withMemory(memory).withOS(os).withPrice(price).withRam(ram).build();
		theModel.addAttribute("added", added);
		System.out.println(added);
		phoneService.add(added);
		return "redirect:/phone/management";
	}
	@GetMapping("/removal")
	public String removePhones(@RequestParam("phoneId") int id) throws Exception {
		phoneService.remove(id);
		return "redirect:management";	

	}
	@GetMapping("/update")
	public String updatePhonesForm(HttpServletRequest request, @RequestParam("phoneId") int id,	Model theModel) throws Exception {
		String price = request.getParameter("price"); if (price==null) price="0";
		String discount = request.getParameter("discount"); if (discount==null) discount="0";
		String available = request.getParameter("available"); if (available==null) available="true";
		Phone phone = phoneService.searchById(id).get();
		System.out.println(phone+"foundPhone");
		theModel.addAttribute("thePhone", phone);
		theModel.addAttribute("phoneId", id);
		theModel.addAttribute("price", price);
		theModel.addAttribute("discount", discount);
		theModel.addAttribute("available", available);
		return "phone_updateform";
	}
	
	@PostMapping("/update")
	public String updatePhones(HttpServletRequest request, @ModelAttribute("thePhone") Phone phone) throws Exception {
		int id =phone.getId();
		Integer price = Integer.parseInt(request.getParameter("price")); 
		Integer discount = Integer.parseInt(request.getParameter("discount"));
		Boolean available = Boolean.parseBoolean(request.getParameter("available")); 
		phoneService.updatePrice(id, price);
		phoneService.updateDiscount(id, discount);
		phoneService.updateAvailable(id, available);
		return "redirect:management";	
	}
	}



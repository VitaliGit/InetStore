package com.vironit.store.controller.goods;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.vironit.store.entity.builder.BookBuilder;
import com.vironit.store.entity.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vironit.store.dto.BookSearchDTO;
import com.vironit.store.dto.BookSearchDTOBuilder;
import com.vironit.store.service.BookServiceInterface;

@Controller
@RequestMapping("/book")
public class BookManagement {
	
	@Autowired
	private BookServiceInterface bookService;
	
	@GetMapping("/search")
	public String foundBySeveralOptionsForm(HttpServletRequest request, Model theModel) throws Exception {
		// meant for our checkboxes
		String price = request.getParameter("price"); 									if(price==null) price="";
		String discount=request.getParameter("discount");								if(discount==null) discount="";
		String available = request.getParameter("available");							if(available==null) available="";
		
		String ageGroup = request.getParameter("ageGroup");								if(ageGroup==null) ageGroup="";
		String genre = request.getParameter("genre");									if(genre==null) genre="";
		String title = request.getParameter("title");									if(title==null) title="";
		String author = request.getParameter("author");									if(author==null) author="";
		
		System.out.println("In the doGet");
		theModel.addAttribute("price", price);
		theModel.addAttribute("discount", discount);
		theModel.addAttribute("available", available);
		theModel.addAttribute("ageGroup", ageGroup);
		theModel.addAttribute("genre", genre);
		theModel.addAttribute("title", title);
		theModel.addAttribute("author", author);
		return "book_search";
	}
	@PostMapping("/search")
	public String foundBySeveralOptions(HttpServletRequest request, Model theModel) throws Exception {
		Boolean available;
		if(request.getParameter("available")==null) 	available=false; 				else available=true;
	
		//for the others as they are far less complicated
		Integer price = Integer.parseInt(request.getParameter("price")); 									
		Integer discount=Integer.parseInt(request.getParameter("discount"));
		String ageGroup = request.getParameter("ageGroup");								if(ageGroup==null) ageGroup="";
		String genre = request.getParameter("genre");									if(genre==null) genre="";
		String title = request.getParameter("title");									if(title==null) title="";
		String author = request.getParameter("author");									if(author==null) author="";
		
		System.out.println("In the doPost");
		
		System.out.println(price);
		System.out.println(available);
		System.out.println(discount);
		System.out.println(ageGroup);
		System.out.println(genre);
		System.out.println(title);
		System.out.println(author);
		
		BookSearchDTOBuilder lsdtoBuilder = new BookSearchDTOBuilder();
		BookSearchDTO lsdto = lsdtoBuilder.withPrice(price).withDiscount(discount).withAvailable(available).withAuthor(author).
				withAgeGroup(ageGroup).withGenre(genre).withTitle(title).build();
		
		List<Book> searchList= bookService.searchBySeveralOptions(lsdto);
		System.out.println(searchList);
		theModel.addAttribute("list", searchList);
		String forReturn = "";
		if(!searchList.isEmpty()) forReturn= "book_found";
		else return forReturn= "not_found";
		return forReturn;
		
	}
	

	@GetMapping("/management")
	public String foundAllBooks(HttpServletRequest request, Model theModel) throws Exception {
		List<Book> wholeList= bookService.getAllBooks();
		
		theModel.addAttribute("wholeList",wholeList);
		return "book_management";
	}
	
	@GetMapping("/addition")
	public String addBooksForm(HttpServletRequest request, Model theModel) throws Exception {
		String id = request.getParameter("id"); 										if(id==null) id="";
		String price = request.getParameter("price"); 									if(price==null) price="";
		String discount=request.getParameter("discount");								if(discount==null) discount="";
		String available = request.getParameter("available");							if(available==null) available="";
		
		String ageGroup = request.getParameter("ageGroup");								if(ageGroup==null) ageGroup="";
		String genre = request.getParameter("genre");									if(genre==null) genre="";
		String title = request.getParameter("title");									if(title==null) title="";
		String author = request.getParameter("author");									if(author==null) author="";
	
	return "book_addition";
}
	@PostMapping("/addition")
	public String addBooks(HttpServletRequest request, Model theModel) throws Exception {
		Boolean available;
		if(request.getParameter("available")==null) 	available=false; 				else available=true;
	
		//for the others as they are far less complicated
		Integer id = Integer.parseInt(request.getParameter("id")); 
		Integer price = Integer.parseInt(request.getParameter("price")); 									
		Integer discount=Integer.parseInt(request.getParameter("discount"));
		String ageGroup = request.getParameter("ageGroup");								if(ageGroup==null) ageGroup="";
		String genre = request.getParameter("genre");									if(genre==null) genre="";
		String title = request.getParameter("title");									if(title==null) title="";
		String author = request.getParameter("author");									if(author==null) author="";
									
		BookBuilder pb = new BookBuilder();
		Book added = pb.withID(id).withPrice(price).withDiscount(discount).withAvailable(available).withAuthor(author).
				withAgeGroup(ageGroup).withGenre(genre).withTitle(title).build();
		theModel.addAttribute("added", added);
		System.out.println(added);
		bookService.add(added);
		return "redirect:/book/management";
	}
	@GetMapping("/removal")
	public String removeBooks(@RequestParam("bookId") int id) throws Exception {
		bookService.remove(id);
		return "redirect:management";	

	}
	@GetMapping("/update")
	public String updateBooksForm(HttpServletRequest request, @RequestParam("bookId") int id,	Model theModel) throws Exception {
		String price = request.getParameter("price"); if (price==null) price="0";
		String discount = request.getParameter("discount"); if (discount==null) discount="0";
		String available = request.getParameter("available"); if (available==null) available="true";
		Book book = bookService.searchById(id).get();
		System.out.println(book+"foundBook");
		theModel.addAttribute("theBook", book);
		theModel.addAttribute("bookId", id);
		theModel.addAttribute("price", price);
		theModel.addAttribute("discount", discount);
		theModel.addAttribute("available", available);
		return "book_updateform";
	}
	
	@PostMapping("/update")
	public String updateBooks(HttpServletRequest request, @ModelAttribute("theBook") Book book) throws Exception {
		int id =book.getId();
		Integer price = Integer.parseInt(request.getParameter("price")); 
		Integer discount = Integer.parseInt(request.getParameter("discount"));
		Boolean available = Boolean.parseBoolean(request.getParameter("available")); 
		bookService.updatePrice(id, price);
		bookService.updateDiscount(id, discount);
		bookService.updateAvailable(id, available);
		return "redirect:management";	
	}
	}



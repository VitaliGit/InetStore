package com.vironit.store.controller.goods;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vironit.store.dao.db.DAOContext;
import com.vironit.store.dto.TabletSearchDTO;
import com.vironit.store.dto.TabletSearchDTOBuilder;
import com.vironit.store.entity.tablet.Tablet;
import com.vironit.store.service.real.TabletServiceReal;



@WebServlet("/tablet_search")
public class TabletSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TabletServiceReal tabletService = new TabletServiceReal();
	
	
    public TabletSearch() {
        super();
    }
    @Override
	public void init() throws ServletException {
		DAOContext.init( this.getServletContext() );
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String price = request.getParameter("price"); 									if(price==null) price="";
		String discount=request.getParameter("discount");								if(discount==null) discount="";
		String available = request.getParameter("available");							if(available==null) available="";
		String bluetooth = request.getParameter("bluetooth");							if(bluetooth==null) bluetooth="";
		String keyboard = request.getParameter("keyboard");								if(keyboard==null) keyboard="";
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
		
		HttpSession session = request.getSession(true);
		session.setAttribute("price", price);
		session.setAttribute("discount", discount);
		session.setAttribute("available", available);
		session.setAttribute("bluetooth", bluetooth);
		session.setAttribute("keyboard", keyboard);
		session.setAttribute("display", display);
		session.setAttribute("brand", brand);
		session.setAttribute("os", os);
		session.setAttribute("color", color);
		session.setAttribute("ram", ram);
		session.setAttribute("memory", memory);
		session.setAttribute("cpu", cpu);
		session.setAttribute("camera", camera);
		session.setAttribute("frontCamera", frontCamera);
		session.setAttribute("backCamera", backCamera);
		request.getRequestDispatcher("/WEB-INF/view/tablet_search.jsp").forward(request, response);
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// meant for our checkboxes
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
					
					
					TabletSearchDTOBuilder tsdtoBuilder = new TabletSearchDTOBuilder();
					TabletSearchDTO tsdto = tsdtoBuilder.withPrice(price).withDiscount(discount).withAvailable(available).withBluetooth(bluetooth).withKeyboard(keyboard).
					withOs(os).withColor(color).withDisplay(display).withBrand(brand).withRam(ram).
					withMemory(memory).withCpu(cpu).withCamera(camera).withFrontCamera(frontCamera).withBackCamera(backCamera).build();
											
					try {
						System.out.println("All possible and existing in the database" + tabletService.getAllTablets());
						List<Tablet> searchList= tabletService.searchBySeveralOptions(tsdto);
						
						if(searchList.isEmpty()) {
							request.getRequestDispatcher("/WEB-INF/view/not_found.jsp").forward(request, response);
						}else	request.getRequestDispatcher("/WEB-INF/view/tablet_found.jsp").forward(request, response);
						HttpSession session = request.getSession( true );
						session.setAttribute("list", searchList);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					
					
	}
	}

package com.vironit.store.controller.goods;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vironit.store.dao.db.DAOContext;
import com.vironit.store.entity.builder.TabletBuilder;
import com.vironit.store.entity.tablet.Tablet;
import com.vironit.store.exception.NoUniqueIdException;
import com.vironit.store.service.real.TabletServiceReal;


@WebServlet("/tablet_for_admin_addition")
public class TabletforAdminAddition extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TabletServiceReal tabletService = new TabletServiceReal();
   
    public TabletforAdminAddition() {
        super();
    }
    @Override
  	public void init() throws ServletException {
  		DAOContext.init( this.getServletContext() );
  	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id"); 										if(id==null) id="";
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
		request.getRequestDispatcher("/WEB-INF/view/tablet_addition.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/tablet_addition.jsp").forward(request, response);

		Boolean available;
		if(request.getParameter("available")==null) 	available=false; 				else available=true;
		Boolean bluetooth;
		if(request.getParameter("bluetooth")==null) 	bluetooth=false; 				else bluetooth=true;	
		Boolean keyboard;
		if(request.getParameter("keyboard")==null) 		keyboard=false; 				else keyboard=true;

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
		TabletBuilder tb = new TabletBuilder();
		Tablet added = tb.withID(id).withAvailable(available).withBackCamera(backCamera).withBluetooth(bluetooth).withBrand(brand).
				withCamera(camera).withColor(color).withCPU(cpu).withDiscount(discount).withDisplay(display).withFrontCamera(frontCamera).
				withKeyboard(keyboard).withMemory(memory).withOS(os).withPrice(price).withRam(ram).build();

		System.out.println("In the doPost");
		HttpSession session = request.getSession( true );

		session.setAttribute("added", added);

		System.out.println(added);
		try {
			tabletService.add(added);
		} catch (NoUniqueIdException | SQLException e) {
			e.printStackTrace();
		}

		}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

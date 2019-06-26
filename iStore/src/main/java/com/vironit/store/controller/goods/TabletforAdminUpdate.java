package com.vironit.store.controller.goods;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vironit.store.dao.db.DAOContext;
import com.vironit.store.service.real.TabletServiceReal;


@WebServlet("/tablet_for_admin_update")
public class TabletforAdminUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TabletServiceReal tabletService = new TabletServiceReal();


    public TabletforAdminUpdate() {
        super();
    }
    @Override
  	public void init() throws ServletException {
  		DAOContext.init( this.getServletContext() );
  	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("tabletId"));
		String price = request.getParameter("price"); if (price==null) price="0";
		String discount = request.getParameter("discount"); if (discount==null) discount="0" ;
		String available = request.getParameter("available"); if (available==null) available="true";
		HttpSession session =  request.getSession(true);
		session.setAttribute("tabletId", id);
		session.setAttribute("price", price);
		session.setAttribute("discount", discount);
		session.setAttribute("available", available);
		
	request.getRequestDispatcher("/WEB-INF/view/tablet_updateform.jsp").forward(request, response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession(true);
		Integer id = (Integer) session.getAttribute("tabletId");
		
		Integer price = Integer.parseInt(request.getParameter("price"));
		Integer discount = Integer.parseInt(request.getParameter("discount")); 
		Boolean available = Boolean.parseBoolean(request.getParameter("available")); 
		
	
		try {
			tabletService.updatePrice(id, price);
			tabletService.updateDiscount(id, discount);
			tabletService.updateAvailable(id, available);
		} catch (Exception e) {
			e.printStackTrace();}
			response.sendRedirect("tablet_for_admin");	
		
	}

}

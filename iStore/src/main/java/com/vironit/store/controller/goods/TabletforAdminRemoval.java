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


@WebServlet("/tablet_for_admin_removal")
public class TabletforAdminRemoval extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TabletServiceReal tabletService = new TabletServiceReal();


    public TabletforAdminRemoval() {
        super();
    }
    @Override
  	public void init() throws ServletException {
  		DAOContext.init( this.getServletContext() );
  	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("tabletId"));  
		try {
			tabletService.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession(true);
		session.setAttribute("tabletId", id);
		response.sendRedirect("tablet_for_admin");	
	}


}

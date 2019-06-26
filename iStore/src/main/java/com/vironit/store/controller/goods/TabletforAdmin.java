package com.vironit.store.controller.goods;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vironit.store.dao.db.DAOContext;
import com.vironit.store.entity.tablet.Tablet;
import com.vironit.store.service.real.TabletServiceReal;


@WebServlet("/tablet_for_admin")
public class TabletforAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TabletServiceReal tabletService = new TabletServiceReal();
   
    public TabletforAdmin() {
        super();
    }
    @Override
  	public void init() throws ServletException {
  		DAOContext.init( this.getServletContext() );
  	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Tablet> allTablets = new ArrayList<>();
		try {
			allTablets=tabletService.getAllTablets();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession( true );
		session.setAttribute("allTablets", allTablets);
		request.getRequestDispatcher("/WEB-INF/view/tablet_management.jsp").forward(request, response);

	}





}

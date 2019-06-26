package com.vironit.store.listeners;

import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;


import java.util.logging.Level;
import java.util.logging.Logger;

@WebListener
public class MyRequestListener implements ServletRequestListener, ServletRequestAttributeListener {
	private static final Logger LOG = Logger.getLogger(MyRequestListener.class.getName());    
	
	public MyRequestListener() {
    }


    public void requestInitialized(ServletRequestEvent sre)  { 
    	HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
    	request.setAttribute("Beginning", System.currentTimeMillis());
    	LOG.log(Level.INFO, "*************************************************A request is beginning*********************************************");
    }
    
    public void requestDestroyed(ServletRequestEvent sre)  { 
    	HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
    	Long begin = (Long)request.getAttribute("Beginning");
    	LOG.log(Level.INFO, "**********************************************The request has demanded  {0} ******************************************", System.currentTimeMillis()-begin);
    }




}

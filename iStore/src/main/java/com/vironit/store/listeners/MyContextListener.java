package com.vironit.store.listeners;

import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@WebListener
public class MyContextListener implements ServletContextListener, ServletContextAttributeListener {
	private static final Logger LOG = LogManager.getLogger(MyContextListener.class.getName());
	public MyContextListener() {
    }


    public void contextInitialized(ServletContextEvent sce)  { 
    	LOG.trace("====================================The application is getting started======================================");
    }
	public void contextDestroyed(ServletContextEvent sce)  { 
	   LOG.trace("======================================The application has just finished======================================");
    }

}

package com.vironit.store.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import java.util.logging.Level;
import java.util.logging.Logger;


@WebListener
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener, HttpSessionActivationListener, HttpSessionBindingListener {
	private static final Logger LOG = Logger.getLogger(MySessionListener.class.getName());
	private int counter;
    public MySessionListener() {
    }


    public void sessionCreated(HttpSessionEvent se)  { 
    	counter++;
    	LOG.log( Level.INFO, "----------------------A session has been triggered---------------------------- - {0}", counter);
    }


    public void sessionDestroyed(HttpSessionEvent se)  { 
    	LOG.log( Level.INFO, "--------------------The session has been canceled-----------------------------");
    }


	
}

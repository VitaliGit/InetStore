package com.vironit.store.dao.db;

import javax.servlet.ServletContext;

public class DAOContext {
	
	protected static String dbURL;
	protected static String dbUser;
	protected static String dbPassword;
	
	public static void init( ServletContext context ) {
		try {
			Class.forName( context.getInitParameter( "JDBC_DRIVER" ) );
			dbURL = context.getInitParameter( "JDBC_URL" );
			dbUser = context.getInitParameter( "JDBC_USER" );
			dbPassword = context.getInitParameter( "JDBC_PASSWORD" );
			
		} catch( Exception exception ) {
			exception.printStackTrace();
			
		}
	}
	
	
	
}
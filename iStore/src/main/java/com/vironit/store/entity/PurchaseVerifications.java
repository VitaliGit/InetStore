package com.vironit.store.entity;

public class PurchaseVerifications {

	public static void main(String[] args) {

		PurchaseVerifications purchase = new PurchaseVerifications();
		String status=purchase.status();//ultimate result
		System.out.println(status);

	}
	private String status() { // whether a client has already paid the product
		if(payment(true)&&order(true)&&take(true)) {
			return "sold";
		}else if(payment(true)&&order(true)&&take(false)) {
			return "paid";
		}else if(payment(false)&&order(true)&&take(false)) {
			return "ordered";
		}else return "";
	}
	
	private  boolean payment(boolean paid) { // whether a client has already paid the product
		return false;
	}
	private  boolean order(boolean ordered) { // whether a client has already ordered the product
		return false;
	}
	private  boolean take(boolean taken) { // whether a client has already picked  the product up
		return false;
	}

}
/*
 CREATE TABLE t_purchase(
ID 		  		SERIAL  		 					PRIMARY KEY,
Good_id	 		INT 						 		NOT NULL REFERENCES t_categories(ID),
Cart_id		 	INT 					 			NOT NULL REFERENCES t_cart(ID),
User_id 	 	INT 								NOT NULL REFERENCES t_users(ID),
Created_date 	TIMESTAMP  WITHOUT TIME ZONE  		DEFAULT now(),
Updated_date    TIMESTAMP  WITHOUT TIME ZONE  		DEFAULT now(),
Date_cart 	 	TIMESTAMP  WITHOUT TIME ZONE  		DEFAULT now(),
Status 		 	VARCHAR(20)  			 			NOT NULL DEFAULT 'Sold'
); */
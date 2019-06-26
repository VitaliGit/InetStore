DROP DATABASE IF EXISTS inetstore ;
CREATE DATABASE inetstore;
\connect inetstore;
CREATE TYPE STATUS AS ENUM('UNCONFIRMED', 'PAID', 'COMPLETED');
CREATE TABLE users( 
Username	 	 	VARCHAR (20) 		 	 	 		PRIMARY KEY,
Password	 		VARCHAR (68) 				 		NOT NULL,
Enabled	 			SMALLINT					 		NOT NULL DEFAULT 1,
Connection_number  	INT    					 	 		NOT NULL DEFAULT 0,
Character 			VARCHAR (20)  						NOT NULL DEFAULT 'Pretty normal',
Phone_number	 	VARCHAR (20)	 					NOT NULL,
Created_date 		TIMESTAMP WITHOUT TIME ZONE  		DEFAULT now(),
Updated_date 		TIMESTAMP WITHOUT TIME ZONE  		DEFAULT now()
);

//INSERT INTO users  (Username, Password, Phone_number  VALUES ('Vitali', '{noop}007', '+375289155775');
//Authority_id 	 	INT NOT NULL  		 		   		REFERENCES authorities (ID),
SELECT * FROM users;

CREATE TABLE authorities( 
ID 	  		 		SERIAL  				  			PRIMARY KEY,
Username	  		VARCHAR  (20) 		  	  	 		REFERENCES    users   (Username)  ,
Authority	  		VARCHAR  (20)		 	 	 		NOT NULL  DEFAULT  'ROLE_REGULAR',
UNIQUE	 	   		(Username,   Authority)
);

//INSERT  INTO  authorities (Username, Authority)  VALUES  ('Vitali',  'ROLE_ADMIN');
SELECT * FROM authorities;

CREATE TABLE t_goods(
ID 	  				SERIAL  							PRIMARY KEY,
Created_date 		TIMESTAMP WITHOUT TIME ZONE  		DEFAULT now(),
Updated_date 		TIMESTAMP WITHOUT TIME ZONE  		DEFAULT now(),
Category 			VARCHAR (20) 						NOT NULL
);

INSERT  INTO t_goods (category) VALUES ( 'book');
INSERT  INTO t_goods (category) VALUES ('tablet');
INSERT  INTO t_goods (category) VALUES ('phone');
INSERT  INTO t_goods (category) VALUES ('laptop');

SELECT * FROM t_goods;

CREATE TABLE t_books(
ID 		 			SERIAL  							PRIMARY KEY						  ,
Is_present 			BOOLEAN  							NOT NULL DEFAULT TRUE,
Discount 			INT 								NOT NULL DEFAULT 0,
Price 				INT 								NOT NULL,
Title 				VARCHAR(30) 						NOT NULL,
Author 				VARCHAR(20) 						NOT NULL,
Age_group 			VARCHAR(20)							NOT NULL DEFAULT 'All groups',
Genre 				VARCHAR(20) 						NOT NULL
);

SELECT * FROM t_books;

CREATE TABLE t_tablets(
ID 		  			SERIAL 	 							PRIMARY KEY  	,
Is_present  	    BOOLEAN  	 				 		NOT NULL DEFAULT TRUE,
Brand 		 		VARCHAR(20)   						NOT NULL DEFAULT 'Alcatel',
Price 		 		INT 		  						NOT NULL,
Discount 	 		INT 		  						NOT NULL DEFAULT 0,
Color 		 		VARCHAR(20)   						NOT NULL DEFAULT 'black',
Display_inch  		FLOAT(20)      						NOT NULL DEFAULT 7.0,
Ram_mb 		 		INT 		   						NOT NULL DEFAULT 512,
Memory_gb 	 		INT 		   						NOT NULL DEFAULT 8,
Camera_num 	 		INT 		   						NOT NULL DEFAULT 1,
Backcamera_mpx 		FLOAT 	  	 						NOT NULL DEFAULT 5.0,
Frontcamera_mpx  	FLOAT  								NOT NULL DEFAULT 1.0,
Cpu_ghz		 		FLOAT 		 						NOT NULL DEFAULT 1.0,
Os			 		VARCHAR(20)   						NOT NULL DEFAULT 'Android',
Bluetooth	 		BOOLEAN   	 						NOT NULL DEFAULT TRUE,
Keyboard 	 		BOOLEAN    							NOT NULL DEFAULT FALSE
);
INSERT INTO t_tablets VALUES (1, 2, true, 'Lenovo', 156, 0, 'Silver', 10.1, 512, 25, 2, 3.0, 1.0, 3.5, 'Android', true, false);
SELECT * FROM t_tablets;

CREATE TABLE t_phones(
ID 		   			SERIAL 		 		  				PRIMARY KEY   			,
Is_present 	 		BOOLEAN   							NOT NULL DEFAULT TRUE,
Brand 		 		VARCHAR(20)  						NOT NULL DEFAULT 'Samsung',
Price 		 		INT 		 						NOT NULL,
Discount 	 		INT 								NOT NULL DEFAULT 0,
Color 		 		VARCHAR(20) 						NOT NULL DEFAULT 'scarlet',
Display_inch  		FLOAT(10)   						NOT NULL DEFAULT 7.0,
Ram_mb 		 		INT 	 							NOT NULL DEFAULT 512,
Memory_gb 	 		INT 	 							NOT NULL DEFAULT 8,
Camera_num 	 		INT 	 							NOT NULL DEFAULT 1,
Backcamera_mpx 		FLOAT 	  							NOT NULL DEFAULT 5.0,
Frontcamera_mpx 	FLOAT  								NOT NULL DEFAULT 1.0,
Cpu_ghz		 		FLOAT 	 							NOT NULL DEFAULT 1.0,
Os			 		VARCHAR(20)	 						NOT NULL DEFAULT 'Android',
Bluetooth	 		BOOLEAN  							NOT NULL DEFAULT TRUE
);

SELECT * FROM t_phones;

CREATE TABLE t_laptops(
ID 		  			SERIAL 		 				  		PRIMARY KEY 		,
Is_present 	 		BOOLEAN  	 						NOT NULL DEFAULT TRUE,
Brand 		 		VARCHAR(20)  						NOT NULL DEFAULT 'HP',
Price 		 		INT 		 						NOT NULL,
Discount 	 		INT 								NOT NULL DEFAULT 0,
Color 		 		VARCHAR(20)  						NOT NULL DEFAULT 'silver',
Display_inch  		FLOAT(10)   						NOT NULL DEFAULT 7.0,
Ram_mb 		 		INT 	 							NOT NULL DEFAULT 512,
Memory_gb 	 		INT 		 						NOT NULL DEFAULT 8,
Camera_num 	 		INT 		 						NOT NULL DEFAULT 1,
Frontcamera_mpx 	FLOAT	 							NOT NULL DEFAULT 1.0,
Cpu_ghz		 		FLOAT 	 	 						NOT NULL DEFAULT 1.0,
Os			 		VARCHAR(10) 						NOT NULL DEFAULT 'Windows 10'
);


SELECT * FROM t_laptops;


CREATE TABLE t_cart(
ID 		   			SERIAL  						 	PRIMARY KEY,
User_name 	  		VARCHAR (20)  	 	 				NOT  NULL REFERENCES   users (Username),
Total_price		 	INT 							 	NOT  NULL,
Created_date  		TIMESTAMP  WITHOUT  TIME ZONE  	  	DEFAULT now(),
Updated_date  		TIMESTAMP  WITHOUT  TIME ZONE  	  	DEFAULT now(),
Order_date	 		TIMESTAMP  WITHOUT  TIME ZONE      	DEFAULT now(),
Status 			  	STATUS  						 	DEFAULT  'UNCONFIRMED'
);
SELECT * FROM t_cart;

CREATE TABLE t_order(
Cart_id		 		INT  								REFERENCES t_cart (ID),		
Book_id	  	 		INT 	 	  				   	 	REFERENCES t_books (ID),
Phone_id	  		INT 	 	  				   		REFERENCES t_phones (ID),
Laptop_id	    	INT 	 	  				   	 	REFERENCES t_laptops (ID),
Tablet_id  	 		INT 	 	  			 	   	 	REFERENCES t_tablets (ID),
PRIMARY KEY 		(Cart_id)

);
SELECT  * FROM t_order;



package com.vironit.store.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.vironit.store.entity.book.Book;
import com.vironit.store.entity.builder.BookBuilder;
import com.vironit.store.entity.builder.LaptopBuilder;
import com.vironit.store.entity.builder.PhoneBuilder;
import com.vironit.store.entity.builder.TabletBuilder;
import com.vironit.store.entity.laptop.Laptop;
import com.vironit.store.entity.phone.Phone;
import com.vironit.store.entity.tablet.Tablet;
import com.vironit.store.exception.NoUniqueIdException;
//import com.vironit.store.exception.SearchException;
import com.vironit.store.exception.WrongCategoryException;
import com.vironit.store.service.fake.BookServiceFake;
import com.vironit.store.service.fake.LaptopServiceFake;
import com.vironit.store.service.fake.PhoneServiceFake;
import com.vironit.store.service.fake.TabletServiceFake;

public class ControllerFake  {

	private static Logger logger = LogManager.getLogger(ControllerFake.class);
	private static BookServiceFake bs= new  BookServiceFake();
	private static BookBuilder bb= new  BookBuilder();
	
	private static LaptopServiceFake ls=new LaptopServiceFake(); 
	private static LaptopBuilder lb= new LaptopBuilder();
	
	private static PhoneServiceFake ps=new PhoneServiceFake(); 
	private static PhoneBuilder pb= new PhoneBuilder();
	
	private static TabletServiceFake ts=new TabletServiceFake(); 
	private static TabletBuilder tb= new TabletBuilder();

	
	private static Book dumas = bb.withID(1).withPrice(20).withAgeGroup("All groups").withAuthor("Alexandre Dumas").withAvailable(true).withGenre("Novel").withDiscount(85)
			.withTitle("Le comte de Monté-Cristo").build();
	private static Book hugo = bb.withID(2).withPrice(18).withAgeGroup("All groups").withAuthor("Victor Hugo").withAvailable(false).withGenre("Novel").withDiscount(85)
			.withTitle("Notre-Dame de Paris").build();
	private static Laptop philipsLaptop = lb.withID(2).withPrice(280).withAvailable(true).withBrand("Philips").withCamera(2).withColor("Black").withCPU(3.5f).withDiscount(0).
			withDisplay(10.1f).withFrontCamera(1.0f).withMemory(65).withOS("Windows 95").withRam(1024).build();
	private static Laptop lg = lb.withID(3).withPrice(115).withAvailable(true).withBrand("LG Electronics").withCamera(1).withColor("Black").withCPU(3.5f).withDiscount(5).
			withDisplay(10.1f).withFrontCamera(0.0f).withMemory(1515).withOS("Windows 10").withRam(512).build();
	private static Phone lenovo = pb.withID(1).withPrice(400).withAvailable(true).withBackCamera(13.0f).withBluetooth(true).withBrand("Lenovo").withCamera(2).withColor("Silver").
			withCPU(3.5f).withDiscount(0).withDisplay(10.1f).withFrontCamera(4.0f).withMemory(25).withOS("Android 8.0").withRam(2048).build();
	private static Phone philipsPhone = pb.withID(2).withPrice(280).withAvailable(true).withBackCamera(3.0f).withBluetooth(true).withBrand("Philips").withCamera(2).withColor("Black").
			withCPU(3.5f).withDiscount(0).withDisplay(10.1f).withFrontCamera(1.0f).withMemory(65).withOS("Android 8.0").withRam(1024).build();
	private static Tablet alcatel = tb.withID(2).withPrice(280).withAvailable(true).withBackCamera(3.0f).withBluetooth(true).withBrand("Lenovo").withCamera(2).withColor("Black").
	withCPU(3.5f).withDiscount(0).withDisplay(10.1f).withFrontCamera(1.0f).withKeyboard(true).withMemory(65).withOS("Windows 10").withRam(1024).build();
	private static Tablet samsung = tb.withID(4).withPrice(600).withAvailable(true).withBackCamera(8.0f).withBluetooth(true).withBrand("Samsung").withCamera(2).withColor("Yellow").
	withCPU(3.5f).withDiscount(0).withDisplay(10.1f).withFrontCamera(1.0f).withKeyboard(true).withMemory(250).withOS("Windows 10").withRam(2048).build();
	
 	
	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
		
		Scanner scan = new Scanner(System.in);
		
		logger.trace("=======================The application got started======================");
		System.out.println("Start");
		
		ExecutorService exc = Executors.newFixedThreadPool(3);
		Future <Integer> future = exc.submit(()->{
			System.out.println("How many categories are you interested in?");
			return scan.nextInt();
		});
		
		
		final int quantity = future.get();
		exc.shutdown();
		
		Scanner scan2 = new Scanner(System.in);
		System.out.println("What do you desire to observe");
		Thread thread2 = new Thread(()->{
			try {
				ts.add(alcatel);ts.add(samsung); ps.add(philipsPhone);ps.add(lenovo);bs.add(dumas);bs.add(hugo);ls.add(philipsLaptop);ls.add(lg);
			//	ts.updateDiscount(15, 1555);
				ps.searchByMemory(155);
				bs.searchByGenre("Novel");
				ls.searchByAvailable(false);
				int increment = 0;
				while(increment<quantity) {
				String response= scan2.nextLine();
				
				if(response.equalsIgnoreCase("tablet")) {
					ts.getAllTablets().forEach(System.out::println);
				}else if(response.equalsIgnoreCase("laptop")) {
					ls.getAllLaptops().forEach(System.out::println);
				}else if(response.equalsIgnoreCase("phone")) {
					ps.getAllPhones().forEach(System.out::println);
				}else if(response.equalsIgnoreCase("book")) {
					bs.getAllBooks().forEach(System.out::println);
				}else throw new WrongCategoryException();
				increment++;
				}
			//} catch (SearchException e) {
			//	e.printStackTrace();
			} catch ( NoUniqueIdException | WrongCategoryException e) {
				e.printStackTrace();
				logger.error("******************************Some error event********************************", e);
			}
		});
		
		
		thread2.start();
		thread2.join();
		
		
		
		scan.close();
		scan2.close();
		
		
		try(PrintWriter pw = new PrintWriter(new File ("C:/MyStoreLog.log"))){
			pw.write(alcatel.toString()+"\n");
			pw.write(samsung.toString()+"\n");
			pw.write(hugo.toString()+"\n");
			pw.write(dumas.toString()+"\n");
			pw.write(lenovo.toString()+"\n");
			pw.write(philipsPhone.toString()+"\n");
			pw.write(philipsLaptop.toString()+"\n");
			pw.write(lg.toString()+"\n");
		}
		
}

}
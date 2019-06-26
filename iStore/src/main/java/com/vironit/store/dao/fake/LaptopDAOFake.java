package com.vironit.store.dao.fake;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.vironit.store.dao.LaptopDAO;
import com.vironit.store.dto.LaptopSearchDTO;
import com.vironit.store.entity.builder.LaptopBuilder;
import com.vironit.store.entity.laptop.Laptop;
import com.vironit.store.exception.NoUniqueIdException;
import com.vironit.store.exception.SearchException;

public class LaptopDAOFake implements LaptopDAO{
	private static LaptopDAOFake laptopFake= new LaptopDAOFake();
	private static List<Laptop> laptopList = new ArrayList<>();
	
	public static void main(String[] args) throws NoUniqueIdException {
		
		LaptopBuilder lb= new LaptopBuilder();
		Laptop lenovo = lb.withID(1).withPrice(156).withAvailable(true).withBrand("Lenovo").withCamera(2).withColor("Silver").withCPU(3.5f).withDiscount(0).
		withDisplay(10.1f).withFrontCamera(1.0f).withMemory(25).withOS("Windows XP").withRam(512).build();
		Laptop philips = lb.withID(2).withPrice(280).withAvailable(true).withBrand("Philips").withCamera(2).withColor("Black").withCPU(3.5f).withDiscount(0).
		withDisplay(10.1f).withFrontCamera(1.0f).withMemory(65).withOS("Windows 95").withRam(1024).build();
		Laptop lg = lb.withID(3).withPrice(115).withAvailable(true).withBrand("LG Electronics").withCamera(1).withColor("Black").withCPU(3.5f).withDiscount(5).
		withDisplay(10.1f).withFrontCamera(0.0f).withMemory(1515).withOS("Windows 10").withRam(512).build();
		Laptop samsung = lb.withID(4).withPrice(600).withAvailable(true).withBrand("Samsung").withCamera(2).withColor("Dark Red").withCPU(3.5f).withDiscount(0).
		withDisplay(10.1f).withFrontCamera(1.0f).withMemory(1250).withOS("Windows 7").withRam(2048).build();
		
		laptopFake.add(samsung); laptopFake.add(lenovo); laptopFake.add(lg); laptopFake.add(philips);
		laptopFake.getAllLaptops().forEach(System.out::println);
		
	}
	
	@Override
	public List<Laptop> getAllLaptops(){
		return laptopList;
	}
	
	@Override
	public void add(Laptop laptop) throws NoUniqueIdException {
		if (laptopList.stream().anyMatch(x -> x.getId() == laptop.getId())) {
			throw new NoUniqueIdException();
		}
		laptopList.add(laptop);
	}

	@Override
	public void remove(int id) throws SearchException{
		Optional<Laptop> laptop = searchById(id);
		laptopList.remove(laptop.orElseThrow(SearchException::new)); 
	}


	@Override
	public Optional<Laptop> searchById(int id){
		return laptopList.stream().filter(laptop->laptop.getId()==id).findAny();
	}

	@Override
	public List<Laptop> searchByPrice(int price){
		return laptopList.stream().filter(laptop->price==laptop.getPrice()).collect(Collectors.toList());
	}

	@Override
	public List<Laptop> searchByAvailable(boolean available){
		return laptopList.stream().filter(laptop->available==laptop.isAvailable()).collect(Collectors.toList());
	}

	@Override
	public List<Laptop> searchByDiscount(int discount) {
		return laptopList.stream().filter(laptop->discount==laptop.getDiscount()).collect(Collectors.toList());
	}

	@Override
	public List<Laptop> searchByOs(String os) {
		return laptopList.stream().filter(laptop->os.equals(laptop.getOs())).collect(Collectors.toList());
}

	@Override
	public List<Laptop> searchByBrand(String brand){
		return laptopList.stream().filter(laptop->brand.equals(laptop.getBrand())).collect(Collectors.toList());
}

	@Override
	public List<Laptop> searchByColor(String color) {
		return laptopList.stream().filter(laptop->color.equals(laptop.getColor())).collect(Collectors.toList());
}

	@Override
	public List<Laptop> searchByDisplay(float display){
		return laptopList.stream().filter(laptop->display==laptop.getDisplay()).collect(Collectors.toList());
}

	@Override
	public List<Laptop> searchByRam(int ram) {
		return laptopList.stream().filter(laptop->ram==laptop.getRam()).collect(Collectors.toList());
}

	@Override
	public List<Laptop> searchByMemory(int memory) {
		return laptopList.stream().filter(laptop->memory==laptop.getMemory()).collect(Collectors.toList());
}

	@Override
	public List<Laptop> searchByCpu(float cpu) {
		return laptopList.stream().filter(laptop->cpu==laptop.getCpu()).collect(Collectors.toList());
}

	@Override
	public List<Laptop> searchByCamera(int camera) {
		return laptopList.stream().filter(laptop->camera==laptop.getCamera()).collect(Collectors.toList());
}
	@Override
	public List<Laptop> searchByFrontCamera(float frontCamera) {
		return laptopList.stream().filter(laptop->frontCamera==laptop.getFrontCamera()).collect(Collectors.toList());
}

	
	@Override
	public void updatePrice(int id, int price) throws SearchException {
		Optional<Laptop> laptop = searchById(id);
		laptop.orElseThrow(SearchException::new).setPrice(price);
	}

	@Override
	public void updateAvailable(int id, boolean available)  throws SearchException {
		Optional<Laptop> laptop = searchById(id);
		laptop.orElseThrow(SearchException::new).setAvailable(available);
	}

	@Override
	public void updateDiscount(int id, int discount)  throws SearchException {
		Optional<Laptop> laptop = searchById(id);
		laptop.orElseThrow(SearchException::new).setDiscount(discount);
	}

	@Override
	public void entireUpdate(Laptop laptop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Laptop> searchBySeveralOptions(LaptopSearchDTO allDto) {
		// TODO Auto-generated method stub
		return null;
	}



}

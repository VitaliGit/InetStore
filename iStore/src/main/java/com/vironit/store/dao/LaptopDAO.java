package com.vironit.store.dao;

import java.util.List;
import java.util.Optional;

import com.vironit.store.dto.LaptopSearchDTO;
import com.vironit.store.entity.laptop.Laptop;

public interface LaptopDAO {
	void add(Laptop laptop) throws Exception;
	void remove(int id) throws Exception;
	void entireUpdate(Laptop laptop);
	void updatePrice(int id, int price) throws Exception;
	void updateAvailable(int id, boolean available) throws Exception;
	void updateDiscount(int id, int discount)  throws Exception;
	List<Laptop> getAllLaptops();
		
	Optional<Laptop> searchById(int id);
	
	List<Laptop> searchByPrice(int price);
	List<Laptop> searchByAvailable(boolean available);
	List<Laptop> searchByDiscount(int discount);
	
	List<Laptop> searchByOs(String os);
	List<Laptop> searchByBrand(String brand);
	List<Laptop> searchByColor(String color);
	List<Laptop> searchByDisplay(float display);
	List<Laptop> searchByRam(int ram);
	List<Laptop> searchByMemory(int memory);
	List<Laptop> searchByCpu(float cpu);
	List<Laptop> searchByCamera(int camera);
	
	List<Laptop> searchByFrontCamera(float frontCamera);
	List<Laptop> searchBySeveralOptions(LaptopSearchDTO allDto);
	


}

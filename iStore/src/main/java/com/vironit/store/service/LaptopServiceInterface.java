package com.vironit.store.service;

import java.util.List;
import java.util.Optional;

import com.vironit.store.dto.LaptopSearchDTO;
import com.vironit.store.entity.laptop.Laptop;

public interface LaptopServiceInterface {
	void add(Laptop laptop) throws Exception;
	void remove(int id) throws Exception;
	void entireUpdate(Laptop laptop) throws Exception;
	void updatePrice(int id, int price) throws Exception;
	void updateAvailable(int id, boolean available) throws Exception;
	void updateDiscount(int id, int discount)  throws Exception;
	List<Laptop> getAllLaptops()throws Exception;
		
	Optional<Laptop> searchById(int id)throws Exception;
	List<Laptop> searchByPrice(int price)throws Exception;
	List<Laptop> searchByAvailable(boolean available)throws Exception;
	List<Laptop> searchByDiscount(int discount)throws Exception;
	
	List<Laptop> searchByOs(String os)throws Exception;
	List<Laptop> searchByBrand(String brand)throws Exception;
	List<Laptop> searchByColor(String color)throws Exception;
	List<Laptop> searchByDisplay(float display)throws Exception;
	List<Laptop> searchByRam(int ram)throws Exception;
	List<Laptop> searchByMemory(int memory)throws Exception;
	List<Laptop> searchByCpu(float cpu)throws Exception;
	List<Laptop> searchByCamera(int camera)throws Exception;
	
	List<Laptop> searchByFrontCamera(float frontCamera)throws Exception;
	List<Laptop> searchBySeveralOptions(LaptopSearchDTO allDto) throws Exception;
	
	
}

package com.vironit.store.dao;

import java.util.List;
import java.util.Optional;

import com.vironit.store.dto.PhoneSearchDTO;
import com.vironit.store.entity.phone.Phone;

public interface PhoneDAO {
	void add(Phone phone) throws Exception;
	void entireUpdate(Phone phone) throws Exception;
	void remove(int id)throws Exception;
	void updatePrice(int id, int price)throws Exception;
	void updateAvailable(int id, boolean available) throws Exception ;
	void updateDiscount(int id, int discount)  throws Exception;
	
	
	Optional<Phone> searchById(int id)throws Exception;
	List<Phone> searchByPrice(int price)throws Exception;
	List<Phone> searchByAvailable(boolean available)throws Exception;
	List<Phone> searchByDiscount(int discount)throws Exception;
	
	List<Phone> searchByOs(String os)throws Exception;
	List<Phone> searchByBrand(String brand)throws Exception;
	List<Phone> searchByColor(String color)throws Exception;
	List<Phone> searchByDisplay(float display)throws Exception;
	List<Phone> searchByRam(int ram)throws Exception;
	List<Phone> searchByMemory(int memory)throws Exception;
	List<Phone> searchByCpu(float cpu)throws Exception;
	List<Phone> searchByCamera(int camera)throws Exception;
	
	List<Phone> searchByFrontCamera(float frontCamera)throws Exception;
	List<Phone> searchByBackCamera(float backCamera)throws Exception;
	List<Phone> searchByBluetooth(boolean bluetooth)throws Exception;
	List<Phone> getAllPhones()throws Exception;
	List<Phone> searchBySeveralOptions(PhoneSearchDTO allDto)throws Exception;
	
	
	
	
	
}


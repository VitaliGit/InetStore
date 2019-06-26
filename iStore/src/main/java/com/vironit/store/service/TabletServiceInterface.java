package com.vironit.store.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.vironit.store.dto.TabletSearchDTO;
import com.vironit.store.entity.tablet.Tablet;

public interface TabletServiceInterface {
	void add(Tablet tablet)throws Exception;
	void remove(int id) throws Exception;
	
	void updatePrice(int id, int price) throws Exception;
	void updateAvailable(int id, boolean available)  throws Exception;
	void updateDiscount(int id, int discount)  throws Exception;
	
	Optional<Tablet> searchById(int id)  throws Exception;
	List<Tablet>  getAllTablets()  throws Exception;
	
	List<Tablet> searchByPrice(int price)  throws Exception;
	List<Tablet> searchByAvailable(boolean available)  throws Exception;
	List<Tablet> searchByDiscount(int discount)  throws Exception;
	
	List<Tablet> searchByOs(String os)  throws Exception;
	List<Tablet> searchByBrand(String brand)  throws Exception;
	List<Tablet> searchByColor(String color)  throws Exception;
	List<Tablet> searchByDisplay(float display)  throws Exception;
	List<Tablet> searchByRam(int ram)  throws Exception;
	List<Tablet> searchByMemory(int memory)  throws Exception;
	List<Tablet> searchByCpu(float cpu)  throws Exception;
	List<Tablet> searchByCamera(int camera)  throws Exception;
	
	List<Tablet> searchByFrontCamera(float frontCamera)  throws Exception;
	List<Tablet> searchByBackCamera(float backCamera)  throws Exception;
	List<Tablet> searchByBluetooth(boolean bluetooth)  throws Exception;
	List<Tablet> searchByKeyboard(boolean keyboard)  throws Exception;
	List<Tablet> searchBySeveralOptions(TabletSearchDTO allDto) throws SQLException;
	
}

package com.vironit.store.service.fake;

import java.util.List;
import java.util.Optional;

import com.vironit.store.dao.fake.LaptopDAOFake;
import com.vironit.store.dto.LaptopSearchDTO;
import com.vironit.store.entity.laptop.Laptop;
import com.vironit.store.exception.NoUniqueIdException;
import com.vironit.store.exception.SearchException;
import com.vironit.store.service.LaptopServiceInterface;

public class LaptopServiceFake implements LaptopServiceInterface{
	LaptopDAOFake laptopAccess;

	public LaptopServiceFake() {
		laptopAccess = new LaptopDAOFake();
	}
	@Override
	public void add(Laptop laptop) throws NoUniqueIdException {
		laptopAccess.add(laptop);
	}
	@Override
	public void remove(int id) throws SearchException {
		laptopAccess.remove(id);
	}
	@Override
	public void updatePrice(int id, int price) throws SearchException {
		laptopAccess.updatePrice(id, price);
	}
	@Override
	public void updateAvailable(int id, boolean available) throws SearchException {
		laptopAccess.updateAvailable(id, available);
	}
	@Override
	public void updateDiscount(int id, int discount) throws SearchException {
		laptopAccess.updateDiscount(id, discount) ;
	}
	@Override
	public Optional<Laptop> searchById(int id) {
		return laptopAccess.searchById(id) ;
	}

	@Override
	public List<Laptop> searchByPrice(int price) {
		return laptopAccess.searchByPrice(price);
	}

	@Override
	public List<Laptop> searchByAvailable(boolean available) {
		return laptopAccess.searchByAvailable(available);
	}

	@Override
	public List<Laptop> searchByDiscount(int discount) {
		return laptopAccess.searchByDiscount(discount);
	}

	@Override
	public List<Laptop> searchByOs(String os) {
		return laptopAccess.searchByOs(os);
	}

	@Override
	public List<Laptop> searchByBrand(String brand) {
		return laptopAccess.searchByBrand(brand);
	}

	@Override
	public List<Laptop> searchByColor(String color) {
		return laptopAccess.searchByColor(color);
	}

	@Override
	public List<Laptop> searchByDisplay(float display) {
		return laptopAccess.searchByDisplay(display);
	}

	@Override
	public List<Laptop> searchByRam(int ram) {
		return laptopAccess.searchByRam(ram);
	}

	@Override
	public List<Laptop> searchByMemory(int memory) {
		return laptopAccess.searchByMemory(memory);
	}

	@Override
	public List<Laptop> searchByCpu(float cpu) {
		return laptopAccess.searchByCpu(cpu);
	}

	@Override
	public List<Laptop> searchByCamera(int camera) {
		return laptopAccess.searchByCamera(camera);
	}

	@Override
	public List<Laptop> searchByFrontCamera(float frontCamera) {
		return laptopAccess.searchByFrontCamera(frontCamera);
	}
	@Override
	public List<Laptop> getAllLaptops() {
		return laptopAccess.getAllLaptops();
	}
	@Override
	public void entireUpdate(Laptop laptop) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Laptop> searchBySeveralOptions(LaptopSearchDTO allDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	}

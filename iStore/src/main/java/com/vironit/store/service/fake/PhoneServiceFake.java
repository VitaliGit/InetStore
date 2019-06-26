package com.vironit.store.service.fake;

import java.util.List;
import java.util.Optional;

import com.vironit.store.dao.fake.PhoneDAOFake;
import com.vironit.store.dto.PhoneSearchDTO;
import com.vironit.store.entity.phone.Phone;
import com.vironit.store.exception.NoUniqueIdException;
import com.vironit.store.exception.SearchException;
import com.vironit.store.service.PhoneServiceInterface;

public class PhoneServiceFake implements  PhoneServiceInterface{
	PhoneDAOFake phoneAccess;
	public PhoneServiceFake() {
		phoneAccess = new PhoneDAOFake();
	}
	@Override
	public void add(Phone phone) throws NoUniqueIdException {
		phoneAccess.add(phone);
	}
	@Override
	public void remove(int id) throws SearchException {
		phoneAccess.remove(id);
	}
	@Override
	public void updatePrice(int id, int price) throws SearchException {
		phoneAccess.updatePrice(id, price);
	}
	@Override
	public void updateAvailable(int id, boolean available) throws SearchException {
		phoneAccess.updateAvailable(id, available);
	}
	@Override
	public void updateDiscount(int id, int discount) throws SearchException {
		phoneAccess.updateDiscount(id, discount) ;
	}
	@Override
	public Optional<Phone> searchById(int id){
		return phoneAccess.searchById(id) ;
	}

	@Override
	public List<Phone> searchByPrice(int price){
		return phoneAccess.searchByPrice(price);
	}

	@Override
	public List<Phone> searchByAvailable(boolean available) {
		return phoneAccess.searchByAvailable(available);
	}

	@Override
	public List<Phone> searchByDiscount(int discount){
		return phoneAccess.searchByDiscount(discount);
	}

	@Override
	public List<Phone> searchByOs(String os){
		return phoneAccess.searchByOs(os);
	}

	@Override
	public List<Phone> searchByBrand(String brand){
		return phoneAccess.searchByBrand(brand);
	}

	@Override
	public List<Phone> searchByColor(String color){
		return phoneAccess.searchByColor(color);
	}

	@Override
	public List<Phone> searchByDisplay(float display){
		return phoneAccess.searchByDisplay(display);
	}

	@Override
	public List<Phone> searchByRam(int ram){
		return phoneAccess.searchByRam(ram);
	}

	@Override
	public List<Phone> searchByMemory(int memory){
		return phoneAccess.searchByMemory(memory);
	}

	@Override
	public List<Phone> searchByCpu(float cpu){
		return phoneAccess.searchByCpu(cpu);
	}

	@Override
	public List<Phone> searchByCamera(int camera){
		return phoneAccess.searchByCamera(camera);
	}

	@Override
	public List<Phone> searchByFrontCamera(float frontCamera){
		return phoneAccess.searchByFrontCamera(frontCamera);
	}

	@Override
	public List<Phone> searchByBackCamera(float backCamera){
		return phoneAccess.searchByBackCamera(backCamera);
	}

	@Override
	public List<Phone> searchByBluetooth(boolean bluetooth){
		return phoneAccess.searchByBluetooth(bluetooth);
	}
	@Override
	public List<Phone> getAllPhones() {
		return phoneAccess.getAllPhones();
	}

	@Override
	public List<Phone> searchBySeveralOptions(PhoneSearchDTO allDto) throws Exception {
		return null;
	}
	@Override
	public void entireUpdate(Phone phone) throws Exception {
		
	}

}

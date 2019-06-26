package com.vironit.store.dao.fake;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.vironit.store.dao.PhoneDAO;
import com.vironit.store.dto.PhoneSearchDTO;
import com.vironit.store.entity.builder.PhoneBuilder;
import com.vironit.store.entity.phone.Phone;
import com.vironit.store.exception.NoUniqueIdException;
import com.vironit.store.exception.SearchException;

public class PhoneDAOFake implements PhoneDAO {
	private static PhoneDAOFake phoneFake= new PhoneDAOFake();
	private static List<Phone> phoneList = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		PhoneBuilder pb= new PhoneBuilder();
		Phone lenovo = pb.withID(1).withPrice(400).withAvailable(true).withBackCamera(13.0f).withBluetooth(true).withBrand("Lenovo").withCamera(2).withColor("Silver").
				withCPU(3.5f).withDiscount(0).withDisplay(10.1f).withFrontCamera(4.0f).withMemory(25).withOS("Android 8.0").withRam(2048).build();
		Phone philips = pb.withID(2).withPrice(280).withAvailable(true).withBackCamera(3.0f).withBluetooth(true).withBrand("Philips").withCamera(2).withColor("Black").
				withCPU(3.5f).withDiscount(0).withDisplay(10.1f).withFrontCamera(1.0f).withMemory(65).withOS("Android 8.0").withRam(1024).build();
		Phone lg = pb.withID(3).withPrice(115).withAvailable(true).withBackCamera(3.0f).withBluetooth(true).withBrand("LG Electronics").withCamera(1).withColor("Black").
		withCPU(3.5f).withDiscount(5).withDisplay(10.1f).withFrontCamera(0.0f).withMemory(1515).withOS("Android 6.0").withRam(512).build();
		Phone samsung = pb.withID(4).withPrice(600).withAvailable(true).withBackCamera(8.0f).withBluetooth(true).withBrand("Samsung").withCamera(2).withColor("Dark Red").
		withCPU(3.5f).withDiscount(0).withDisplay(10.1f).withFrontCamera(1.0f).withMemory(1250).withOS("Android 8.0").withRam(2048).build();
		
		phoneFake.add(samsung);phoneFake.add(lenovo);phoneFake.add(lg);phoneFake.add(philips);
		phoneFake.getAllPhones().forEach(System.out::println);
	}
	
	@Override
	public List<Phone> getAllPhones(){
		return phoneList;
	}
	
	@Override
	public void add(Phone phone) throws NoUniqueIdException {
		if (phoneList.stream().anyMatch(x -> x.getId() == phone.getId())) {
			throw new NoUniqueIdException();
		}
		phoneList.add(phone);
	}

	@Override
	public void remove(int id) throws SearchException{
		Optional<Phone> phone = searchById(id);
		phoneList.remove(phone.orElseThrow(SearchException::new)); 
	}


	@Override
	public Optional<Phone> searchById(int id){
		return phoneList.stream().filter(phone->phone.getId()==id).findAny();
	}

	@Override
	public List<Phone> searchByPrice(int price){
		return phoneList.stream().filter(phone->price==phone.getPrice()).collect(Collectors.toList());
	}

	@Override
	public List<Phone> searchByAvailable(boolean available){
		return phoneList.stream().filter(phone->available==phone.isAvailable()).collect(Collectors.toList());
	}

	@Override
	public List<Phone> searchByDiscount(int discount) {
		return phoneList.stream().filter(phone->discount==phone.getDiscount()).collect(Collectors.toList());
	}

	@Override
	public List<Phone> searchByOs(String os) {
		return phoneList.stream().filter(phone->os.equals(phone.getOs())).collect(Collectors.toList());
}

	@Override
	public List<Phone> searchByBrand(String brand){
		return phoneList.stream().filter(phone->brand.equals(phone.getBrand())).collect(Collectors.toList());
}

	@Override
	public List<Phone> searchByColor(String color) {
		return phoneList.stream().filter(phone->color.equals(phone.getColor())).collect(Collectors.toList());
}

	@Override
	public List<Phone> searchByDisplay(float display){
		return phoneList.stream().filter(phone->display==phone.getDisplay()).collect(Collectors.toList());
}

	@Override
	public List<Phone> searchByRam(int ram) {
		return phoneList.stream().filter(phone->ram==phone.getRam()).collect(Collectors.toList());
}

	@Override
	public List<Phone> searchByMemory(int memory) {
		return phoneList.stream().filter(phone->memory==phone.getMemory()).collect(Collectors.toList());
}

	@Override
	public List<Phone> searchByCpu(float cpu) {
		return phoneList.stream().filter(phone->cpu==phone.getCpu()).collect(Collectors.toList());
}

	@Override
	public List<Phone> searchByCamera(int camera) {
		return phoneList.stream().filter(phone->camera==phone.getCamera()).collect(Collectors.toList());
}
	@Override
	public List<Phone> searchByFrontCamera(float frontCamera) {
		return phoneList.stream().filter(phone->frontCamera==phone.getFrontCamera()).collect(Collectors.toList());
}

	@Override
	public List<Phone> searchByBackCamera(float backCamera) {
		return phoneList.stream().filter(phone->backCamera==phone.getBackCamera()).collect(Collectors.toList());
}

	@Override
	public List<Phone> searchByBluetooth(boolean bluetooth) {
		return phoneList.stream().filter(phone->bluetooth==phone.isBluetooth()).collect(Collectors.toList());
}
	@Override
	public void updatePrice(int id, int price) throws SearchException{
		Optional<Phone> phone = searchById(id);
		phone.orElseThrow(SearchException::new).setPrice(price);
	}

	@Override
	public void updateAvailable(int id, boolean available) throws SearchException{
		Optional<Phone> phone = searchById(id);
		phone.orElseThrow(SearchException::new).setAvailable(available);
	}

	@Override
	public void updateDiscount(int id, int discount) throws SearchException{
		Optional<Phone> phone = searchById(id);
		phone.orElseThrow(SearchException::new).setDiscount(discount);
	}


	@Override
	public List<Phone> searchBySeveralOptions(PhoneSearchDTO allDto) throws Exception {
		return null;
	}

	@Override
	public void entireUpdate(Phone phone) throws Exception {
	
	}
}

package com.vironit.store.service.real;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vironit.store.dao.PhoneDAO;
import com.vironit.store.dao.real.PhoneDAOReal;
import com.vironit.store.dto.PhoneSearchDTO;
import com.vironit.store.entity.phone.Phone;
import com.vironit.store.service.PhoneServiceInterface;

@Service
public class PhoneServiceReal implements PhoneServiceInterface {
		
		@Autowired
		private PhoneDAO phoneAccess;
		
		public PhoneServiceReal() {
			phoneAccess = new PhoneDAOReal();
		}
		@Override
		@Transactional
		public	List<Phone>  getAllPhones() throws Exception {
			return phoneAccess.getAllPhones();
		}
		@Override
		@Transactional
		public void add(Phone phone) throws Exception  {
			phoneAccess.add(phone);
		}
		@Override
		public void entireUpdate(Phone phone) throws Exception {
			phoneAccess.entireUpdate(phone);	
		}
		@Override
		@Transactional
		public void remove(int id) throws Exception {
			phoneAccess.remove(id);
		}
		@Override
		@Transactional
		public void updatePrice(int id, int price) throws Exception {
			phoneAccess.updatePrice(id, price);
		}
		@Override
		@Transactional
		public void updateAvailable(int id, boolean available) throws Exception {
			phoneAccess.updateAvailable(id, available);
		}
		@Override
		@Transactional
		public void updateDiscount(int id, int discount) throws Exception {
			phoneAccess.updateDiscount(id, discount) ;
		}
		@Override
		@Transactional
		public Optional<Phone> searchById(int id) throws Exception {
			return phoneAccess.searchById(id) ;
		}

		@Override
		@Transactional
		public List<Phone> searchByPrice(int price) throws Exception {
			return phoneAccess.searchByPrice(price);
		}

		@Override
		@Transactional
		public List<Phone> searchByAvailable(boolean available) throws Exception {
			return phoneAccess.searchByAvailable(available);
		}

		@Override
		@Transactional
		public List<Phone> searchByDiscount(int discount) throws Exception {
			return phoneAccess.searchByDiscount(discount);
		}

		@Override
		@Transactional
		public List<Phone> searchByOs(String os) throws Exception {
			return phoneAccess.searchByOs(os);
		}

		@Override
		@Transactional
		public List<Phone> searchByBrand(String brand) throws Exception {
			return phoneAccess.searchByBrand(brand);
		}

		@Override
		@Transactional
		public List<Phone> searchByColor(String color) throws Exception {
			return phoneAccess.searchByColor(color);
		}

		@Override
		@Transactional
		public List<Phone> searchByDisplay(float display) throws Exception {
			return phoneAccess.searchByDisplay(display);
		}

		@Override
		@Transactional
		public List<Phone> searchByRam(int ram) throws Exception {
			return phoneAccess.searchByRam(ram);
		}

		@Override
		@Transactional
		public List<Phone> searchByMemory(int memory) throws Exception {
			return phoneAccess.searchByMemory(memory);
		}

		@Override
		@Transactional
		public List<Phone> searchByCpu(float cpu) throws Exception {
			return phoneAccess.searchByCpu(cpu);
		}

		@Override
		@Transactional
		public List<Phone> searchByCamera(int camera) throws Exception {
			return phoneAccess.searchByCamera(camera);
		}

		@Override
		@Transactional
		public List<Phone> searchByFrontCamera(float frontCamera) throws Exception {
			return phoneAccess.searchByFrontCamera(frontCamera);
		}

		@Override
		@Transactional
		public List<Phone> searchByBackCamera(float backCamera) throws Exception {
			return phoneAccess.searchByBackCamera(backCamera);
		}

		@Override
		@Transactional
		public List<Phone> searchByBluetooth(boolean bluetooth) throws Exception {
			return phoneAccess.searchByBluetooth(bluetooth);
		}

		@Override
		@Transactional
		public List<Phone> searchBySeveralOptions(PhoneSearchDTO allDto) throws Exception{
			return phoneAccess.searchBySeveralOptions(allDto);
		}
		
}
package com.vironit.store.service.real;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vironit.store.dao.LaptopDAO;
import com.vironit.store.dao.real.LaptopDAOReal;
import com.vironit.store.dto.LaptopSearchDTO;
import com.vironit.store.entity.laptop.Laptop;
import com.vironit.store.service.LaptopServiceInterface;

@Service
public class LaptopServiceReal implements LaptopServiceInterface {
		
		@Autowired
		private LaptopDAO laptopAccess;
		
		public LaptopServiceReal() {
			laptopAccess = new LaptopDAOReal();
		}
		@Override
		@Transactional
		public	List<Laptop>  getAllLaptops() throws Exception {
			return laptopAccess.getAllLaptops();
		}
		@Override
		@Transactional
		public void add(Laptop laptop) throws Exception  {
			laptopAccess.add(laptop);
		}
		@Override
		public void entireUpdate(Laptop laptop) throws Exception {
			laptopAccess.entireUpdate(laptop);	
		}
		@Override
		@Transactional
		public void remove(int id) throws Exception {
			laptopAccess.remove(id);
		}
		@Override
		@Transactional
		public void updatePrice(int id, int price) throws Exception {
			laptopAccess.updatePrice(id, price);
		}
		@Override
		@Transactional
		public void updateAvailable(int id, boolean available) throws Exception {
			laptopAccess.updateAvailable(id, available);
		}
		@Override
		@Transactional
		public void updateDiscount(int id, int discount) throws Exception {
			laptopAccess.updateDiscount(id, discount) ;
		}
		@Override
		@Transactional
		public Optional<Laptop> searchById(int id) throws Exception {
			return laptopAccess.searchById(id) ;
		}

		@Override
		@Transactional
		public List<Laptop> searchByPrice(int price) throws Exception {
			return laptopAccess.searchByPrice(price);
		}

		@Override
		@Transactional
		public List<Laptop> searchByAvailable(boolean available) throws Exception {
			return laptopAccess.searchByAvailable(available);
		}

		@Override
		@Transactional
		public List<Laptop> searchByDiscount(int discount) throws Exception {
			return laptopAccess.searchByDiscount(discount);
		}

		@Override
		@Transactional
		public List<Laptop> searchByOs(String os) throws Exception {
			return laptopAccess.searchByOs(os);
		}

		@Override
		@Transactional
		public List<Laptop> searchByBrand(String brand) throws Exception {
			return laptopAccess.searchByBrand(brand);
		}

		@Override
		@Transactional
		public List<Laptop> searchByColor(String color) throws Exception {
			return laptopAccess.searchByColor(color);
		}

		@Override
		@Transactional
		public List<Laptop> searchByDisplay(float display) throws Exception {
			return laptopAccess.searchByDisplay(display);
		}

		@Override
		@Transactional
		public List<Laptop> searchByRam(int ram) throws Exception {
			return laptopAccess.searchByRam(ram);
		}

		@Override
		@Transactional
		public List<Laptop> searchByMemory(int memory) throws Exception {
			return laptopAccess.searchByMemory(memory);
		}

		@Override
		@Transactional
		public List<Laptop> searchByCpu(float cpu) throws Exception {
			return laptopAccess.searchByCpu(cpu);
		}

		@Override
		@Transactional
		public List<Laptop> searchByCamera(int camera) throws Exception {
			return laptopAccess.searchByCamera(camera);
		}

		@Override
		@Transactional
		public List<Laptop> searchByFrontCamera(float frontCamera) throws Exception {
			return laptopAccess.searchByFrontCamera(frontCamera);
		}

		@Override
		@Transactional
		public List<Laptop> searchBySeveralOptions(LaptopSearchDTO allDto) throws Exception{
			return laptopAccess.searchBySeveralOptions(allDto);
		}
		
}
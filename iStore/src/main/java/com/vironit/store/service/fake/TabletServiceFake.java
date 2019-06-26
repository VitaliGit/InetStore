package com.vironit.store.service.fake;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.vironit.store.dao.fake.TabletDAOFake;
import com.vironit.store.dto.TabletSearchDTO;
import com.vironit.store.entity.tablet.Tablet;
import com.vironit.store.exception.NoUniqueIdException;
import com.vironit.store.exception.SearchException;
import com.vironit.store.service.TabletServiceInterface;

public class TabletServiceFake implements TabletServiceInterface{
	TabletDAOFake tabletAccess = new TabletDAOFake();
	
	public TabletServiceFake() {
		tabletAccess = new TabletDAOFake();
		}
	@Override
	public	List<Tablet>  getAllTablets(){
		return tabletAccess.getAllTablets();
	}
	@Override
	public void add(Tablet tablet) throws NoUniqueIdException  {
		tabletAccess.add(tablet);
	}
	@Override
	public void remove(int id) throws SearchException {
		tabletAccess.remove(id);
	}
	@Override
	public void updatePrice(int id, int price) throws SearchException {
		tabletAccess.updatePrice(id, price);
	}
	@Override
	public void updateAvailable(int id, boolean available) throws SearchException {
		tabletAccess.updateAvailable(id, available);
	}
	@Override
	public void updateDiscount(int id, int discount) throws SearchException {
		tabletAccess.updateDiscount(id, discount) ;
	}
	@Override
	public Optional<Tablet> searchById(int id){
		return tabletAccess.searchById(id) ;
	}

	@Override
	public List<Tablet> searchByPrice(int price){
		return tabletAccess.searchByPrice(price);
	}

	@Override
	public List<Tablet> searchByAvailable(boolean available){
		return tabletAccess.searchByAvailable(available);
	}

	@Override
	public List<Tablet> searchByDiscount(int discount){
		return tabletAccess.searchByDiscount(discount);
	}

	@Override
	public List<Tablet> searchByOs(String os){
		return tabletAccess.searchByOs(os);
	}

	@Override
	public List<Tablet> searchByBrand(String brand){
		return tabletAccess.searchByBrand(brand);
	}

	@Override
	public List<Tablet> searchByColor(String color){
		return tabletAccess.searchByColor(color);
	}

	@Override
	public List<Tablet> searchByDisplay(float display){
		return tabletAccess.searchByDisplay(display);
	}

	@Override
	public List<Tablet> searchByRam(int ram){
		return tabletAccess.searchByRam(ram);
	}

	@Override
	public List<Tablet> searchByMemory(int memory){
		return tabletAccess.searchByMemory(memory);
	}

	@Override
	public List<Tablet> searchByCpu(float cpu){
		return tabletAccess.searchByCpu(cpu);
	}

	@Override
	public List<Tablet> searchByCamera(int camera){
		return tabletAccess.searchByCamera(camera);
	}

	@Override
	public List<Tablet> searchByFrontCamera(float frontCamera){
		return tabletAccess.searchByFrontCamera(frontCamera);
	}

	@Override
	public List<Tablet> searchByBackCamera(float backCamera){
		return tabletAccess.searchByBackCamera(backCamera);
	}

	@Override
	public List<Tablet> searchByBluetooth(boolean bluetooth){
		return tabletAccess.searchByBluetooth(bluetooth);
	}

	@Override
	public List<Tablet> searchByKeyboard(boolean keyboard){
		return tabletAccess.searchByKeyboard(keyboard);
	}

	@Override
	public List<Tablet> searchBySeveralOptions(TabletSearchDTO allDto) throws SQLException {
		return null;
	}
	


}

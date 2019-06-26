package com.vironit.store.service.real;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.vironit.store.dao.real.TabletDAOReal;
import com.vironit.store.dto.TabletSearchDTO;
import com.vironit.store.entity.tablet.Tablet;
import com.vironit.store.exception.NoUniqueIdException;
import com.vironit.store.service.TabletServiceInterface;

public class TabletServiceReal implements TabletServiceInterface {

		private TabletDAOReal tabletAccess;
		
		public TabletServiceReal() {
			tabletAccess = new TabletDAOReal();
			}
		@Override
		public	List<Tablet>  getAllTablets() throws SQLException{
			return tabletAccess.getAllTablets();
		}
		@Override
		public void add(Tablet tablet) throws NoUniqueIdException, SQLException  {
			tabletAccess.add(tablet);
		}
		@Override
		public void remove(int id) throws Exception {
			tabletAccess.remove(id);
		}
		@Override
		public void updatePrice(int id, int price) throws Exception {
			tabletAccess.updatePrice(id, price);
		}
		@Override
		public void updateAvailable(int id, boolean available) throws Exception {
			tabletAccess.updateAvailable(id, available);
		}
		@Override
		public void updateDiscount(int id, int discount) throws Exception {
			tabletAccess.updateDiscount(id, discount) ;
		}
		@Override
		public Optional<Tablet> searchById(int id) throws SQLException{
			return tabletAccess.searchById(id) ;
		}

		@Override
		public List<Tablet> searchByPrice(int price) throws SQLException{
			return tabletAccess.searchByPrice(price);
		}

		@Override
		public List<Tablet> searchByAvailable(boolean available) throws SQLException{
			return tabletAccess.searchByAvailable(available);
		}

		@Override
		public List<Tablet> searchByDiscount(int discount) throws SQLException{
			return tabletAccess.searchByDiscount(discount);
		}

		@Override
		public List<Tablet> searchByOs(String os) throws SQLException{
			return tabletAccess.searchByOs(os);
		}

		@Override
		public List<Tablet> searchByBrand(String brand) throws SQLException{
			return tabletAccess.searchByBrand(brand);
		}

		@Override
		public List<Tablet> searchByColor(String color) throws SQLException{
			return tabletAccess.searchByColor(color);
		}

		@Override
		public List<Tablet> searchByDisplay(float display) throws SQLException{
			return tabletAccess.searchByDisplay(display);
		}

		@Override
		public List<Tablet> searchByRam(int ram) throws SQLException{
			return tabletAccess.searchByRam(ram);
		}

		@Override
		public List<Tablet> searchByMemory(int memory) throws SQLException{
			return tabletAccess.searchByMemory(memory);
		}

		@Override
		public List<Tablet> searchByCpu(float cpu) throws SQLException{
			return tabletAccess.searchByCpu(cpu);
		}

		@Override
		public List<Tablet> searchByCamera(int camera) throws SQLException{
			return tabletAccess.searchByCamera(camera);
		}

		@Override
		public List<Tablet> searchByFrontCamera(float frontCamera) throws SQLException{
			return tabletAccess.searchByFrontCamera(frontCamera);
		}

		@Override
		public List<Tablet> searchByBackCamera(float backCamera) throws SQLException{
			return tabletAccess.searchByBackCamera(backCamera);
		}

		@Override
		public List<Tablet> searchByBluetooth(boolean bluetooth) throws SQLException{
			return tabletAccess.searchByBluetooth(bluetooth);
		}

		@Override
		public List<Tablet> searchByKeyboard(boolean keyboard) throws SQLException{
			return tabletAccess.searchByKeyboard(keyboard);
		}
		
		@Override
		public List<Tablet> searchBySeveralOptions(TabletSearchDTO allDto) throws SQLException{
			return tabletAccess.searchBySeveralOptions(allDto);
		}
}

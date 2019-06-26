package com.vironit.store.dao.real;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vironit.store.dao.LaptopDAO;
import com.vironit.store.dto.LaptopSearchDTO;
import com.vironit.store.entity.laptop.Laptop;
import com.vironit.store.exception.SearchException;

@Repository
public class LaptopDAOReal implements LaptopDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void add(Laptop laptop) {
		Session currentSession=sessionFactory.getCurrentSession();
		currentSession.save(laptop);
	}
	
	@Override
	@Transactional
	public void entireUpdate(Laptop laptop) {
		Session currentSession=sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(laptop);
	}

	@Override
	@Transactional
	public void remove(int id){
		Session currentSession=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("DELETE FROM Laptop l WHERE l.id =:id");
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();	
	}

	@Override
	@Transactional
	public void updatePrice(int id, int price) throws SearchException{
		Session currentSession=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("UPDATE Laptop SET price=:price WHERE id =:id");
		
		theQuery.setParameter("price", price);
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();	
	}

	@Override
	@Transactional
	public void updateAvailable(int id, boolean available) throws SearchException{
		Session currentSession=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("UPDATE Laptop SET available=:available WHERE id =:id");
		
		theQuery.setParameter("available", available);
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();
	}

	@Override
	@Transactional
	public void updateDiscount(int id, int discount) throws SearchException{
		Session currentSession=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("UPDATE Laptop SET discount=:discount WHERE id =:id");
		
		theQuery.setParameter("discount", discount);
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();
	}

	@Override
	@Transactional
	public Optional<Laptop> searchById(int id){
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Laptop> theQuery = currentSession.createQuery("FROM Laptop WHERE id=:id", Laptop.class);
		theQuery.setParameter("id", id);
		Optional<Laptop> opt = theQuery.getResultList().stream().filter(laptop->laptop.getId()==id).findAny();
		return opt;
	}

	

	@Override
	@Transactional
	public List<Laptop> searchByPrice(int price) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Laptop> theQuery = currentSession.createQuery("FROM Laptop l WHERE l.price <=:price", Laptop.class);
		theQuery.setParameter("price", price);
		List<Laptop> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Laptop> searchByAvailable(boolean available) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Laptop> theQuery = currentSession.createQuery("FROM Laptop l WHERE l.available =:available", Laptop.class);
		theQuery.setParameter("available", available);
		List<Laptop> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Laptop> searchByDiscount(int discount) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Laptop> theQuery = currentSession.createQuery("FROM Laptop l WHERE l.discount >=:discount", Laptop.class);
		theQuery.setParameter("discount", discount);
		List<Laptop> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Laptop> searchByOs(String os) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Laptop> theQuery = currentSession.createQuery("FROM Laptop l WHERE l.os =:os", Laptop.class);
		theQuery.setParameter("os", os);
		List<Laptop> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Laptop> searchByBrand(String brand) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Laptop> theQuery = currentSession.createQuery("FROM Laptop l WHERE l.brand =:brand", Laptop.class);
		theQuery.setParameter("brand", brand);
		List<Laptop> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Laptop> searchByColor(String color) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Laptop> theQuery = currentSession.createQuery("FROM Laptop l WHERE l.color =:color", Laptop.class);
		theQuery.setParameter("color", color);
		List<Laptop> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Laptop> searchByDisplay(float display) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Laptop> theQuery = currentSession.createQuery("FROM Laptop l WHERE l.display >=:display", Laptop.class);
		theQuery.setParameter("display", display);
		List<Laptop> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Laptop> searchByRam(int ram) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Laptop> theQuery = currentSession.createQuery("FROM Laptop l WHERE l.ram >=:ram", Laptop.class);
		theQuery.setParameter("ram", ram);
		List<Laptop> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Laptop> searchByMemory(int memory) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Laptop> theQuery = currentSession.createQuery("FROM Laptop l WHERE l.memory >=:memory", Laptop.class);
		theQuery.setParameter("memory", memory);
		List<Laptop> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Laptop> searchByCpu(float cpu) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Laptop> theQuery = currentSession.createQuery("FROM Laptop l WHERE l.cpu >=:cpu", Laptop.class);
		theQuery.setParameter("cpu", cpu);
		List<Laptop> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Laptop> searchByCamera(int camera) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Laptop> theQuery = currentSession.createQuery("FROM Laptop l WHERE l.camera >=:camera", Laptop.class);
		theQuery.setParameter("camera", camera);
		List<Laptop> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Laptop> searchByFrontCamera(float frontCamera) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Laptop> theQuery = currentSession.createQuery("FROM Laptop l WHERE l.frontCamera >=:frontCamera", Laptop.class);
		theQuery.setParameter("frontCamera", frontCamera);
		List<Laptop> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Laptop> getAllLaptops() {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Laptop> theQuery = currentSession.createQuery("FROM Laptop ORDER BY id ASC", Laptop.class);
		List<Laptop> list = theQuery.getResultList();
		return list;
	}
	@Override
	@Transactional
	public List<Laptop> searchBySeveralOptions(LaptopSearchDTO allDto){
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Laptop> theQuery = currentSession.createQuery("FROM Laptop l WHERE l.frontCamera >=:frontCamera AND l.camera >=:camera AND l.cpu >=:cpu AND l.memory >=:memory AND l.ram >=:ram AND l.display >=:display AND l.color =:color AND l.brand =:brand AND l.os=:os AND l.available =:available AND l.discount >=:discount AND l.price <=:price",  Laptop.class);
		theQuery.setParameter("frontCamera", allDto.getFrontCamera());
		theQuery.setParameter("camera", allDto.getCamera());
		theQuery.setParameter("cpu", allDto.getCpu());
		theQuery.setParameter("memory", allDto.getMemory());
		theQuery.setParameter("ram", allDto.getRam());
		theQuery.setParameter("display", allDto.getDisplay());
		theQuery.setParameter("color", allDto.getColor());
		theQuery.setParameter("brand", allDto.getBrand());
		theQuery.setParameter("os", allDto.getOs());
		theQuery.setParameter("available", allDto.isAvailable());
		theQuery.setParameter("discount", allDto.getDiscount());
		theQuery.setParameter("price", allDto.getPrice());

		List<Laptop> list = theQuery.getResultList();
		return list;
	}
}

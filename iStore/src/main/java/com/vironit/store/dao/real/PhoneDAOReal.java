package com.vironit.store.dao.real;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vironit.store.dao.PhoneDAO;
import com.vironit.store.dto.PhoneSearchDTO;
import com.vironit.store.entity.phone.Phone;
import com.vironit.store.exception.SearchException;

@Repository
public class PhoneDAOReal implements PhoneDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void add(Phone phone) {
		Session currentSession=sessionFactory.getCurrentSession();
		currentSession.save(phone);
	}
	@Override
	@Transactional
	public void entireUpdate(Phone phone) {
		Session currentSession=sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(phone);
	}
	@Override
	@Transactional
	public void remove(int id){
		Session currentSession=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("DELETE FROM Phone p WHERE p.id =:id");
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();	
	}

	@Override
	@Transactional
	public void updatePrice(int id, int price) throws SearchException{
		Session currentSession=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("UPDATE Phone SET price=:price WHERE id =:id");
		
		theQuery.setParameter("price", price);
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();	
	}

	@Override
	@Transactional
	public void updateAvailable(int id, boolean available) throws SearchException{
		Session currentSession=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("UPDATE Phone SET available=:available WHERE id =:id");
		
		theQuery.setParameter("available", available);
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();
	}

	@Override
	@Transactional
	public void updateDiscount(int id, int discount) throws SearchException{
		Session currentSession=sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("UPDATE Phone SET discount=:discount WHERE id =:id");
		
		theQuery.setParameter("discount", discount);
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();
	}

	@Override
	@Transactional
	public Optional<Phone> searchById(int id){
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Phone> theQuery = currentSession.createQuery("FROM Phone WHERE id=:id", Phone.class);
		theQuery.setParameter("id", id);
		Optional<Phone> opt = theQuery.getResultList().stream().filter(phone->phone.getId()==id).findAny();
		return opt;
	}

	

	@Override
	@Transactional
	public List<Phone> searchByPrice(int price) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Phone> theQuery = currentSession.createQuery("FROM Phone p WHERE p.price <=:price", Phone.class);
		theQuery.setParameter("price", price);
		List<Phone> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Phone> searchByAvailable(boolean available) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Phone> theQuery = currentSession.createQuery("FROM Phone p WHERE p.available =:available", Phone.class);
		theQuery.setParameter("available", available);
		List<Phone> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Phone> searchByDiscount(int discount) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Phone> theQuery = currentSession.createQuery("FROM Phone p WHERE p.discount >=:discount", Phone.class);
		theQuery.setParameter("discount", discount);
		List<Phone> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Phone> searchByOs(String os) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Phone> theQuery = currentSession.createQuery("FROM Phone p WHERE p.os =:os", Phone.class);
		theQuery.setParameter("os", os);
		List<Phone> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Phone> searchByBrand(String brand) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Phone> theQuery = currentSession.createQuery("FROM Phone p WHERE p.brand =:brand", Phone.class);
		theQuery.setParameter("brand", brand);
		List<Phone> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Phone> searchByColor(String color) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Phone> theQuery = currentSession.createQuery("FROM Phone p WHERE p.color =:color", Phone.class);
		theQuery.setParameter("color", color);
		List<Phone> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Phone> searchByDisplay(float display) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Phone> theQuery = currentSession.createQuery("FROM Phone p WHERE p.display >=:display", Phone.class);
		theQuery.setParameter("display", display);
		List<Phone> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Phone> searchByRam(int ram) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Phone> theQuery = currentSession.createQuery("FROM Phone p WHERE p.ram >=:ram", Phone.class);
		theQuery.setParameter("ram", ram);
		List<Phone> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Phone> searchByMemory(int memory) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Phone> theQuery = currentSession.createQuery("FROM Phone p WHERE p.memory >=:memory", Phone.class);
		theQuery.setParameter("memory", memory);
		List<Phone> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Phone> searchByCpu(float cpu) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Phone> theQuery = currentSession.createQuery("FROM Phone p WHERE p.cpu >=:cpu", Phone.class);
		theQuery.setParameter("cpu", cpu);
		List<Phone> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Phone> searchByCamera(int camera) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Phone> theQuery = currentSession.createQuery("FROM Phone p WHERE p.camera >=:camera", Phone.class);
		theQuery.setParameter("camera", camera);
		List<Phone> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Phone> searchByFrontCamera(float frontCamera) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Phone> theQuery = currentSession.createQuery("FROM Phone p WHERE p.frontCamera >=:frontCamera", Phone.class);
		theQuery.setParameter("frontCamera", frontCamera);
		List<Phone> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Phone> searchByBackCamera(float backCamera) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Phone> theQuery = currentSession.createQuery("FROM Phone p WHERE p.backCamera >=:backCamera", Phone.class);
		theQuery.setParameter("backCamera", backCamera);
		List<Phone> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Phone> searchByBluetooth(boolean bluetooth) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Phone> theQuery = currentSession.createQuery("FROM Phone p WHERE p.bluetooth =:bluetooth", Phone.class);
		theQuery.setParameter("bluetooth", bluetooth);
		List<Phone> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Phone> getAllPhones() {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Phone> theQuery = currentSession.createQuery("FROM Phone ORDER BY id ASC", Phone.class);
		List<Phone> list = theQuery.getResultList();
		return list;
	}
	@Override
	@Transactional
	public List<Phone> searchBySeveralOptions(PhoneSearchDTO allDto){
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Phone> theQuery = currentSession.createQuery("FROM Phone p WHERE p.bluetooth =:bluetooth AND p.backCamera >=:backCamera AND p.frontCamera >=:frontCamera AND p.camera >=:camera AND p.cpu >=:cpu AND p.memory >=:memory AND p.ram >=:ram AND p.display >=:display AND p.color =:color AND p.brand =:brand AND p.os=:os AND p.available =:available AND p.discount >=:discount AND p.price <=:price",  Phone.class);
		theQuery.setParameter("bluetooth", allDto.isBluetooth());
		theQuery.setParameter("backCamera", allDto.getBackCamera());
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

		List<Phone> list = theQuery.getResultList();
		return list;
	}
}

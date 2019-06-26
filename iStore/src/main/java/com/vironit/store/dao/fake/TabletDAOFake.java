package com.vironit.store.dao.fake;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.vironit.store.dao.TabletDAO;
import com.vironit.store.entity.builder.TabletBuilder;
import com.vironit.store.entity.tablet.Tablet;
import com.vironit.store.exception.NoUniqueIdException;
import com.vironit.store.exception.SearchException;

public class TabletDAOFake implements TabletDAO{
	private static TabletDAOFake tabletFake= new TabletDAOFake();
	private static List<Tablet> tabletList = new ArrayList<>();

	public static void main(String[] args)  throws Exception{
		
		TabletBuilder tb= new TabletBuilder();
		Tablet lenovo = tb.withID(1).withPrice(156).withAvailable(true).withBackCamera(3.0f).withBluetooth(true).withBrand("Lenovo").withCamera(2).withColor("Silver").
		withCPU(3.5f).withDiscount(0).withDisplay(10.1f).withFrontCamera(1.0f).withKeyboard(false).withMemory(25).withOS("Android").withRam(512).build();
		Tablet alcatel = tb.withID(2).withPrice(280).withAvailable(true).withBackCamera(3.0f).withBluetooth(true).withBrand("Lenovo").withCamera(2).withColor("Black").
		withCPU(3.5f).withDiscount(0).withDisplay(10.1f).withFrontCamera(1.0f).withKeyboard(true).withMemory(65).withOS("Windows 10").withRam(1024).build();
		Tablet lg = tb.withID(3).withPrice(115).withAvailable(true).withBackCamera(3.0f).withBluetooth(true).withBrand("LG Electronics").withCamera(1).withColor("Red").
		withCPU(3.5f).withDiscount(5).withDisplay(10.1f).withFrontCamera(0.0f).withKeyboard(false).withMemory(15).withOS("Android").withRam(512).build();
		Tablet samsung = tb.withID(4).withPrice(600).withAvailable(true).withBackCamera(8.0f).withBluetooth(true).withBrand("Samsung").withCamera(2).withColor("Yellow").
		withCPU(3.5f).withDiscount(0).withDisplay(10.1f).withFrontCamera(1.0f).withKeyboard(true).withMemory(250).withOS("Windows 10").withRam(2048).build();

		
		//tabletFake.add(lenovo);
		tabletFake.add(lenovo);
		tabletFake.add(alcatel);
		tabletFake.add(lg);
		//tabletFake.remove(1556178);
		//tabletFake.updateAvailable(184556, false);
		tabletFake.add(samsung);
		
		System.out.println(tabletFake.searchByAvailable(false));
		System.out.println(tabletFake.searchByBackCamera(1800.98568f));
		System.out.println(tabletFake.searchById(4541));
		tabletFake.getAllTablets().stream().forEach(System.out::println);
		//tabletList.stream().forEach(System.out::println);
		
	}
	@Override
	public List<Tablet> getAllTablets(){
		return tabletList;
	}

	@Override
	public void add(Tablet tablet) throws NoUniqueIdException {
		if (tabletList.stream().anyMatch(x -> x.getId() == tablet.getId())) {
			throw new NoUniqueIdException();
		}
		tabletList.add(tablet);
	}

	@Override
	public void remove(int id) throws SearchException {
		Optional<Tablet> tablet = searchById(id);
		tabletList.remove(tablet.orElseThrow(SearchException::new)); 
	}

	@Override
	public Optional<Tablet> searchById(int id){
		return tabletList.stream().filter(tablet->tablet.getId()==id).findAny();
	}

	@Override
	public List<Tablet> searchByPrice(int price){
		return tabletList.stream().filter(tablet->price==tablet.getPrice()).collect(Collectors.toList());
	}

	@Override
	public List<Tablet> searchByAvailable(boolean available){
		return tabletList.stream().filter(tablet->available==tablet.isAvailable()).collect(Collectors.toList());
	}

	@Override
	public List<Tablet> searchByDiscount(int discount) {
		return tabletList.stream().filter(tablet->discount==tablet.getDiscount()).collect(Collectors.toList());
	}

	@Override
	public List<Tablet> searchByOs(String os) {
		return tabletList.stream().filter(tablet->os.equals(tablet.getOs())).collect(Collectors.toList());
}

	@Override
	public List<Tablet> searchByBrand(String brand){
		return tabletList.stream().filter(tablet->brand.equals(tablet.getBrand())).collect(Collectors.toList());
}

	@Override
	public List<Tablet> searchByColor(String color) {
		return tabletList.stream().filter(tablet->color.equals(tablet.getColor())).collect(Collectors.toList());
}

	@Override
	public List<Tablet> searchByDisplay(float display){
		return tabletList.stream().filter(tablet->display==tablet.getDisplay()).collect(Collectors.toList());
}

	@Override
	public List<Tablet> searchByRam(int ram) {
		return tabletList.stream().filter(tablet->ram==tablet.getRam()).collect(Collectors.toList());
}

	@Override
	public List<Tablet> searchByMemory(int memory) {
		return tabletList.stream().filter(tablet->memory==tablet.getMemory()).collect(Collectors.toList());
}

	@Override
	public List<Tablet> searchByCpu(float cpu) {
		return tabletList.stream().filter(tablet->cpu==tablet.getCpu()).collect(Collectors.toList());
}

	@Override
	public List<Tablet> searchByCamera(int camera) {
		return tabletList.stream().filter(tablet->camera==tablet.getCamera()).collect(Collectors.toList());
}

	@Override
	public List<Tablet> searchByFrontCamera(float frontCamera) {
		return tabletList.stream().filter(tablet->frontCamera==tablet.getFrontCamera()).collect(Collectors.toList());
}

	@Override
	public List<Tablet> searchByBackCamera(float backCamera) {
		return tabletList.stream().filter(tablet->backCamera==tablet.getBackCamera()).collect(Collectors.toList());
}

	@Override
	public List<Tablet> searchByBluetooth(boolean bluetooth) {
		return tabletList.stream().filter(tablet->bluetooth==tablet.isBluetooth()).collect(Collectors.toList());
}

	@Override
	public List<Tablet> searchByKeyboard(boolean keyboard) {
		return tabletList.stream().filter(tablet->keyboard==tablet.isKeyboard()).collect(Collectors.toList());
}

	@Override
	public void updatePrice(int id, int price) throws SearchException {
		Optional<Tablet> tablet = searchById(id);
		tablet.orElseThrow(SearchException::new).setPrice(price);
	}

	@Override
	public void updateAvailable(int id, boolean available)  throws SearchException {
		Optional<Tablet> tablet = searchById(id);
		tablet.orElseThrow(SearchException::new).setAvailable(available);
	}

	@Override
	public void updateDiscount(int id, int discount)  throws SearchException {
		Optional<Tablet> tablet = searchById(id);
		tablet.orElseThrow(SearchException::new).setDiscount(discount);
	}


	}


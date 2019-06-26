package com.vironit.store.dto;


public class PhoneSearchDTOBuilder {
	private int price;
	private int discount;
	private boolean available;
	private boolean bluetooth;
	private String os;
	private String color;
	private float display;
	private String brand;
	private int ram;
	private int memory;
	private float cpu;
	private int camera;
	private float frontCamera;
	private float backCamera;
	
	public PhoneSearchDTO build() {
		PhoneSearchDTO phoneSearchDTO = new PhoneSearchDTO();
		phoneSearchDTO.setAvailable(available);
		phoneSearchDTO.setBackCamera(backCamera);
		phoneSearchDTO.setBluetooth(bluetooth);
		phoneSearchDTO.setBrand(brand);
		phoneSearchDTO.setCamera(camera);
		phoneSearchDTO.setColor(color);
		phoneSearchDTO.setCpu(cpu);
		phoneSearchDTO.setDiscount(discount);
		phoneSearchDTO.setDisplay(display);
		phoneSearchDTO.setFrontCamera(frontCamera);
		phoneSearchDTO.setMemory(memory);
		phoneSearchDTO.setOs(os);
		phoneSearchDTO.setPrice(price);
		phoneSearchDTO.setRam(ram);
		return phoneSearchDTO;
		
	}
	public PhoneSearchDTOBuilder withPrice(final int price) {
		this.price=price;
		return this;
	}
	public PhoneSearchDTOBuilder withDiscount(final int discount) {
		this.discount=discount;
		return this;
	}
	public PhoneSearchDTOBuilder withAvailable(final boolean available) {
		this.available=available;
		return this;
	}
	public PhoneSearchDTOBuilder withBluetooth(final boolean bluetooth) {
		this.bluetooth=bluetooth;
		return this;
	}
	
	public PhoneSearchDTOBuilder withOs(final String os) {
		this.os=os;
		return this;
	}
	public PhoneSearchDTOBuilder withColor(final String color) {
		this.color=color;
		return this;
	}
	public PhoneSearchDTOBuilder withDisplay(final float display) {
		this.display=display;
		return this;
	}
	public PhoneSearchDTOBuilder withBrand(final String brand) {
		this.brand=brand;
		return this;
	}
	public PhoneSearchDTOBuilder withRam(final int ram) {
		this.ram=ram;
		return this;
	}
	public PhoneSearchDTOBuilder withMemory(final int memory) {
		this.memory=memory;
		return this;
	}
	public PhoneSearchDTOBuilder withCpu(final float cpu) {
		this.cpu=cpu;
		return this;
	}
	public PhoneSearchDTOBuilder withCamera(final int camera) {
		this.camera=camera;
		return this;
	}
	public PhoneSearchDTOBuilder withFrontCamera(final float frontCamera) {
		this.frontCamera=frontCamera;
		return this;
	}
	public PhoneSearchDTOBuilder withBackCamera(final float backCamera) {
		this.backCamera=backCamera;
		return this;
	}
	
	
}

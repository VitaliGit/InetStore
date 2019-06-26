package com.vironit.store.dto;


public class TabletSearchDTOBuilder {
	private int price;
	private int discount;
	private boolean available;
	private boolean bluetooth;
	private boolean keyboard;
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
	
	public TabletSearchDTO build() {
		TabletSearchDTO tabletSearchDTO = new TabletSearchDTO();
		tabletSearchDTO.setAvailable(available);
		tabletSearchDTO.setBackCamera(backCamera);
		tabletSearchDTO.setBluetooth(bluetooth);
		tabletSearchDTO.setBrand(brand);
		tabletSearchDTO.setCamera(camera);
		tabletSearchDTO.setColor(color);
		tabletSearchDTO.setCpu(cpu);
		tabletSearchDTO.setDiscount(discount);
		tabletSearchDTO.setDisplay(display);
		tabletSearchDTO.setFrontCamera(frontCamera);
		tabletSearchDTO.setKeyboard(keyboard);
		tabletSearchDTO.setMemory(memory);
		tabletSearchDTO.setOs(os);
		tabletSearchDTO.setPrice(price);
		tabletSearchDTO.setRam(ram);
		return tabletSearchDTO;
		
	}
	public TabletSearchDTOBuilder withPrice(final int price) {
		this.price=price;
		return this;
	}
	public TabletSearchDTOBuilder withDiscount(final int discount) {
		this.discount=discount;
		return this;
	}
	public TabletSearchDTOBuilder withAvailable(final boolean available) {
		this.available=available;
		return this;
	}
	public TabletSearchDTOBuilder withBluetooth(final boolean bluetooth) {
		this.bluetooth=bluetooth;
		return this;
	}
	public TabletSearchDTOBuilder withKeyboard(final boolean keyboard) {
		this.keyboard=keyboard;
		return this;
	}
	public TabletSearchDTOBuilder withOs(final String os) {
		this.os=os;
		return this;
	}
	public TabletSearchDTOBuilder withColor(final String color) {
		this.color=color;
		return this;
	}
	public TabletSearchDTOBuilder withDisplay(final float display) {
		this.display=display;
		return this;
	}
	public TabletSearchDTOBuilder withBrand(final String brand) {
		this.brand=brand;
		return this;
	}
	public TabletSearchDTOBuilder withRam(final int ram) {
		this.ram=ram;
		return this;
	}
	public TabletSearchDTOBuilder withMemory(final int memory) {
		this.memory=memory;
		return this;
	}
	public TabletSearchDTOBuilder withCpu(final float cpu) {
		this.cpu=cpu;
		return this;
	}
	public TabletSearchDTOBuilder withCamera(final int camera) {
		this.camera=camera;
		return this;
	}
	public TabletSearchDTOBuilder withFrontCamera(final float frontCamera) {
		this.frontCamera=frontCamera;
		return this;
	}
	public TabletSearchDTOBuilder withBackCamera(final float backCamera) {
		this.backCamera=backCamera;
		return this;
	}
	
	
}

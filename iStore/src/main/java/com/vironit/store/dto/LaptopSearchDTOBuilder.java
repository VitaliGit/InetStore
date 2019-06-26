package com.vironit.store.dto;


public class LaptopSearchDTOBuilder {
	private int price;
	private int discount;
	private boolean available;
	private String os;
	private String color;
	private float display;
	private String brand;
	private int ram;
	private int memory;
	private float cpu;
	private int camera;
	private float frontCamera;
	
	public LaptopSearchDTO build() {
		LaptopSearchDTO laptopSearchDTO = new LaptopSearchDTO();
		laptopSearchDTO.setAvailable(available);
		laptopSearchDTO.setBrand(brand);
		laptopSearchDTO.setCamera(camera);
		laptopSearchDTO.setColor(color);
		laptopSearchDTO.setCpu(cpu);
		laptopSearchDTO.setDiscount(discount);
		laptopSearchDTO.setDisplay(display);
		laptopSearchDTO.setFrontCamera(frontCamera);
		laptopSearchDTO.setMemory(memory);
		laptopSearchDTO.setOs(os);
		laptopSearchDTO.setPrice(price);
		laptopSearchDTO.setRam(ram);
		return laptopSearchDTO;
		
	}
	public LaptopSearchDTOBuilder withPrice(final int price) {
		this.price=price;
		return this;
	}
	public LaptopSearchDTOBuilder withDiscount(final int discount) {
		this.discount=discount;
		return this;
	}
	public LaptopSearchDTOBuilder withAvailable(final boolean available) {
		this.available=available;
		return this;
	}

	
	public LaptopSearchDTOBuilder withOs(final String os) {
		this.os=os;
		return this;
	}
	public LaptopSearchDTOBuilder withColor(final String color) {
		this.color=color;
		return this;
	}
	public LaptopSearchDTOBuilder withDisplay(final float display) {
		this.display=display;
		return this;
	}
	public LaptopSearchDTOBuilder withBrand(final String brand) {
		this.brand=brand;
		return this;
	}
	public LaptopSearchDTOBuilder withRam(final int ram) {
		this.ram=ram;
		return this;
	}
	public LaptopSearchDTOBuilder withMemory(final int memory) {
		this.memory=memory;
		return this;
	}
	public LaptopSearchDTOBuilder withCpu(final float cpu) {
		this.cpu=cpu;
		return this;
	}
	public LaptopSearchDTOBuilder withCamera(final int camera) {
		this.camera=camera;
		return this;
	}
	public LaptopSearchDTOBuilder withFrontCamera(final float frontCamera) {
		this.frontCamera=frontCamera;
		return this;
	}
	
	
}

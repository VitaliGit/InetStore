package com.vironit.store.entity.builder;

import com.vironit.store.entity.laptop.Laptop;
import com.vironit.store.entity.laptop.LaptopPlan;

public class LaptopBuilder extends LaptopPlan {
	private int price;
	private boolean available; 
	private int discount;
	
	private String os;
	private String brand;
	private String color;
	private int ram;
	private float display;
	private int memory; 
	private int camera;
	private float cpu;
	
	private float frontCamera;
	
	private int id;
	
	public Laptop build() {
		Laptop laptop = new Laptop();
		laptop.setAvailable(this.available);
		laptop.setBrand(this.brand);
		laptop.setCamera(this.camera);
		laptop.setColor(this.color);
		laptop.setCpu(this.cpu);
		laptop.setDiscount(this.discount);
		laptop.setDisplay(this.display);
		laptop.setFrontCamera(this.frontCamera);
		laptop.setMemory(this.memory);
		laptop.setOs(this.os);
		laptop.setPrice(this.price);
		laptop.setRam(this.ram);
		laptop.setId(this.id);
		return laptop;
	}
	
	@Override
	public LaptopBuilder withPrice(final int price) {
		this.price=price;
		return this;
	}
	@Override
	public LaptopBuilder withAvailable(final boolean available) {
		this.available=available;
		return this;
	}
	@Override
	public LaptopBuilder withDiscount(final int discount) {
		this.discount=discount;
		return this;
	}
	@Override
	public LaptopBuilder withOS(final String os) {
		this.os=os;
		return this;
	}
	@Override
	public LaptopBuilder withBrand(final String brand) {
		this.brand=brand;
		return this;
	}
	@Override
	public LaptopBuilder withColor(final String color) {
		this.color=color;
		return this;
	}
	@Override
	public LaptopBuilder withRam(final int ram) {
		this.ram=ram;
		return this;
	}
	@Override
	public LaptopBuilder withDisplay(final float display) {
		this.display=display;
		return this;
	}
	@Override
	public LaptopBuilder withMemory(final int memory) {
		this.memory=memory;
		return this;
	}
	@Override
	public LaptopBuilder withCamera(final int camera) {
		this.camera=camera;
		return this;
	}
	@Override
	public LaptopBuilder withCPU(final float cpu) {
		this.cpu=cpu;
		return this;
	}

	@Override
	public LaptopBuilder withFrontCamera(final float frontCamera) {
		this.frontCamera=frontCamera;
		return this;
	}

	@Override
	public LaptopBuilder withID(final int id) {
		this.id=id;
		return this;
	}


	
}

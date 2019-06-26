package com.vironit.store.entity.builder;

import com.vironit.store.entity.tablet.Tablet;
import com.vironit.store.entity.tablet.TabletPlan;

public class TabletBuilder extends  TabletPlan{
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
	private boolean bluetooth;
	private float backCamera;
	private boolean keyboard; 
	
	private int id;
	
	public Tablet build() {
		Tablet tablet = new Tablet();
		tablet.setAvailable(this.available);
		tablet.setBackCamera(this.backCamera);
		tablet.setBluetooth(this.bluetooth);
		tablet.setBrand(this.brand);
		tablet.setCamera(this.camera);
		tablet.setColor(this.color);
		tablet.setCpu(this.cpu);
		tablet.setDiscount(this.discount);
		tablet.setDisplay(this.display);
		tablet.setFrontCamera(this.frontCamera);
		tablet.setKeyboard(this.keyboard);
		tablet.setMemory(this.memory);
		tablet.setOs(this.os);
		tablet.setPrice(this.price);
		tablet.setRam(this.ram);
		tablet.setId(this.id);
		return tablet;
	}
	
	@Override
	public TabletBuilder withPrice(final int price) {
		this.price=price;
		return this;
	}
	@Override
	public TabletBuilder withAvailable(final boolean available) {
		this.available=available;
		return this;
	}
	@Override
	public TabletBuilder withDiscount(final int discount) {
		this.discount=discount;
		return this;
	}
	@Override
	public TabletBuilder withOS(final String os) {
		this.os=os;
		return this;
	}
	@Override
	public TabletBuilder withBrand(final String brand) {
		this.brand=brand;
		return this;
	}
	@Override
	public TabletBuilder withColor(final String color) {
		this.color=color;
		return this;
	}
	@Override
	public TabletBuilder withRam(final int ram) {
		this.ram=ram;
		return this;
	}
	@Override
	public TabletBuilder withDisplay(final float display) {
		this.display=display;
		return this;
	}
	@Override
	public TabletBuilder withMemory(final int memory) {
		this.memory=memory;
		return this;
	}
	@Override
	public TabletBuilder withCamera(final int camera) {
		this.camera=camera;
		return this;
	}
	@Override
	public TabletBuilder withFrontCamera(final float frontCamera) {
		this.frontCamera=frontCamera;
		return this;
	}
	@Override
	public TabletBuilder withCPU(final float cpu) {
		this.cpu=cpu;
		return this;
	}
	@Override
	public TabletBuilder withBluetooth(final boolean bluetooth) {
		this.bluetooth=bluetooth;
		return this;
	}
	@Override
	public TabletBuilder withBackCamera(final float backCamera) {
		this.backCamera=backCamera;
		return this;
	}
	@Override
	public TabletBuilder withKeyboard(final boolean keyboard) {
		this.keyboard=keyboard;
		return this;
	}

	@Override
	public TabletBuilder withID(final int id) {
		this.id=id;
		return this;
	}

	
	
}

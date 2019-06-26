package com.vironit.store.entity.builder;

import com.vironit.store.entity.phone.Phone;
import com.vironit.store.entity.phone.PhonePlan;

public class PhoneBuilder extends PhonePlan {
	private int price;
	private boolean available;
	private int discount;
	
	private String os;
	private String brand;
	private String color;
	private float display;
	private int ram;
	private int memory;
	private int camera;	
	private float cpu;
	
	private float frontCamera;
	private float backCamera;
	private boolean bluetooth;
	
	private int id;
		
		public Phone build() {
			Phone phone = new Phone();
			phone.setAvailable(this.available);
			phone.setBackCamera(this.backCamera);
			phone.setBluetooth(this.bluetooth);
			phone.setBrand(this.brand);
			phone.setCamera(this.camera);
			phone.setColor(this.color);
			phone.setCpu(this.cpu);
			phone.setDiscount(this.discount);
			phone.setDisplay(this.display);
			phone.setFrontCamera(this.frontCamera);
			phone.setMemory(this.memory);
			phone.setOs(this.os);
			phone.setPrice(this.price);
			phone.setRam(this.ram);
			phone.setId(this.id);
			return phone;
		}
		@Override
		public PhoneBuilder withPrice(final int price) {
			this.price=price;
			return this;
		}
		@Override
		public PhoneBuilder withAvailable(final boolean available) {
			this.available=available;
			return this;
		}
		@Override
		public PhoneBuilder withDiscount(final int discount) {
			this.discount=discount;
			return this;
		}
		@Override
		public PhoneBuilder withOS(final String os) {
			this.os=os;
			return this;
		}
		@Override
		public PhoneBuilder withBrand(final String brand) {
			this.brand=brand;
			return this;
		}
		@Override
		public PhoneBuilder withColor(final String color) {
			this.color=color;
			return this;
		}
		@Override
		public PhoneBuilder withRam(final int ram) {
			this.ram=ram;
			return this;
		}
		@Override
		public PhoneBuilder withDisplay(final float display) {
			this.display=display;
			return this;
		}
		@Override
		public PhoneBuilder withMemory(final int memory) {
			this.memory=memory;
			return this;
		}
		@Override
		public PhoneBuilder withCamera(final int camera) {
			this.camera=camera;
			return this;
		}
		@Override
		public PhoneBuilder withFrontCamera(final float frontCamera) {
			this.frontCamera=frontCamera;
			return this;
		}
		@Override
		public PhoneBuilder withCPU(final float cpu) {
			this.cpu=cpu;
			return this;
		}
		@Override
		public PhoneBuilder withBluetooth(final boolean bluetooth) {
			this.bluetooth=bluetooth;
			return this;
		}

		@Override
		public PhoneBuilder withBackCamera(float backCamera) {
			this.backCamera=backCamera;
			return this;
		}
		@Override
		public PhoneBuilder withID(int id) {
			this.id=id;
			return this;
		}

		

}

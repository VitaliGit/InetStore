package com.vironit.store.entity.tablet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="t_tablets")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Tablet{
	@Column(name="price")
	private int price;
	@Column(name="is_present")
	private boolean available;
	@Column(name="discount")
	private int discount;
	
	@Column(name="os")
	private String os;
	@Column(name="brand")
	private String brand;
	@Column(name="color")
	private String color;
	@Column(name="ram_mb")
	private int ram;
	@Column(name="display_inch")
	private float display;
	@Column(name="memory_gb")
	private int memory; 
	@Column(name="camera_num")
	private int camera;
	@Column(name="cpu_ghz")
	private float cpu;
	
	
	@Column(name="frontcamera_mpx")
	private float frontCamera;
	@Column(name="backcamera_mpx")
	private float backCamera;
	@Column(name="bluetooth")
	private boolean bluetooth;
	@Column(name="keyboard")
	private boolean keyboard; 
	
	@Id 
	@Column(name="id")
	private int id;

	

	public Tablet() {
		
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public float getDisplay() {
		return display;
	}
	public void setDisplay(float display) {
		this.display = display;
	}
	public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}
	public int getCamera() {
		return camera;
	}
	public void setCamera(int camera) {
		this.camera = camera;
	}
	public float getFrontCamera() {
		return frontCamera;
	}
	public void setFrontCamera(float frontCamera) {
		this.frontCamera = frontCamera;
	}
	public float getCpu() {
		return cpu;
	}
	public void setCpu(float cpu) {
		this.cpu = cpu;
	}
	public boolean isBluetooth() {
		return bluetooth;
	}
	public void setBluetooth(boolean bluetooth) {
		this.bluetooth = bluetooth;
	}
	public float getBackCamera() {
		return backCamera;
	}
	public void setBackCamera(float backCamera) {
		this.backCamera = backCamera;
	}
	public boolean isKeyboard() {
		return keyboard;
	}
	public void setKeyboard(boolean keyboard) {
		this.keyboard = keyboard;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (available ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(backCamera);
		result = prime * result + (bluetooth ? 1231 : 1237);
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + camera;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + Float.floatToIntBits(cpu);
		result = prime * result + discount;
		result = prime * result + Float.floatToIntBits(display);
		result = prime * result + Float.floatToIntBits(frontCamera);
		result = prime * result + id;
		result = prime * result + (keyboard ? 1231 : 1237);
		result = prime * result + memory;
		result = prime * result + ((os == null) ? 0 : os.hashCode());
		result = prime * result + price;
		result = prime * result + ram;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tablet other = (Tablet) obj;
		if (available != other.available)
			return false;
		if (Float.floatToIntBits(backCamera) != Float.floatToIntBits(other.backCamera))
			return false;
		if (bluetooth != other.bluetooth)
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (camera != other.camera)
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (Float.floatToIntBits(cpu) != Float.floatToIntBits(other.cpu))
			return false;
		if (discount != other.discount)
			return false;
		if (Float.floatToIntBits(display) != Float.floatToIntBits(other.display))
			return false;
		if (Float.floatToIntBits(frontCamera) != Float.floatToIntBits(other.frontCamera))
			return false;
		if (id != other.id)
			return false;
		if (keyboard != other.keyboard)
			return false;
		if (memory != other.memory)
			return false;
		if (os == null) {
			if (other.os != null)
				return false;
		} else if (!os.equals(other.os))
			return false;
		if (price != other.price)
			return false;
		if (ram != other.ram)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Tablet [price=" + price + ", available=" + available + ", discount=" + discount + ", os=" + os
				+ ", brand=" + brand + ", color=" + color + ", ram=" + ram + ", display=" + display + ", memory="
				+ memory + ", camera=" + camera + ", cpu=" + cpu + ", frontCamera=" + frontCamera + ", backCamera="
				+ backCamera + ", bluetooth=" + bluetooth + ", keyboard=" + keyboard + ", id=" + id + "]";
	}
	
}
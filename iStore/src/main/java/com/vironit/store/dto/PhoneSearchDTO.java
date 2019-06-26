package com.vironit.store.dto;

public class PhoneSearchDTO {

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
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public boolean isBluetooth() {
		return bluetooth;
	}
	public void setBluetooth(boolean bluetooth) {
		this.bluetooth = bluetooth;
	}
	
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public float getDisplay() {
		return display;
	}
	public void setDisplay(float display) {
		this.display = display;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}
	public float getCpu() {
		return cpu;
	}
	public void setCpu(float cpu) {
		this.cpu = cpu;
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
	public float getBackCamera() {
		return backCamera;
	}
	public void setBackCamera(float backCamera) {
		this.backCamera = backCamera;
	}
}
package com.vironit.store.entity;


public abstract class ElectronicDevices extends AllGood{//public???

	protected abstract ElectronicDevices withOS(String os);//i.e."Android"
	protected abstract ElectronicDevices withBrand(String brand);
	protected abstract ElectronicDevices withColor(String color);
	protected abstract ElectronicDevices withRam(int ram);//mb
	protected abstract ElectronicDevices withDisplay(float display);//inch
	protected abstract ElectronicDevices withMemory(int memory);//gb 
	protected abstract ElectronicDevices withCamera(int camera); //quantity
	protected abstract ElectronicDevices withCPU(float cpu);//ghz
}

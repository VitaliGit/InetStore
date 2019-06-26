package com.vironit.store.entity.laptop;

import com.vironit.store.entity.ElectronicDevices;
import com.vironit.store.entity.builder.LaptopBuilder;

public abstract class LaptopPlan extends ElectronicDevices{
	
	protected abstract LaptopBuilder withFrontCamera(float frontCamera);//mpx
}

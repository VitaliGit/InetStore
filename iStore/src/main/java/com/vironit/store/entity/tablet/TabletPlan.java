package com.vironit.store.entity.tablet;

import com.vironit.store.entity.ElectronicDevices;
import com.vironit.store.entity.builder.TabletBuilder;

public abstract class  TabletPlan extends ElectronicDevices{
	
	protected abstract TabletBuilder withFrontCamera(float frontCamera);//mpx
	protected abstract TabletBuilder withBluetooth(boolean bluetooth);//"Android"
	protected abstract TabletBuilder withBackCamera(float backCamera);//mpx
	protected abstract TabletBuilder withKeyboard(boolean keyboard);// we are checking just for the presence of this stuff

}
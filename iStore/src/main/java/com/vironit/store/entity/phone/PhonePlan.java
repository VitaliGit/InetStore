package com.vironit.store.entity.phone;

import com.vironit.store.entity.ElectronicDevices;
import com.vironit.store.entity.builder.PhoneBuilder;

public abstract class PhonePlan  extends ElectronicDevices{

		protected abstract PhoneBuilder withBluetooth(boolean bluetooth);//"Android"
		protected abstract PhoneBuilder withFrontCamera(float frontCamera);//mpx
		protected abstract PhoneBuilder withBackCamera(float backCamera);//mpx

		
	}


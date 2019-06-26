package com.vironit.store.entity;

public abstract class AllGood{
	
	protected abstract AllGood withID(int id);

	protected abstract AllGood withPrice(int price);
	protected abstract AllGood withAvailable(boolean available); 
	protected abstract AllGood withDiscount(int discount);	
	
	//protected abstract AllGood withCreatedDate(LocalDateTime createdDate);
	//protected abstract AllGood withUpdatedDate(LocalDateTime updatedDate);
}

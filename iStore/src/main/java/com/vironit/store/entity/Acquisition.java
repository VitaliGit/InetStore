package com.vironit.store.entity;

import java.time.LocalDateTime;

public abstract class Acquisition { 

	protected abstract Acquisition  withID(int id);
	protected abstract Acquisition  withGoodID(int goodId);
	protected abstract Acquisition  withUserName(int userName);
	protected abstract Acquisition 	withCreatedDate(LocalDateTime createdDate);
	protected abstract Acquisition 	withUpdatedDate(LocalDateTime updatedDate);

//// meant for  the cart & purchase

}

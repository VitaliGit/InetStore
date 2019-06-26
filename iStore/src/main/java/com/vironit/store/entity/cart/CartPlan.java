package com.vironit.store.entity.cart;

import java.time.LocalDateTime;

import com.vironit.store.entity.Acquisition;


public abstract class CartPlan extends Acquisition{
	protected abstract CartPlan  withOrderDate(LocalDateTime orderDate);
	protected abstract CartPlan  withTotalPrice(int totalPrice);
	protected abstract CartPlan  withIDSession(int idSession);
}

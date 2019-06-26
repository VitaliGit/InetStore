package com.vironit.store.aspect;


import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class AspectGoods {
	private static final Logger LOG = Logger.getLogger(AspectGoods.class.getName());   
			
	@Pointcut("execution (* com.vironit.store.controller.goods.*.found*(..) )")
	private void found() {}
	
	@Pointcut("execution (* com.vironit.store.controller.goods.*.update*(..) )")
	private void update() {	}
	
	@Pointcut("execution (* com.vironit.store.controller.goods.*.remove*(..) )")
	private void remove() {	}
	
	@Pointcut("execution (* com.vironit.store.controller.goods.*.add*(..) )")
	private void add() {	}
	
	@Pointcut("found() || update() || remove() || add()")
	private void allMovements() { }
	
	@Before("allMovements()")
	public void before(JoinPoint theJP) {
		String theMethod = theJP.getSignature().toShortString();
		LOG.info("Before-------------->>>------------Good --->>>"+theMethod);
		Object [] args = theJP.getArgs();
		for(Object obj : args) {
			LOG.info("Args===============Good===="+obj);
		}
		
	}
	@AfterReturning(pointcut="allMovements()", returning="object")
	public void afterReturn(JoinPoint theJP, Object object) {
		String theMethod = theJP.getSignature().toShortString();
		LOG.info("After-------------->>>-----Good------->>>"+theMethod);
		LOG.info("Result===============Good===" + object);
	}
	
	@AfterThrowing(pointcut="allMovements()", throwing="throwing")
	public void afterThrow(JoinPoint theJP, Throwable throwing) {
		String theMethod = theJP.getSignature().toShortString();
		LOG.info("AfterThrowing--------->>>----Good--------->>>"+theMethod);
		LOG.info("The error event===============Good====="+throwing );
	}
	@Around("allMovements()")
	public Object around (ProceedingJoinPoint thePJP) throws Throwable{
		Object result = null;
		try {
			result = thePJP.proceed();
		} catch (Exception e) {
			LOG.warning(e.getMessage());
			result = "*---Tremendous error event---*";
		}
		return result;
		
	}
}

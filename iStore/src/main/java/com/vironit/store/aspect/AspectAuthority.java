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
@Order(1)
public class AspectAuthority {
	private static final Logger LOG = Logger.getLogger(AspectAuthority.class.getName());   
			
	@Pointcut("execution (* com.vironit.store.controller.person.AuthorityManagement.search*(..) )")
	private void search() {}
	
	@Pointcut("execution (* com.vironit.store.controller.person.AuthorityManagement.update*(..) )")
	private void update() {	}
	

	@Pointcut("update() || search()")
	private void allMovements() { }
	
	@Before("allMovements()")
	public void before(JoinPoint theJP) {
		String theMethod = theJP.getSignature().toShortString();
		LOG.info("Before-------------->>>------------Authority --->>>"+theMethod);
		Object [] args = theJP.getArgs();
		for(Object obj : args) {
			LOG.info("Args===============Authority===="+obj);
		}
		
	}
	@AfterReturning(pointcut="allMovements()", returning="object")
	public void afterReturn(JoinPoint theJP, Object object) {
		String theMethod = theJP.getSignature().toShortString();
		LOG.info("After-------------->>>-----Authority------->>>"+theMethod);
		LOG.info("Result===============Authority===" + object);
	}
	
	@AfterThrowing(pointcut="allMovements()", throwing="throwing")
	public void AfterThrow(JoinPoint theJP, Throwable throwing) {
		String theMethod = theJP.getSignature().toShortString();
		LOG.info("AfterThrowing--------->>>----Authority--------->>>"+theMethod);
		LOG.info("The error event===============Authority====="+throwing );
	}
	@Around("allMovements()")
	public Object around (ProceedingJoinPoint thePJP) throws Throwable{
		Object result = null;
		try {
			result = thePJP.proceed();
		} catch (Exception e) {
			LOG.warning(e.getMessage());
			result = "*+++Tremendous error event+++*";
		}
		return result;
		
	}
}

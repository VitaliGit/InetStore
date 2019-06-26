package com.vironit.store.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyValidator implements ConstraintValidator<PasswordAnnotation, String> {
	private String prefix;
	
	@Override
	public void initialize(PasswordAnnotation constraintAnnotation) {
		prefix=constraintAnnotation.regexp();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean bool;
		if(value!=null) {
			bool=value.matches(prefix);
		}else bool=true;
		return bool;
	}

}

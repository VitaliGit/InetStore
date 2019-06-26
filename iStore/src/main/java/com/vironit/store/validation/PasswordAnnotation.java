package com.vironit.store.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=MyValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PasswordAnnotation {
	
	//2-Upper, 2-lowercase, 2-numbers, [6;20]-quantity
	public String regexp() default "^(?=.*\\d{2,})(?=.*[a-z]{2,})(?=.*[A-Z]{2,}).{6,21}$";

	public String message() default "Le mot de passe doit contenir nécessairement au minimum \n2 caractères en majuscules, 2 en minuscules et 2 chiffres";
	
	public Class<?>[] groups() default {};
	public Class<? extends Payload>[] payload() default {};
}

package org.springmvc.controller;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint(validatedBy = HobbyValidator.class)
@Target({ElementType.FIELD})
@Retention(value= RetentionPolicy.RUNTIME)

public @interface IsValidHobby {
	
	String ValidParamlist() default "Music|Football|Cricket|Hockey";
	String message() default "Hobbies should be from - {Music|Football|Cricket|Hockey}";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default {};
	
}

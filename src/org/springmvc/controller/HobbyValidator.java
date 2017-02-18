package org.springmvc.controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby,String> {
	private String validParamList;
	@Override
	public void initialize(IsValidHobby isValidHobby) {
		this.validParamList = isValidHobby.ValidParamlist();
	}

	@Override
	public boolean isValid(String Hobb, ConstraintValidatorContext ctx) {
		
		if(Hobb==null){
			return false;
		}
		
		if(Hobb.matches(this.validParamList)){
			return true;
		}
		
		return false;
	}

}

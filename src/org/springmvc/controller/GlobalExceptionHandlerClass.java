package org.springmvc.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@ResponseStatus(value=HttpStatus.CONFLICT,reason="Data integrity violation")
public class GlobalExceptionHandlerClass {

	@ExceptionHandler(value = NullPointerException.class)
	public ModelAndView handleNullPointerException(Exception E){
		System.out.println(E.getMessage());
		ModelAndView model = new ModelAndView("NullPointerException");
		model.addObject("message", E.getMessage());
		return model;
	}
	@ExceptionHandler(value = IOException.class)
	public String handleIOException(Exception E){
		System.out.println(E.getMessage());
		return "IOException";
	}
	@ExceptionHandler(value = Exception.class)
	public String handleotherException(Exception E){
		System.out.println(E.getMessage());
		return "Exception";
	}
}

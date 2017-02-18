package org.springmvc.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springmvc.service.ServiceLayer;


@Controller
public class StudentAdmissionController {
	
	@Autowired
	ServiceLayer service;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(ArrayList.class,"studentSkill",new CustomCollectionEditor(ArrayList.class)
				{
					@Override
					public Object convertElement(Object element){
						Skill S1 = new Skill();
						if (element != null && element instanceof String){
							String element1 = element.toString();
							S1 = service.getSkill(element1);
						}
						return S1;		 
					}
				});
		
	}
	
	@RequestMapping(value="/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionform() throws Exception{
		
		
		ModelAndView modelandview = new ModelAndView("AdmissionForm");
		
		return modelandview;
	}
	@ModelAttribute
	public void addCommonObjects(Model model){
		model.addAttribute("headermessage","ABCD Engg college");
	}
	
	@RequestMapping(value="/AdmissionFormSubmission.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionform(@Valid @ModelAttribute("student") Student student,BindingResult result )
	{
		
		if(result.hasErrors())
		{
			ModelAndView modelandview = new ModelAndView("AdmissionForm");
			return modelandview;
		}
		boolean result1 = service.studentcheck(student);
		String message = "Student already exit!!";
		if(result1){
			ArrayList<Address> L = (ArrayList<Address>) service.checkAddress(student.getStudentAddress());
			if(L.isEmpty())
			service.addAddress(student.getStudentAddress());
			else{
				student.setStudentAddress(L.get(0));
			}
			service.addstudent(student);
			message = "Student added!!";
		}
		ModelAndView model = new ModelAndView("AdmissionFormSubmission");
		//Student student = new Student();
		model.addObject("student",student);
		//model.addObject("message", message);
		return model;
	}
}

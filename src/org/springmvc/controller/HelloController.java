package org.springmvc.controller;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/welcome/{place}/{username}")
	protected ModelAndView Mymodel(@PathVariable Map<String,String> pathvar) throws Exception {
			String place = pathvar.get("place");
			String name = pathvar.get("username");
			ModelAndView modelandview = new ModelAndView("HelloPage");
			modelandview.addObject("msg", "Hi "+name+", You are from "+place);
		
		return modelandview;
	}

}

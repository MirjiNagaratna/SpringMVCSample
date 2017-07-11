package com.tutorialspoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {
	
	@RequestMapping(value="/index" ,method=RequestMethod.GET)
	public String indexPage(){
		return "index";
	}
	
	/**************Redirect to request***/
	@RequestMapping(value="/redirect", method=RequestMethod.GET)
	public String redirectMethod1(){
		
		return "redirect:finalPage";
	}

	@RequestMapping(value="/finalPage", method=RequestMethod.GET)
	public String finalRedirection(){
		return "finalPage";
	}
}

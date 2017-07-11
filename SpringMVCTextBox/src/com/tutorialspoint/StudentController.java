package com.tutorialspoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StudentController {
	
	@RequestMapping(value = "/student", method= RequestMethod.GET)
	public ModelAndView  student(){
		return new ModelAndView("student","command",new Student());
	}

	@RequestMapping(value = "/addStudent" ,method = RequestMethod.GET)
	public String addStudent(@ModelAttribute("SpringWeb")Student student,ModelMap model){
		
		model.addAttribute("username", student.getUsername());
		model.addAttribute("password", student.getPassword());
		model.addAttribute("address",student.getAddress());
		model.addAttribute("receivePaper",student.isReceivePaper());
		model.addAttribute("favoriteFrameworks",student.getFavoriteFrameworks());
		model.addAttribute("gender",student.getGender());
		model.addAttribute("favoriteNumber",student.getFavoriteNumber());
		model.addAttribute("country",student.getCountry());
		model.addAttribute("skills",student.getSkills());
		
		return "result";
	}
	
	
	 @ModelAttribute("webFrameworkList")
	   public List<String> getWebFrameworkList()
	   {
	      List<String> webFrameworkList = new ArrayList<String>();
	      webFrameworkList.add("Spring MVC");
	      webFrameworkList.add("Struts 1");
	      webFrameworkList.add("Struts 2");
	      webFrameworkList.add("Apache Wicket");
	      return webFrameworkList;
	   }
	 
	 @ModelAttribute("numbersList")
	   public List<String> getNumbersList()
	   {
	      List<String> numbersList = new ArrayList<String>();
	      numbersList.add("1");
	      numbersList.add("2");
	      numbersList.add("3");
	      numbersList.add("4");
	      return numbersList;
	   }
	 
	 
	 @ModelAttribute("countryList")
	 public Map<String,String> getCountryList(){
		 
		 Map<String, String> countryList = new HashMap<String, String>();
	      countryList.put("US", "United States");
	      countryList.put("CH", "China");
	      countryList.put("SG", "Singapore");
	      countryList.put("MY", "Malaysia");
	      return countryList;
	 }
	 
	 @ModelAttribute("skilList")
	 public Map<String, String> getSkilList(){
		 
		 Map<String, String> skillList = new HashMap<String, String>();
		   skillList.put("Hibernate", "Hibernate");
		      skillList.put("Spring", "Spring");
		      skillList.put("Apache Wicket", "Apache Wicket");
		      skillList.put("Struts", "Struts");
	      return skillList;
	 }
}

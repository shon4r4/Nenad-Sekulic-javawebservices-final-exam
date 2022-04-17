package com.javawebservices.finalexam;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
	
	private CalculatorService cs = new CalculatorService();
	
	//Starting page.
	@RequestMapping(
			value = "/", 
			method = RequestMethod.GET)
	public String home() {
		String text = "Welcome to my Calculator";
		
		return text;
		
	}
	
	//Add 2 values
	@RequestMapping("/add")
	public String add(String x, String y) {
		try {
			return cs.add(x,y);
		}catch(NumberFormatException e) {
			return "Invalid input";
		}
		
		
	}
	//Multiply 2 values
	@RequestMapping("/multiply")
	public String multiply(String x, String y) {
		try {
			return cs.multiply(x,y);
		}catch(NumberFormatException e) {
			return "Invalid input";
		}
		
	}
	//Subtract 2 values
	@RequestMapping("/subtract")
	public String subtract(String x, String y) {
		try {
			return cs.subtract(x,y);
		}catch(NumberFormatException e) {
			return "Invalid input";
		}
		
	}


}
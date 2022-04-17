package com.javawebservices.finalexam;

public class CalculatorService {
	
	public String add(String x, String y) {
		return "Resultat : " + (Integer.valueOf(x) + Integer.valueOf(y));
	}
	
	public String multiply(String x, String y) {
		return "Resultat : " +(Integer.valueOf(x) * Integer.valueOf(y));
	}
	
	public String subtract(String x, String y) {
		return "Resultat : " + (Integer.valueOf(x) - Integer.valueOf(y));
	}

}



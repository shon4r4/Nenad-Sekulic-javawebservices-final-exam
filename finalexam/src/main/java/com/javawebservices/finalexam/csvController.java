package com.javawebservices.finalexam;

import java.io.IOException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/csv")
public class csvController {
	@RequestMapping(
			value = "/", 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String welcome() {
		String text = "{ \"Welcome message\":\"This is my csv reader\"}";
		
		return text;
	}
	//Shows CSV file as JSON
	@RequestMapping(
			value = "/showcsv",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String showcsv() throws IOException {
		csvFileReader mycsvReader = new csvFileReader();
		
		String text = mycsvReader.readFile("sample.csv");
		return text;
	}
	

}

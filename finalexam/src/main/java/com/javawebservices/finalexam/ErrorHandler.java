package com.javawebservices.finalexam;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandler implements ErrorController{
	
	//Error page.
	@RequestMapping(value = "/error")
	public String handleError(HttpServletResponse response) {

	        if(response.getStatus() == HttpStatus.NOT_FOUND.value()) {
	            return "error-404";
	        }
	        else if(response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	            return "error-500";
	        }
	    
	    return "Something went wrong!";
	
	}
	
	

}

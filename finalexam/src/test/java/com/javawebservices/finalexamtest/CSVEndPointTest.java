package com.javawebservices.finalexamtest;


import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.javawebservices.finalexam.httpHelper;

@SpringBootTest
public class CSVEndPointTest {

	
private String sut;
	
	@Before
	public void setUp() throws Exception {
		sut = "http://localhost:8080";
	}
	
	@Test //file not found
	public void testBadName() throws IOException {
		String fileName = "badName.csv";
		
		String expected = "[\"File not found\"]";

		String url = sut + "/showcsv";
		String body = "?filename=" + fileName;
		String query = url + body;
		

		String actual = httpHelper.UrlResponse(query, "get", null);
		
		
		assertEquals(actual, expected);
	}
	
	@Test //ok response with a simple file
	public void testSimpleFile() throws IOException {
		String fileName = "sample.csv";
		
		String expected = "[{\"OrderDate\":\"2019\",\"Region\":\"East\"}]";

		String url = sut + "/showcsv";
		String body = "?filename=" + fileName;
		String query = url + body;

		String actual = httpHelper.UrlResponse(query, "get", null);
		
		assertEquals(actual, expected);
	}

}


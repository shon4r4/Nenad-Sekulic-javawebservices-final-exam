package com.javawebservices.finalexamtest;


import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.javawebservices.finalexam.httpHelper;

@SpringBootTest
public class CalculatorEndPointTest {

	private String sut;

	@Before
	public void setUp() throws Exception {
		sut = "http://localhost:8080";
	}
	
	

	@Test
	public void testAddEndpoint() throws IOException {
		String baseText = "{ \"Result\":\"";

		String testVar1 = "77";
		String testVar2 = "9";
		int resultInt = Integer.valueOf(testVar1)+Integer.valueOf(testVar2);
		String expected = baseText + resultInt + "\"}";
		String notExpected = expected + " dummy";

		String url = sut + "/add";
		String params = "?x=" + testVar1 + "&y=" + testVar2;
		String query = url + params;
		String actual = httpHelper.UrlResponse(query, "get", null);
		
		assertEquals(actual, expected);
		assertNotEquals(actual, baseText);
		assertNotEquals(actual, notExpected);
	}
	
	@Test
	public void testSubEndpoint() throws IOException {
		String baseText = "{ \"Result\":\"";

		String testVar1 = "10";
		String testVar2 = "20";
		int resultInt = Integer.valueOf(testVar1)-Integer.valueOf(testVar2);
		String expected = baseText + resultInt + "\"}";
		String notExpected = expected + " dummy";

		String url = sut + "/subtract";
		String params = "?x=" + testVar1 + "&y=" + testVar2;
		String query = url + params;
		String actual = httpHelper.UrlResponse(query, "get", null);
		
		assertEquals(actual, expected);
		assertNotEquals(actual, baseText);
		assertNotEquals(actual, notExpected);
	}
	
	@Test
	public void testMultEndpoint() throws IOException {
		String baseText = "{ \"Result\":\"";

		String testVar1 = "5";
		String testVar2 = "2";
		int resultInt = Integer.valueOf(testVar1)*Integer.valueOf(testVar2);
		String expected = baseText + resultInt + "\"}";
		String notExpected = expected + " dummy";

		String url = sut + "/multiply";
		String params = "?x=" + testVar1 + "&y=" + testVar2;
		String query = url + params;
		String actual = httpHelper.UrlResponse(query, "get", null);
		
		assertEquals(actual, expected);
		assertNotEquals(actual, baseText);
		assertNotEquals(actual, notExpected);
	}
	
	
	
	
}

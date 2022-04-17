package com.javawebservices.finalexamtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.javawebservices.finalexam.CalculatorService;


@SpringBootTest
public class CalculatorServiceTest {
	
	private CalculatorService sut;
	
	@Before
	public void SetUp() {
		sut = new CalculatorService();
		
	}

	@Test
	public void testMultiplySuccess() {
		String actual = sut.multiply("8", "5");
		String expected = "40";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMultiplyFail() {
		String actual = sut.multiply("4", "8");
		String expected = "60";
		assertNotEquals(expected, actual);
	}
	
	
	@Test
	public void testMult_badInput() {
			String actual = sut.multiply("d", "20");
			String expected = "[ \" Please check your input \" ]";
			assertEquals(expected, actual);
		}
	
	
	
	@Test
	public void testAddSuccess() {
		String actual = sut.add("30", "15");
		String expected = "45";
		assertEquals(expected, actual);
	}

	
	@Test
	public void testAddFail() {
		String actual = sut.add("110", "12");
		String expected = "55";
		assertNotEquals(expected, actual);
	}
	
	
	@Test
	public void testAdd_badInput() {
	    String actual = sut.add("a", "7");
	    String expected = "[ \" Please check your input \" ]";
		assertEquals(expected, actual);
			}
	
	
	@Test
	public void testSubSuccess() {
		String actual = sut.subtract("77", "7");
		String expected = "70";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSubFail() {
		String actual = sut.subtract("40", "13");
		String expected = "12";
		assertNotEquals(expected, actual);
	}
	
	
	@Test
	public void testSub_badInput() {
		String actual = sut.subtract("t", "4");
		String expected = "[ \" Please check your input \" ]";
		assertEquals(expected, actual);
	}
	
}

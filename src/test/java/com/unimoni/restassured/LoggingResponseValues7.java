package com.unimoni.restassured;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class LoggingResponseValues7 extends BaseTest {

	/**
	 * This test will print out all the Response Headers
	 */
	@Test
	public void test001() {
		System.out.println("---------------Printing Response Headers------------------");
		given().param("programme", "Computer Science").param("limit", 1).when().get("/list").then().log().headers()
				.statusCode(200);
	}

	/**
	 * This test will print the Response Status Line
	 */
	@Test
	public void test002() {
		System.out.println("---------------Printing Response Status Line------------------");
		given().param("programme", "Computer Science").param("limit", 1).when().get("/list").then().log().status()
				.statusCode(200);
	}

	/**
	 * This test will print the Response Body
	 */
	@Test
	public void test003() {
		System.out.println("---------------Printing Response Body------------------");
		given().param("programme", "Computer Science").param("limit", 1).when().get("/list").then().log().body()
				.statusCode(200);
	}

	/**
	 * This test will print the Response incase of an error
	 */
	@Test
	public void test004() {
		System.out.println("---------------Printing Response Body incase of an error------------------");
		given().param("programme", "Computer Science").param("limit", 1).when().get("/list").then().log().ifError();
	}

}

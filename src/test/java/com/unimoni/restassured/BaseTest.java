package com.unimoni.restassured;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseTest {
	
	@BeforeClass
	public static void init(){
		
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8080;
		RestAssured.basePath="/student";
		
	}

}

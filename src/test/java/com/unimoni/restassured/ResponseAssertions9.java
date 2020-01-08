package com.unimoni.restassured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ResponseAssertions9 extends BaseTest {

	@Test
	public void test001() {
		given().when().get("/1").then().body("courses.size()", equalTo(2));
	}
	
	@Test
	public void test002() {
		given().when().get("/1").then().body("firstName", equalToIgnoringCase("vernon"));
	}
	
	@Test
	public void test003() {
		given().when().get("/1").then().body("courses", hasItem("Accounting"));
		given().when().get("/1").then().body("courses", hasItems("Accounting", "Statistics"));
	}
	

}

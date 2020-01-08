package com.unimoni.restassured;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class BasicAuth10 extends BaseTest {
	
	//Could not find any free rest service with some authentication, but if we have authentication in place we can use like this..

	@Test
	public void test001() {

		String validusername = "seshu";
		String validpassword = "K001#";

		Response response = given().auth().basic(validusername, validpassword).when().get("/list");
		response.prettyPrint();
	}

	@Test
	public void test002() {

		String accessToken = "1101";

		Response response = given().auth().oauth2(accessToken).when().get("/list");
		response.prettyPrint();
	}

}

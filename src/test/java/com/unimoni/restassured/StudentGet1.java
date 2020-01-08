package com.unimoni.restassured;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class StudentGet1 extends BaseTest {
	
	@Test
	public void getAllStudents(){
		System.out.println("*** Started .. getAllStudentInformation");
		Response response = given()
							.when()
								.get("/list");
		
		System.out.println(response.body().prettyPrint());
	}

	@Test
	public void assertStatusCode(){
		System.out.println("*** Started .. validateStatusCode");
		//Validate the status code

		given()
		.when()
			.get("/list")
		.then()
			.statusCode(200);
		
	}
	
	@Test
	public void exampleRestTest() {
	    given()
	        .contentType(ContentType.JSON)
	        .pathParam("id", "1")
	    .when()
	        .get("/{id}")
	    .then()
	        .statusCode(200)
	        .body("firstName", equalTo("Vernon"))
	        .body("lastName", equalTo("Harper"))
	        .body("courses.size()", equalTo(2))
	        .body("courses.size()", greaterThan(1));
	        
	}
	
	@Test
	public void exampleJsonPathTest() {
	  Response res = get("/1");
	  assertEquals(200, res.getStatusCode());
	  String json = res.asString();
	  JsonPath jp = new JsonPath(json);
	  assertEquals("egestas.rhoncus.Proin@massaQuisqueporttitor.org", jp.get("email"));
	  assertEquals("Vernon", jp.get("firstName"));
	  assertEquals("Harper", jp.get("lastName"));
	}

}

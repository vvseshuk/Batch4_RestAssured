package com.unimoni.restassured;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class StudentDeleteTest5 extends BaseTest {

	/**
	 * Test for Deleting student information
	 */
	@Test
	public void deleteStudent() {
		// Put the student ID here
		String studentId = "103";

		given().when().delete("/" + studentId).then().statusCode(204);
	}

}

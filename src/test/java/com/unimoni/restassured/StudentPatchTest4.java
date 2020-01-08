package com.unimoni.restassured;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.unimoni.pojo.Student;

public class StudentPatchTest4 extends BaseTest {

	/**
	 * Test for Updating student information
	 */

	@Test
	public void updateStudent() {
		// Put the student ID here
		String studentId = "103";

		ArrayList<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("C++");
		courses.add("C#");

		Student student = new Student();
		student.setFirstName("Mark");
		student.setLastName("Taylor");
		student.setEmail("mnx@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);

		given().contentType(ContentType.JSON).when().body(student).patch("/" + studentId).then().statusCode(200);

	}

}

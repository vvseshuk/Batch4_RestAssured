package com.unimoni.restassured;



import java.util.ArrayList;

import org.testng.annotations.Test;

import com.unimoni.pojo.Student;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;


public class StudentPostTest2 extends BaseTest {

/**
 * Test for creating new student	
 */
	@Test
	public void createNewStudent(){
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("C++");
		
		Student student = new Student();
		student.setFirstName("Seshu");
		student.setLastName("K");
		student.setEmail("axyz@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);
		
	
	}
}

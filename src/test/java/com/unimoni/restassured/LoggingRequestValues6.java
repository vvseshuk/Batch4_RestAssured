package com.unimoni.restassured;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.unimoni.pojo.Student;

public class LoggingRequestValues6 extends BaseTest {

	/**
	 * This test will print out all the request headers
	 */
	@Test
	public void test001() {
		System.out.println("---------------Printing Request Headers------------------");
		given().log().headers().when().get("/1").then().statusCode(200);
	}

	/**
	 * This test will print out all the request Parameters
	 */
	@Test
	public void test002() {
		System.out.println("---------------Printing Request Parameters------------------");
		given().param("programme", "Computer Science").param("limit", 1).log().params().when().get("/list").then()
				.statusCode(200);
	}

	/**
	 * This test will print out the Request body
	 */
	@Test
	public void test003() {
		ArrayList<String> courses = new ArrayList<String>();
		System.out.println("---------------Printing Request Body------------------");
		courses.add("Java");
		courses.add("C++");

		Student student = new Student();
		student.setFirstName("Tej");
		student.setLastName("Hegde");
		student.setEmail("sxyz@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);

		given().contentType(ContentType.JSON).log().body().when().body(student).post();
	}

	/**
	 * This test will print out All the details
	 */
	@Test
	public void test004() {
		ArrayList<String> courses = new ArrayList<String>();
		System.out.println("---------------Printing All the Request Details------------------");
		courses.add("Java");
		courses.add("C++");

		Student student = new Student();
		student.setFirstName("Tej");
		student.setLastName("Hegde");
		student.setEmail("cxyz@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);

		given().contentType(ContentType.JSON).log().all().when().body(student).post();
	}

	/**
	 * This test will print Request details if validation fails
	 */
	@Test
	public void test005() {
		ArrayList<String> courses = new ArrayList<String>();
		System.out.println("---------------Printing All the Request Details if validation fails------------------");
		courses.add("Java");
		courses.add("C++");

		Student student = new Student();
		student.setFirstName("Tejw");
		student.setLastName("Hegdew");
		student.setEmail("xyz23145@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);

		given().contentType(ContentType.JSON).log().ifValidationFails().when().body(student).post().then()
				.statusCode(201);
	}

}

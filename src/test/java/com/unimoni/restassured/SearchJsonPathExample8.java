package com.unimoni.restassured;

//Static Import
import static io.restassured.RestAssured.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import com.unimoni.pojo.Student;

public class SearchJsonPathExample8 extends BaseTest {

	// 1) Extract an id
	@Test
	public void test001() {

		Integer id = given().when().get("/1").then().log().all().extract().path("id");

		System.out.println("------------------StartingTest---------------------------");
		System.out.println("The student id: " + id);
		System.out.println("------------------End of Test---------------------------");

	}

	// 2) Extract all ids
	@Test
	public void test002() {

		List<Integer> ids = given().queryParam("programme", "Financial Analysis").when().get("/list").then().log().all()
				.extract().path("id");

		System.out.println("------------------StartingTest---------------------------");
		System.out.println("The total number of items are: " + ids);
		System.out.println("------------------End of Test---------------------------");
	}

	// 3)Extract first student by providing list index value
	@Test
	public void test003() {

		Student student = given().when().get("/1").as(Student.class);

		System.out.println("------------------StartingTest---------------------------");
		System.out.println("The student name is: " + student.getFirstName());
		System.out.println("------------------End of Test---------------------------");
	}

	// 4)Extract all students
	@Test
	public void test004() {

		List<Student> students = Arrays.asList(given().when().get("/list").as(Student[].class));

		System.out.println("------------------StartingTest---------------------------");
		System.out.println("The student name is: " + students.get(0).getFirstName());
		System.out.println("------------------End of Test---------------------------");
	}

	// 5)Print the size of courses
	@Test
	public void test005() {

		int size = given().when().get("/1").then().extract().path("courses.size()");

		System.out.println("------------------StartingTest---------------------------");
		System.out.println("The size of the courses is: " + size);
		System.out.println("------------------End of Test---------------------------");
	}

	// 6) Get the all the values for Courses
	@Test
	public void test006() {

		List<HashMap<String, Object>> values = given().when().get("/list").then().extract()
				.path("courses");

		System.out.println("------------------StartingTest---------------------------");
		System.out.println("The values for Courses: " + values);
		System.out.println("------------------End of Test---------------------------");
	}
}

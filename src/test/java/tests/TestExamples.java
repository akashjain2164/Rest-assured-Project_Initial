package tests;

import org.hamcrest.collection.HasItemInArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestExamples {

	@Test
	public void test_1()
	{

		//RestAssured.baseURI="https://reqres.in/api/users?page=2";
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));

		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
}

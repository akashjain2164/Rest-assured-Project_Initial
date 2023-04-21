package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetAndPostExamples {

	@Test
	public void testGet() //Retrieve the Data
	{

		baseURI = "https://reqres.in/api";
		given().get("/users?page=2").
		then().
		statusCode(200).
		body("data[4].first_name", equalTo("George")).
		body("data.first_name", hasItems("George","Lindsay")).
		body("data.id", hasItems(9,8)); 

	}

	@Test 
	public void testPost()
	{

		Map<String, Object> map = new HashMap<String, Object>();
		
		JSONObject request = new JSONObject(map);
		request.put("name", "Akash");
		request.put("job", "Teacher");
		System.out.println(request.toJSONString());

		baseURI = "https://reqres.in/api";
		given().header("Content-Type","application/json").
		body(request.toJSONString()).when().post("/users").	
		then().statusCode(201).log().all();

	}

}

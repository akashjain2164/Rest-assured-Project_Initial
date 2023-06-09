package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.meta.When;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutPatchDeleteExamples {

	@Test
	public void testPut()
	{

		Map<String, Object> map = new HashMap<String, Object>();

		JSONObject request = new JSONObject(map);
		request.put("name", "Akash");
		request.put("job", "Teacher");
		System.out.println(request.toJSONString());

		baseURI = "https://reqres.in/api";
		given().header("Content-Type","application/json").
		body(request.toJSONString()).when().put("/users/2").	
		then().statusCode(200).log().all();

	}


	@Test
	public void testPatch()
	{

		Map<String, Object> map = new HashMap<String, Object>();
		
		JSONObject request = new JSONObject(map);
		request.put("name", "Akash2 Jain");
		request.put("job", "IT Automation Engineer");
		System.out.println(request.toJSONString());

		baseURI = "https://reqres.in";
		given().header("Content-Type","application/json").
		body(request.toJSONString()).when().patch("/api/users/2").	
		then().statusCode(200).log().all();

	}

	@Test
	public void testDelete()
	{
		baseURI = "https://reqres.in";
		given().when().delete("/api/users/2").then()
		.statusCode(204).log().all();

	}
}

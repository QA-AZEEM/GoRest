package restassured.gorestapi.client;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import io.restassured.response.Response;
import restassured.gorestapi.BaseAPI;
import restassured.gorestapi.extentlistner.ExtentTestListners;
import restassured.gorestapi.model.User;
import restassured.gorestapi.util.Config;

public class UpdateUser extends BaseAPI {
	
	public static String token = Config.get("token");
	public static String id = Config.get("id");
	
	@Test
	public void updateUserDetails() {
		ExtentTest test = ExtentTestListners.getTest();
		User user = new User("Santos", "santos@gmail.com", "male", "active");
		
		Response response = given()
				.pathParam("id", id)
				.header("Authorization", "Bearer " + token)
				.header("Content-Type","application/json")
				.body(user)
				.when()
				.put("/users/{id}")
				.then()
				.extract()
				.response();
		User userResponse = response.as(User.class);
		test.info("response Body " + response.asPrettyString());
		System.out.println(userResponse);
		assertNotNull(userResponse.getId(),"User details not null");
	}
}

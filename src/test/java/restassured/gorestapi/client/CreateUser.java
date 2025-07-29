package restassured.gorestapi.client;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import restassured.gorestapi.BaseAPI;
import restassured.gorestapi.model.User;
import restassured.gorestapi.util.Config;
import restassured.gorestapi.util.TestDataGenerator;



public class CreateUser extends BaseAPI {
	
	public static String token = Config.get("token");
	public static int id;
	@Test
	public void creatNewUser() {
		TestDataGenerator dataGenerator = new TestDataGenerator();
		String name = dataGenerator.getName();
		String email = dataGenerator.getEmail();
		String gender = dataGenerator.getGender();
		User user = new User(name, email, gender, "active");
		Response response = given()
				.header("Authorization", "Bearer " + token)
				.header("Content-Type","application/json")
				.body(user)
				.when()
				.post("/users")
				.then()
				.extract()
				.response();
		
		String responseBody = response.asPrettyString();
		System.out.println(responseBody);
		User userResponseData = response.as(User.class);
		id = userResponseData.getId();
		assertNotNull(userResponseData.getId(),"user id should not be null");
		assertEquals(userResponseData.getStatus(), "active", "User status missmatch");
				
	}
}

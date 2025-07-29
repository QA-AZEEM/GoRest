package restassured.gorestapi.util;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import restassured.gorestapi.BaseAPI;
import restassured.gorestapi.model.User;

public class UserUtil extends BaseAPI {
	
	private static String token = Config.get("token");

	public static int getUserID() {
		TestDataGenerator dataGenerator = new TestDataGenerator();
		String name = dataGenerator.getName();
		String email = dataGenerator.getEmail();
		String gender = dataGenerator.getGender();
		
		User user = new User(name, email, gender, "active");

		Response response = given()
				.header("Authorization", "Bearer " + token)
				.header("Content-Type", "application/json")
				.body(user)
				.when()
				.post("/users")
				.then()
				.statusCode(201)
				.extract()
				.response();

		User createdUser = response.as(User.class);
		return createdUser.getId(); // return the new user ID
	}
}

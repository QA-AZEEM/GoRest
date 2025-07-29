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

public class GetUser extends BaseAPI {
	
	@Test
	public void getUserDetails() {
		String token = Config.get("token");
		CreateUser user = new CreateUser();
		user.creatNewUser();
		int userid = CreateUser.id;
		
		Response response = given()
				.pathParam("id", userid)
				.header("Authorization","Bearer "+token)
				.header("Content-Type","application/json")
				.when()
				.get("/users/{id}")
				.then()
				.extract()
				.response();
		User getUserResponse = response.as(User.class);
		
		System.out.println("Id " + getUserResponse.getId());
	}
}

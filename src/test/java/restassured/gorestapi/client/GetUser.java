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

public class GetUser extends BaseAPI {
	
	@Test
	public void getUserDetails() {
		ExtentTest test = ExtentTestListners.getTest();
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
		test.info(response.asPrettyString());
		assertNotNull(getUserResponse.getId(),"User id should not be null");
		assertNotNull(getUserResponse.getName(),"User name should not be null");
		assertNotNull(getUserResponse.getEmail(),"User email should not be null");
		assertNotNull(getUserResponse.getGender(),"User gender should not be null");
		assertEquals(getUserResponse.getStatus(), "active");
		test.pass("User details not null");
	}
}

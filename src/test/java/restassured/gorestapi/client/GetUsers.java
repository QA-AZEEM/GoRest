package restassured.gorestapi.client;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import restassured.gorestapi.BaseAPI;
import restassured.gorestapi.model.User;
import restassured.gorestapi.util.Config;

public class GetUsers extends BaseAPI {
	
	public static String token = Config.get("token");
	
	@Test
	public void getUserList() {
		
		Response response = given()
				.header("Authorization","Bearer " + token)
				.header("Content-Type","application/json")
				.when()
				.get("/users")
				.then()
				.extract()
				.response();
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<User> users = mapper.readValue(response.asString(), new TypeReference<List<User>>() {
			});
			
			for(User user : users) {
				System.out.println("Name " + user.getName() + "Email " + user.getEmail() + "Gender " + user.getGender() + "Status " + user.getStatus());
			}
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}

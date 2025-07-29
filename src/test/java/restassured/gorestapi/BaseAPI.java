package restassured.gorestapi;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import restassured.gorestapi.util.Config;

public class BaseAPI {
	
	private String baseurl = Config.get("baseurl");
	
	@BeforeSuite
	public void setUpBaseUrl() {
		RestAssured.baseURI = baseurl;
	}
}

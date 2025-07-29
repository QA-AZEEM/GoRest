package restassured.gorestapi.util;

import com.github.javafaker.Faker;

public class TestDataGenerator {
	
	private String email;
	private String name;
	private String gender;
	Faker faker = new Faker();
	
	public String getEmail() {
		return faker.internet().emailAddress();
	}
	public String getName() {
		return faker.name().fullName();
	}
	public String getGender() {
		return faker.demographic().sex();
	}
	
}

package restassured.gorestapi.model;

public class User {
	
	private int id;
	private String name;
	private String email;
	private String gender;
	private String status;
	
	public User() {
		
	}
	
	public User(String name, String email, String gender, String status) {
		super();
		//this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", gender=" + gender + ", status=" + status
				+ "]";
	}
	
	
}

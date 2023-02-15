package user;

public class Person {
	public String name;
	public int age;
	public String gender;
	public String username;
	public String password;
	
	public Person(String name, int age, String gender) {
		this.name = name;
		this.age = age; 
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age; 
	}
	
	public String getGender() { 
		return gender;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

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
	 
	// setUsername, setPassword dddd

}

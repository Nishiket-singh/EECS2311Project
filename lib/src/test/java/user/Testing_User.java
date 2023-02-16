package user;

import static org.junit.jupiter.api.Assertions.*;

// import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

class Testing_User {
	
	@Test
	public void testGetName() {
		Person p = new Person("John Doe", 30, "Male");
		assertEquals("John Doe", p.getName());
	}
	
	@Test
	public void testGetAge() {
		Person p = new Person("Jane Doe", 25, "Female");
		assertEquals(25, p.getAge());
	}
	
	@Test
	public void testGetGender() {
		Person p = new Person("Alex Smith", 45, "Non-binary");
		assertEquals("Non-binary", p.getGender());
	}
	
	@Test
	public void testSetUsername() {
		Person p = new Person("Bob Johnson", 20, "Male");
		p.setUsername("bob123");
		assertEquals("bob123", p.username);
	}
	
	@Test
	public void testSetPassword() {
		Person p = new Person("Sarah Lee", 35, "Female");
		p.setPassword("password123");
		assertEquals("password123", p.password);
	}



	}

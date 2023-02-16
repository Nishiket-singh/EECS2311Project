package user;

import static org.junit.jupiter.api.Assertions.*;

// import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class Testing_User {

	@Test
	public void testGetName() {
		Person p = new Person("Mackenzie Doe", 30, "Female");
		assertEquals("Mackenzie Doe", p.getName());
	}

	@Test
	public void testGetAge() {
		Person p = new Person("Jane McEnroe", 25, "Female");
		assertEquals(25, p.getAge());
	}

	@Test
	public void testGetGender() {
		Person p = new Person("Alex Smith", 45, "Male");
		assertEquals("Male", p.getGender());
	}

	@Test
	public void testSetUsername() {
		Person p = new Person("Bobby Johnson", 20, "Male");
		p.setUsername("bob123");
		assertEquals("bob123", p.username);
	}

	@Test
	public void testSetPassword() {
		Person p = new Person("Ferris Lee", 35, "Female");
		p.setPassword("password123!");
		assertEquals("password123!", p.password);
	}
	@Test
	public void testGetCommentsEmpty() {
		Comments c = new Comments("JK Silvie", 30, "Male");
		assertTrue(c.getComments().isEmpty());
	}

	@Test
	public void testSetComments() {
		Comments c = new Comments("Brianna Thompson", 25, "Female");
		ArrayList<String> comments = new ArrayList<String>();
		comments.add("This is a tester comment.");
		c.setComments(comments);
		assertEquals(comments, c.getComments());
	}

	@Test
	public void testAddComment() {
		Comments c = new Comments("Kabi Raa", 45, "Female");
		c.getComments().add("This is another test comment.");
		assertEquals(1, c.getComments().size());
	}

	@Test
	public void testMultipleComments() {
		Comments c = new Comments("Boston Masy", 20, "Male");
		c.getComments().add("Display content.");
		c.getComments().add("This is another test comment.");
		assertEquals(2, c.getComments().size());
	}
}




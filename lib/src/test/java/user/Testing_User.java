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
	
	public class RatingsTest {
		
		@Test
		public void testGetDislikeEmpty() {
			Ratings r = new Ratings("Shirley Frod", 30, "Female");
			assertTrue(r.getDislike().isEmpty());
		}
		
		@Test
		public void testSetDislike() {
			Ratings r = new Ratings("Ken Shelly", 25, "Male");
			ArrayList<String> dislike = new ArrayList<String>();
			dislike.add("item1");
			dislike.add("item2");
			r.setDislike(dislike);
			assertEquals(dislike, r.getDislike());
		}
		
		@Test
		public void testGetLikeEmpty() {
			Ratings r = new Ratings("Daniel Hastings", 45, "Non-binary");
			assertTrue(r.getLike().isEmpty());
		}
		
		@Test
		public void testSetLike() {
			Ratings r = new Ratings("Donald Robertson", 20, "Male");
			ArrayList<String> like = new ArrayList<String>();
			like.add("item3");
			like.add("item4");
			r.setLike(like);
			assertEquals(like, r.getLike());
		}
		
		@Test
		public void testMultipleLikes() {
			Ratings r = new Ratings("Sarah Jessica Parker", 35, "Female");
			r.getLike().add("item5");
			r.getLike().add("item6");
			assertEquals(2, r.getLike().size());
		}
		
		@Test
		public void testMultipleDislikes() {
			Ratings r = new Ratings("Peter Gho", 45, "Non-binary");
			r.getDislike().add("item7");
			r.getDislike().add("item8");
			assertEquals(2, r.getDislike().size());
		}
	}
	
	public class CategoriesTest {
		
		@Test
		public void testGetCategoriesEmpty() {
			Categories c = new Categories("Mary Lana", 30, "Female");
			assertTrue(c.getCategories().isEmpty());
		}
		
		@Test
		public void testSetCategories() {
			Categories c = new Categories("Jasmine Sands", 25, "Female");
			ArrayList<String> categories = new ArrayList<String>();
			categories.add("category1");
			categories.add("category2");
			c.setCategories(categories);
			assertEquals(categories, c.getCategories());
		}
		
		@Test
		public void testMultipleCategories() {
			Categories c = new Categories("Bruno Ferris", 45, "Non-binary");
			c.getCategories().add("category3");
			c.getCategories().add("category4");
			assertEquals(2, c.getCategories().size());
		}
	}
}




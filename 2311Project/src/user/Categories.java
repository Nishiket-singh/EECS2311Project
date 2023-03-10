package user;

import java.util.ArrayList;

public class Categories extends Person {
	
	public Categories(String name, int age, String gender) {
		super(name, age, gender);
	}
	
	ArrayList<String> categories = new ArrayList<String>();

	public ArrayList<String> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<String> categories) {
		this.categories = categories;
	}
	
}

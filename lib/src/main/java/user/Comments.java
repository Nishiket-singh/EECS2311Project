package user;

import java.util.*;

public class Comments extends Person { //inherit person, person is super class
	
	public Comments(String name, int age, String gender) {
		super(name, age, gender);
	}

	ArrayList<String> comments = new ArrayList<String>();
	
	public ArrayList<String> getComments() {
		return comments;
	}

	public void setComments(ArrayList<String> comments) {
		this.comments = comments;
	}

	

}

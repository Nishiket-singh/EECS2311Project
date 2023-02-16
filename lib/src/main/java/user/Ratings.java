package user;

import java.util.ArrayList;

public class Ratings extends Person {
	
	public Ratings(String name, int age, String gender) {
		super(name, age, gender);
	}

	
	ArrayList<String> dislike = new ArrayList<String>();
	ArrayList<String> like = new ArrayList<String>();
	
	public ArrayList<String> getDislike() {
		return dislike;
	}
	public void setDislike(ArrayList<String> dislike) {
		this.dislike = dislike;
	}
	public ArrayList<String> getLike() {
		return like;
	}
	public void setLike(ArrayList<String> like) {
		this.like = like;
	}
	
}

package tp3;

import java.util.ArrayList;

public class User {
			
	int id;
	String username;
	String password;
	ArrayList<Salle> sallesSuscribed ;   
	ArrayList<Messges> msgUsagers ;   
	
	public User(String username, String password, int id) {
		this.password = password;
		this.username = username;
	}
	public User(String username, String password, ArrayList<Salle> sallesSuscribed, ArrayList<Messges> msgUsagers) {
		this.password = password;
		this.username = username;
		this.sallesSuscribed= sallesSuscribed;
		this.msgUsagers = msgUsagers;
	}

	
	public String toString() {
		return "username: " + username +" pass: " + password +" id:" + id;
	}

}

package tp3;

import java.util.ArrayList;

import observerPattern.Observer;

public class User implements Observer {

	int id;
	String username;
	String password;
	ArrayList<Salle> sallesSuscribed ;   
	ArrayList<Messges> msgUsagers ;   
	
	public User(String username, String password, int id) {
		this.password = password;
		this.username = username;
		this.id = id;
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
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Salle> getSallesSuscribed() {
		return sallesSuscribed;
	}

	public void setSallesSuscribed(ArrayList<Salle> sallesSuscribed) {
		this.sallesSuscribed = sallesSuscribed;
	}

	public ArrayList<Messges> getMsgUsagers() {
		return msgUsagers;
	}

	public void setMsgUsagers(ArrayList<Messges> msgUsagers) {
		this.msgUsagers = msgUsagers;
	}

}

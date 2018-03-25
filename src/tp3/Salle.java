package tp3;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xpath.internal.axes.SelfIteratorNoPredicate;

import observerPattern.Observer;
import observerPattern.Subject;
public class Salle extends Subject implements Observer {
	/**/
	
	//Server.getInstance() retourne un singleton, e.g. la Classe server a un patron de conception Singleton
	Server server;
	
	String salleNom;
	int id;
	int likeCount;
	int dislikeCount;
	
	//Constructeur pour reconstituer une salle déjà en mémoire
	public Salle(String salleNom, int id, int likeCount, int dislikeCount, ArrayList<User> suscribersList, ArrayList<Messges> messagesList) {
		this.salleNom = salleNom;
		this.id = id;
		this.dislikeCount = dislikeCount;
		this.likeCount = likeCount;

		server = Server.getInstance();
		
	}
	
	//création d'une nouvelle salle
	public Salle(String salleNom, int id) {
		this.salleNom = salleNom;
		this.id = id;
		this.dislikeCount = 0;
		this.likeCount = 0;
		System.out.println("Salle créée:" + salleNom + " id:" + id);
	}
	
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		return salleNom + " id:" + id + "list suscriber:" + getSuscriberSalle().toString();
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public String getSalleNom() {
		return salleNom;
	}

	public void setSalleNom(String salleNom) {
		this.salleNom = salleNom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getDislikeCount() {
		return dislikeCount;
	}

	public void setDislikeCount(int dislikeCount) {
		this.dislikeCount = dislikeCount;
	}

	

}

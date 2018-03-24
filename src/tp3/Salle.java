package tp3;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xpath.internal.axes.SelfIteratorNoPredicate;

import observerPattern.Observer;
public class Salle extends Observer {
	/**/
	
	//Server.getInstance() retourne un singleton, e.g. la Classe server a un patron de conception Singleton
	Server server;
	
	String salleNom;
	int id;
	int likeCount;
	int dislikeCount;
	ArrayList<User> suscribersList ;   
	ArrayList<Messges> messagesList ;   
	
	//Constructeur pour reconstituer une salle déjà en mémoire
	public Salle(String salleNom, int id, int likeCount, int dislikeCount, ArrayList<User> suscribersList, ArrayList<Messges> messagesList) {
		this.salleNom = salleNom;
		this.id = id;
		this.dislikeCount = dislikeCount;
		this.likeCount = likeCount;
		this.suscribersList = suscribersList;
		this.messagesList = messagesList;
		server = Server.getInstance();
		
	}
	
	//création d'une nouvelle salle
	public Salle(String salleNom, int id) {
		this.salleNom = salleNom;
		this.id = id;
		this.dislikeCount = 0;
		this.likeCount = 0;
		this.suscribersList = new ArrayList<User>();
		this.messagesList = new ArrayList<Messges>();
		System.out.println("Salle créée:" + salleNom + " id:" + id);
	}
	
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		return salleNom + " id:" + id;
	}
	
	

}

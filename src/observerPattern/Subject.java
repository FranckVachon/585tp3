package observerPattern;

import java.util.ArrayList;
import java.util.List;

import tp3.Salle;
import tp3.User;


public class Subject {
	//Pour la gestion des salles actives et la redirection des messages reçus sur le port UDP vers la bonne URI
	// Gestion des usagers similairement
    private List<Salle> salles = new ArrayList<>();
    private List<User> usagers = new ArrayList<>();
    
    //Gestion des suscribers - chaque salle dispose d'une list suscriberSalle et y ajoute les usagers 
    private List<User> suscribersSalle = new ArrayList<>();

    public void attachSalle(Salle s) {
    	System.out.println("Salle attachée: " + s.toString());
    	System.out.println("Nombre de salles: " + salles.size());

    	salles.add(s);
    }
    
    public void attachUsager(User u) {
    	System.out.println("Usager attachée: " + u.toString());
    	System.out.println("Nombre usagers: " + usagers.size());

    	usagers.add(u);
    }
    
    public void attachSuscriber(User u) {
    	System.out.println("Sucriber attachée: " + u.toString());
    	System.out.println("Nombre suscriber: " + suscribersSalle.size());
    	suscribersSalle.add(u);
    }
    
    public int getSalleCount() {
		return salles.size();
	}
    
    public int getUserCount() {
		return usagers.size();
	}
    
    public List<Salle> getSalles() {
		return salles;
	}
    
    public List<User> getUsers() {
		return usagers;
	}
    public List<User> getSuscriberSalle() {
		return suscribersSalle;
	}
}


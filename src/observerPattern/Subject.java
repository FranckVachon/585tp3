package observerPattern;

import java.util.ArrayList;
import java.util.List;

import tp3.Salle;
import tp3.User;


public class Subject {
	//Pour la gestion des salles actives et la redirection des messages reçus sur le port UDP vers la bonne URI
	// Gestion des usagers similairement
    private List<Observer> salles = new ArrayList<>();
    private List<User> usagers = new ArrayList<>();

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


    private void execute() {
        for (Observer s : salles) {
        	System.out.println("Update salles: " + s.toString());
            s.update();
        }
    }
    
    public int getSalleCount() {
		return salles.size();
	}
    
    public int getUserCount() {
		return usagers.size();
	}
}


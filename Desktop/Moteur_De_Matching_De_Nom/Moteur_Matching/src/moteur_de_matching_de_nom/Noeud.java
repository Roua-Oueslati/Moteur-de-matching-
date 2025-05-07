package moteur_de_matching_de_nom;

import java.util.ArrayList;
import java.util.List;

public class Noeud {
	    char lettre;
	    boolean estFinMot;
	    List<Noeud> fils ;

	    public Noeud(char lettre) {
	        this.lettre = lettre;
	        this.estFinMot = false;
	        this.fils = new ArrayList<>();
	    }

	    // Recherche un enfant avec une lettre spécifique
	    public Noeud trouverEnfant(char lettre) {
	        for (Noeud enfant : fils) {
	            if (enfant.lettre == lettre) {
	                return enfant;
	            }
	        }
	        return null;
	    }

	    // Ajoute un enfant avec une lettre spécifique
	    public Noeud ajouterEnfant(char lettre) {
	        Noeud nouvelEnfant = new Noeud(lettre);
	        fils.add(nouvelEnfant);
	        return nouvelEnfant;
	    }
	    
	    
}


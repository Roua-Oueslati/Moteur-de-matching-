package moteur_de_matching_de_nom;

import java.util.Scanner;

public class MenuGenerateurDeCnadidat {

	public static GenerateurDeCandidat choisirGenerateur(Scanner scanner) {
		
		GenerateurDeCandidat generateur = null;
		
		System.out.println("--- MENU GENERATEUR DE CANDIDAT ---");
        System.out.println("1. Générateur de candidat par index");
        System.out.println("2. Génerateur de candidat Trivial");
        System.out.println("3. Générateur de candidat selon la taille ");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();

        switch (choix) {
            case 1:
            	IndexDictionnaire index = new IndexDictionnaire();
            	generateur = new GenerateurDeCandidatParIndex(index);
                break;
                
            case 2:
            	generateur = new GenerateurTrivial();
            	break;
            	
            case 3:
            	generateur = new GenerateurDeCandidatSelonLaTaille();          	
            	break;
            	
            default:
                System.out.println("Choix invalide ! ");
        }
        return generateur;
    }

}


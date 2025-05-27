package moteur_de_matching_de_nom;

import java.util.Scanner;

public class MenuGenerateurDeCnadidat {

	public static GenerateurDeCandidat choisirGenerateur(Scanner scanner) {
		
		GenerateurDeCandidat generator = null;
		Indexeur index = null;
		System.out.println("--- MENU GENERATEUR DE CANDIDAT ---");
        System.out.println("1. Générateur de candidat par index");
        System.out.println("2. Génerateur de candidat Trivial");
        System.out.println("3. Générateur de candidat selon la taille ");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();

        switch (choix) {
            case 1:
            	
            	GenerateurDeCandidatParIndex generateur = new GenerateurDeCandidatParIndex(index);
            	generator = (GenerateurDeCandidat) generateur;
            	
                break;

                
            case 2:
            	GenerateurTrivial generateur1 = new GenerateurTrivial();
            	generator = (GenerateurDeCandidat) generateur1;
            	break;
            	
            case 3:
            	GenerateurDeCandidatSelonLaTaille generateur2 = new GenerateurDeCandidatSelonLaTaille();   
            	generator = (GenerateurDeCandidat) generateur2;
            	break;
            	
            default:
                System.out.println("Choix invalide ! ");
        }
        return generator;
    }
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GenerateurDeCandidat generateur = choisirGenerateur(scanner);

        if (generateur != null) {
            System.out.println("Générateur sélectionné : " + generateur.getClass().getSimpleName());
        } else {
            System.out.println("Aucun générateur n'a été sélectionné.");
        }

        scanner.close();
    }


}


package moteur_de_matching_de_nom;


import java.util.Scanner;

public class MenuComparateur {

	public static ComparateurNom choisirComparateur(Scanner scanner) {
		
		ComparateurNom comparateurNom = null;
		
		System.out.println("--- MENU COMPARATEUR DE NOM ---");
        System.out.println("1. Comparateur de nom sans comparateur de chaine");
        System.out.println("2. Comparateur de nom avec comparateur de chaine");
        System.out.println("3. Comparateur de nom avec liste prétraitée ");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();

        switch (choix) {
            case 1:
            	comparateurNom  = new ComparateurNomSansComparateurDeChaine();
                break;
            case 2:
            	System.out.println("Choisir le comparateur à utiliser :");
            	System.out.println("1. Jaro Winkler ");
            	System.out.println("2. Levenshtein ");
            	int choice = scanner.nextInt();
            	switch (choice) {
            		case 1:
            			JaroWinkler jaro= new JaroWinkler();
            			comparateurNom  = new ComparateurNomAvecComparateurChaine(jaro);
                    	break;
            		case 2:
            			Levenshtein lev= new Levenshtein();
            			comparateurNom  = new ComparateurNomAvecComparateurChaine(lev);
                    	break;
                    default:
                    	System.out.println("choix invalide !");
            	}
            	
            	break;
            case 3:
            	comparateurNom  = new ComparateurNomAveclistePretraite();            	
            	break;
            default:
                System.out.println("Choix invalide !");
                
        }
        return comparateurNom ;
    }

}

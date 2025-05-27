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
            	ComparateurNomSansComparateurDeChaine comp  = new ComparateurNomSansComparateurDeChaine();
            	comparateurNom = (ComparateurNom) comp;
                break;
            case 2:
            	System.out.println("Choisir le comparateur à utiliser :");
            	System.out.println("1. Jaro Winkler ");
            	System.out.println("2. Levenshtein ");
            	int choice = scanner.nextInt();
            	switch (choice) {
            		case 1:
            			 JaroWinkler jaro= new JaroWinkler();
            			 ComparateurNomAvecComparateurChaine comp2  = new ComparateurNomAvecComparateurChaine(jaro);
            			 comparateurNom = (ComparateurNom) comp2;
                    	break;
            		case 2:
            			Levenshtein lev= new Levenshtein();
            			ComparateurNomAvecComparateurChaine comp3  = new ComparateurNomAvecComparateurChaine(lev);
            			comparateurNom = (ComparateurNom) comp3;
                    	break;
                    default:
                    	System.out.println("choix invalide !");
            	}
            	
            	break;
            case 3:
            	ComparateurNomAveclistePretraite comp4  = new ComparateurNomAveclistePretraite();  
            	comparateurNom = (ComparateurNom) comp4;
            	break;
            default:
                System.out.println("Choix invalide !");
                
        }
        return comparateurNom ;
    }
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComparateurNom compNom = choisirComparateur(scanner);

        if (compNom != null) {
            System.out.println("Comparateur sélectionné : " + compNom.getClass().getSimpleName());
        } else {
            System.out.println("Aucun comparateur n'a été sélectionné.");
        }

        scanner.close();
    }

}

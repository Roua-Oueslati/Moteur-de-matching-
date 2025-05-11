package moteur_de_matching_de_nom;


import java.util.Scanner;

public class MenuPretraiteur {

	public static Preprocesseur choisirPretraiteur(Scanner scanner) {
		
		Preprocesseur preprocesseur = null;
		
		System.out.println("--- MENU PRETRAITEUR ---");
        System.out.println("1. Prétraitement par encodeur phonétique");
        System.out.println("2. Prétraitement par encodeur soundex");
        System.out.println("3. Prétraitement par normaliseur");
        System.out.println("4. Auncun prétraitement");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine(); 
        switch (choix) {
            case 1:
            	preprocesseur = new  EncodeurPhonétique();	
                break;
                
            case 2:
            	preprocesseur = new EncodeurSoundex();
            	break;
            	
            case 3:
            	preprocesseur = new Normaliseur();
            	break;
            case 4 :
            	break;
            default:
                System.out.println("Choix invalide !"); 
        }
        return preprocesseur;
    }


}

	


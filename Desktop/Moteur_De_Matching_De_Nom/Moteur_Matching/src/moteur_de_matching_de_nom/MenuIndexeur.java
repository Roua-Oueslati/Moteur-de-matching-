package moteur_de_matching_de_nom;


import java.util.Scanner;

public class MenuIndexeur {

	public static Indexeur choisirIndexeur(Scanner scanner) {
		
		Indexeur indexeur = null;
		
		System.out.println("--- MENU INDEXEUR ---");
        System.out.println("1. Indexation dans un dictionnaire");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();

        switch (choix) {
            case 1:
            	IndexDictionnaire index = new IndexDictionnaire();
            	indexeur = (Indexeur) index;
                break;
           
            default:
                System.out.println("Choix invalide !");
        }
        return indexeur;
    }

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Indexeur indexeur = choisirIndexeur(scanner);

        if (indexeur != null) {
            System.out.println("Indexeur sélectionné : " + indexeur.getClass().getSimpleName());
        } else {
            System.out.println("Aucun indexeur n'a été sélectionné.");
        }

        scanner.close();
    }



}

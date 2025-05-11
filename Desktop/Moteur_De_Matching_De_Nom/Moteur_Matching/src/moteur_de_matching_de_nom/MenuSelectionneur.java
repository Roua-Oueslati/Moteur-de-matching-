package moteur_de_matching_de_nom;


import java.util.Scanner;

public class MenuSelectionneur {

	
	public static SelectionneurDeResultat choisirSelectionneur(Scanner scanner) {
		
		SelectionneurDeResultat selectionneur = null;
		
		System.out.println("--- MENU SELECTIONNEUR DE RESULTAT ---");
        System.out.println("1. Sélectionneur avec max de resultat");
        System.out.println("2. Sélectionneur par seuil");
        System.out.println("3. Sélectionneur sans option");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();

        switch (choix) {
            case 1:
            	System.out.println("Choisir le nombre de resultats : ");
            	int maxResultat = scanner.nextInt();
            	selectionneur = new SelectionneurAvecMaxResultat(maxResultat);
                break;
                
            case 2:
            	System.out.println("Choisir le seuil : ");
            	double seuil = scanner.nextDouble();
            	selectionneur = new SelectionneurParSeuil(seuil);
                break;
                
            case 3:            	
            	selectionneur= new SelectionneurDeRésultatSansOptions();
                break;
                
            default:
                System.out.println("Choix invalide !");

        }
        return selectionneur;
    }



	

}

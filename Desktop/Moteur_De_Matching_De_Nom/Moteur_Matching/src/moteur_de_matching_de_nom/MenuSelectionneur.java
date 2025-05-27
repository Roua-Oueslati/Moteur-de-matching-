package moteur_de_matching_de_nom;


import java.util.Scanner;

public class MenuSelectionneur {

	
	public static SelectionneurDeResultat choisirSelectionneur(Scanner scanner) {
		SelectionneurDeResultat selector = null;
		
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
            	SelectionneurAvecMaxResultat selectionneur = new SelectionneurAvecMaxResultat(maxResultat);
            	selector =(SelectionneurDeResultat) selectionneur;
                break;
                
            case 2:
            	System.out.println("Choisir le seuil : ");
            	double seuil = scanner.nextDouble();
            	SelectionneurParSeuil selectionneur1 = new SelectionneurParSeuil(seuil);
            	selector = (SelectionneurDeResultat) selectionneur1;
                break;
                
            case 3:            	
            	SelectionneurDeRésultatSansOptions selectionneur2 = new SelectionneurDeRésultatSansOptions();
            	selector = (SelectionneurDeResultat) selectionneur2;
                break;
                
            default:
                System.out.println("Choix invalide !");

        }
        return selector;
    }
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SelectionneurDeResultat selectionneur = choisirSelectionneur(scanner);

        if (selectionneur != null) {
            System.out.println("Sélectionneur sélectionné : " + selectionneur.getClass().getSimpleName());
        } else {
            System.out.println("Aucun sélectionneur n'a été sélectionné.");
        }

        scanner.close();
    }



	

}

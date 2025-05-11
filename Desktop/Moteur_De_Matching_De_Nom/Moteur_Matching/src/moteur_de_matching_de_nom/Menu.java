package moteur_de_matching_de_nom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
        int choix;
        int choice;
        String nom;
        String path1;
        int maxresult =0;
        double seuil = 0.0;
        SelectionneurDeResultat selector = null;
        ComparateurNom compNom = null;
        GenerateurDeCandidat genCand = null;
        Preprocesseur preprocesseur = null;
        Indexeur index = null;
        ComparateurNom compChaine = null;
        
        //initialisation des parametres par defaut :
        compNom = new ComparateurNomSansComparateurDeChaine();
        /*EncodeurPhonétique encod = new EncodeurPhonétique();
        List<String> liste= new ArrayList<String>();
        liste=encod.prétraiter(liste1);
        Levenshtein lev = new Levenshtein();
        ComparateurNomAvecComparateurChaine comparateurNom = new ComparateurNomAvecComparateurChaine(lev);*/
        
		selector = new SelectionneurDeRésultatSansOptions();
		genCand = new GenerateurDeCandidatSelonLaTaille();
		List<IdNomScore> listeDeRecherche = new ArrayList<IdNomScore>();
		Moteur moteur = new Moteur(genCand,selector,compNom);
        
        
        
        do {
        	System.out.println("-------------------------------------");
            System.out.println("========== MENU ==========");
            System.out.println("1. Effectuer une recherche");
            System.out.println("2. Comparer deux listes");
            System.out.println("3. Dédupliquer une liste");
            System.out.println("4. Séléctionner les générateurs et les sélectionneurs");
            System.out.println("5. Configurer les paramètres");
            System.out.println("6. Quitter");
            System.out.println("-------------------------------------");
            System.out.print("Votre choix : ");
            
            choix = scanner.nextInt();
            scanner.nextLine(); // pour consommer le saut de ligne

            switch (choix) {
            
                case 1:
                	
                    System.out.println("Saisir  le nom à rechercher:");
                    nom= scanner.nextLine();

		            System.out.println("Fournir le fichier CSV:");
		            path1 = scanner.nextLine();		            
		            List<Nom> liste1 = new ArrayList<Nom>();		            
		            Nom nomAChercher = new Nom("0", nom);
		            RecuperateurCSV recuperateur1 = new RecuperateurCSV(path1);
		            liste1=recuperateur1.recuperer();
		            System.out.println("Nombre d'éléments dans liste1: " + liste1.size());
					listeDeRecherche=moteur.rechercher(nomAChercher, liste1);
					System.out.println("Résultat de recherche de "+nomAChercher.getNomOriginal()+": ");
					for (IdNomScore element : listeDeRecherche) {
					    System.out.println(element.toString());
					}
		                      
                    break;
                    
                case 2:
                	System.out.println("Fournir le premier fichier CSV:");
		            String path2 = scanner.nextLine();		            
		            System.out.println("Fournir le deuxième fichier CSV:");
		            String path3 = scanner.nextLine();		            
		            RecuperateurCSV recuperateur2 = new RecuperateurCSV(path2);
		            List<Nom>liste2=recuperateur2.recuperer();
		            RecuperateurCSV recuperateur3 = new RecuperateurCSV(path3);
		            List<Nom>liste3=recuperateur3.recuperer();
		            List<Nom> listeDeComparaison = moteur.comparer(liste2, liste3);
		            
		    		System.out.println("Résultat de comparaison:");
		    		for (Nom element : listeDeComparaison) {
		    		    System.out.println(element.toString());
		    		}
		            
                    break;
                    
                case 3:
                	System.out.println("Fournir le fichier CSV à traiter:");
		            String path4 = scanner.nextLine();		            
		            RecuperateurCSV recuperateur4 = new RecuperateurCSV(path4);
		            List<Nom>liste4=recuperateur4.recuperer();
		            List<Nom> listeDédupliquée = moteur.dedupliquer(liste4);
		            System.out.println("Résultat de la déduplication:");
		    		for (Nom element : listeDédupliquée) {
		    		    System.out.println(element.toString());
		    		}
                    break;
                case 4 :
                	do{
                		System.out.println("-------------------------------------");
                		System.out.println("1. choisir le Sélectionneur ");
                		System.out.println("2. choisir le Générateur  ");
                		System.out.println("3. Retour au menu");
                		System.out.println("-------------------------------------");
                		System.out.print("Votre choix : ");
                		choice = scanner.nextInt();
                		switch(choice) {
                			case 1:
                				selector = MenuSelectionneur.choisirSelectionneur(scanner);                	 
                				break;
                			case 2 :
                				genCand = MenuGenerateurDeCnadidat.choisirGenerateur(scanner);
                				break;
                			case 3 :
                				System.out.println("Retour au menu");
                			default : 
                				System.out.println("choix invalide");
                		}
                	moteur = new Moteur(genCand,selector,compNom);
                	System.out.println("Moteur mis à jour avec les nouveaux paramètres.");
                	}while(choice !=3);
                	break;
                case 5:
                	do {
                	System.out.println("-------------------------------------");
                	System.out.println("======= Choisir votre configuration ======");              	
                	System.out.println("1. choisir le prétraitement "); 
                	System.out.println("2. choisir une structure d'index ");
                	System.out.println("3. choisir une mesure de comparaison ");
                	System.out.println("4. Définir un max de résultat ");
                	System.out.println("5. Définir un seuil ");
                	System.out.println("6. Retour au menu");
                	System.out.println("-------------------------------------");
                	System.out.print("Votre choix : ");
                	choice = scanner.nextInt();
                    switch (choice) {
                    
                    	case 1 :
                    		preprocesseur = MenuPretraiteur.choisirPretraiteur(scanner);
                    		break;
                    	case 2 :
                    		index= MenuIndexeur.choisirIndexeur(scanner);
                    		break;
                    	case 3 :
                    		compChaine =  MenuComparateur.choisirComparateur(scanner);
                    		break;
                    	case 4 :
                    		System.out.print("Entrer le nombre maximum de résultats : ");
                    		 maxresult= scanner.nextInt();
                    		break;
                    	case 5:
                    		System.out.print("Entrer le seuil  : ");
                    		 seuil= scanner.nextDouble();
                    		break;
                    	case 6:
                    		System.out.println("Retour au menu");
                    		break;
                    	default:
                    		System.out.println("choix invalide.");
                    }
		            Configuration config = new Configuration(preprocesseur, index, compChaine, seuil, maxresult);
		            moteur = new Moteur(genCand, selector, compChaine, config, preprocesseur);
		            System.out.println("Configuration mise à jour.");
                	
                	}while(choice !=6);
                	break;
                case 6:
                	System.out.println("Quitter");
                	break;
                default:
                    System.out.println("Choix invalide. Réessayez.");
            }

            System.out.println(); // ligne vide pour l'affichage

        } while (choix != 6);

        scanner.close();
    }

}



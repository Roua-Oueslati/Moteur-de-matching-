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
            	EncodeurPhonétique prepro = new  EncodeurPhonétique();	
            	preprocesseur = (Preprocesseur) prepro;
                break;
                
            case 2:
            	EncodeurSoundex prepro1 = new EncodeurSoundex();
            	preprocesseur = (Preprocesseur) prepro1;
            	break;
            	
            case 3:
            	Normaliseur prepro2 = new Normaliseur();
            	preprocesseur = (Preprocesseur) prepro2;

            	break;
            case 4 :
            	break;
            default:
                System.out.println("Choix invalide !"); 
        }
        return preprocesseur;
    }
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Preprocesseur preprocesseur = choisirPretraiteur(scanner);

        if (preprocesseur != null) {
            System.out.println("Préprocesseur sélectionné : " + preprocesseur.getClass().getSimpleName());
        } else {
            System.out.println("Aucun prétraitement sélectionné.");
        }

        scanner.close();
    }


}

	


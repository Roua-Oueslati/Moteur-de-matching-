package moteur_de_matching_de_nom;

import java.util.List;
import java.util.ArrayList;

public class ProgrammePrincipal {

    public static void main(String[] args) {
        Nom nomRecherche = new Nom("kim Sung-du", "0");

       // List<Nom> list = new ArrayList<>();
       // list.add(new Nom("Mohamed ben Salem", "1"));
        //list.add(new Nom("Muhammed Ben Salim", "2"));
        //list.add(new Nom("Mohammed Ben Slim", "3"));
        //list.add(new Nom("Ahmad Ben Saleh", "4"));
        //list.add(new Nom("Mohamet Ben Salim", "5"));
        //list.add(new Nom("Mohammed Ibn Salim", "6"));
        //list.add(new Nom("Mouhamad Bensalem", "7"));
        //list.add(new Nom("Jaafar Ibn Ali", "8"));
        //list.add(new Nom("Sara Ben Ahmed", "9"));
        //list.add(new Nom("Ali Ben Youssef", "10"));
        
        System.out.println("Nom recherché: " + nomRecherche.getNomOriginal());
        RecuperateurCSV recep = new RecuperateurCSV("C:/Users/user/Downloads/peps_names_100.csv");
        List<Nom> list= recep.recuperer();
        //EncodeurPhonétique encodeur = new EncodeurPhonétique();
        //EncodeurSoundex encodeur = new EncodeurSoundex();
        //Normaliseur encodeur = new Normaliseur();
        //IndexArbre index = new IndexArbre();
       // IndexDictionnaire index = new IndexDictionnaire();
        
       //pretraiterNoms(nomRecherche, list, encodeur);
        
        //List<String> nomsPretraites = new ArrayList<>();
        //for (Nom nom : list) {
          //for (String partie : nom.getListDeNomPretraite()) {
                //nomsPretraites.add(partie);
           // }
        //}
        //index.indexer(nomsPretraites);
        
        //GenerateurDeCandidatSelonLaTaille generateur = new GenerateurDeCandidatSelonLaTaille();
        GenerateurTrivial generateur = new GenerateurTrivial();
        // Comparateur de noms avec liste prétraitée
        //ComparateurNomAveclistePretraite comparateur = new ComparateurNomAveclistePretraite();
        Levenshtein lev = new Levenshtein();
       // ComparateurNomSansComparateurDeChaine comparateur = new ComparateurNomSansComparateurDeChaine();
        ComparateurNomAvecComparateurChaine comparateur = new ComparateurNomAvecComparateurChaine(lev);
        SelectionneurAvecMaxResultat selecteur = new SelectionneurAvecMaxResultat(3);
        
        //Configuration config = new Configuration(encodeur, index, new Levenshtein(), 0.5, 3);
        
        Moteur moteur = new Moteur(generateur, selecteur, comparateur);
        
        List<IdNomScore> resultats = moteur.rechercher(nomRecherche, list);
        
        System.out.println("\nRésultats de la recherche pour '" + nomRecherche.getNomOriginal() + "' :");
        if (resultats.isEmpty()) {
            System.out.println("Aucun résultat trouvé.");
        } else {
            System.out.println("Nombre de résultats : " + resultats.size());
            for (IdNomScore resultat : resultats) {
                System.out.println("- ID: " + resultat.getId() + 
                                 ", Nom: " + resultat.getNom().getNomOriginal() + 
                                 ", Score: " + String.format("%.4f", resultat.getScore()));
            }
        }
        
        //  Affichage de l'index
        System.out.println("\nContenu de l'index :");
        //index.afficherIndex();
    }
    
 
    private static void pretraiterNoms(Nom nomRecherche, List<Nom> listeDeDonnees, Preprocesseur preprocesseur) {

        List<String> nomOriginal = new ArrayList<>();
        for (String partie : nomRecherche.getNomOriginal().split("\\s+")) {
            nomOriginal.add(partie.toLowerCase());
        }
        List<String> nomPretraite = preprocesseur.prétraiter(nomOriginal);
        nomRecherche.setListDeNomPretraite(nomPretraite);
        
        // Prétraitement de tous les noms de la base de données
        for (Nom nom : listeDeDonnees) {
            List<String> parties = new ArrayList<>();
            for (String partie : nom.getNomOriginal().split("\\s+")) {
                parties.add(partie.toLowerCase());
            }
            List<String> partiesPretraitees = preprocesseur.prétraiter(parties);
            nom.setListDeNomPretraite(partiesPretraitees);
        }
        
        // Affichage du prétraitement 
        System.out.println("\nPrétraitement  du nom recherché:");
        System.out.println("Original: " + nomRecherche.getNomOriginal());
        System.out.println("Prétraité: " + String.join(", ", nomRecherche.getListDeNomPretraite()));
        
        
        
    }
}
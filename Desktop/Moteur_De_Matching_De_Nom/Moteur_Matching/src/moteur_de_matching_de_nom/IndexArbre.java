package moteur_de_matching_de_nom;
import java.util.List;
	
	
public class IndexArbre implements Indexeur{
	private Noeud racine;
	
	public IndexArbre() {
		this.racine = new Noeud('\0'); 
	}
	
	public void indexer(List<String> noms){
		Noeud courant = racine;
		for (String nom : noms) {
			for (char lettre : nom.toCharArray()) {
	            Noeud enfant = courant.trouverEnfant(lettre);
	            if (enfant == null) {
	                enfant = courant.ajouterEnfant(lettre);
	            }
	            courant = enfant;
	        }
	        courant.estFinMot = true;
	    }
	}
	
	
    public void afficherIndex() {
        afficherNoeud(racine, "");
    }

    private void afficherNoeud(Noeud noeud, String prefixe) {
        if (noeud.estFinMot) {
            System.out.println(prefixe);
        }
        for (Noeud enfant : noeud.fils) {
            afficherNoeud(enfant, prefixe + enfant.lettre);
        }
    }


}

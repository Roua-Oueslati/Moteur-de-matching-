package moteur_de_matching_de_nom;

public class  ComparateurNomAvecComparateurChaine implements  ComparateurNom {
	
	ComparateurChaine ch;
	
	public double comparerNom(String nom1, String nom2) {
		double score = 0;
		if (ch instanceof Levenshtein) {
			score=ch.comparer(nom1, nom2);
		}
		if (ch instanceof JaroWinkler) {
			score=ch.comparer(nom1, nom2);
		}
		return score;
		
	}

}

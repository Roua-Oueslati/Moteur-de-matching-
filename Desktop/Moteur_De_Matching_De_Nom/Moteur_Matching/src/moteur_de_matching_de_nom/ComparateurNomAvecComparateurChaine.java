package moteur_de_matching_de_nom;



public class  ComparateurNomAvecComparateurChaine implements  ComparateurNom {
	
	private ComparateurChaine ch;
	public ComparateurNomAvecComparateurChaine(ComparateurChaine ch) {
		this.ch=ch;
	}
	
	public double comparerNom(Nom nom1, Nom nom2) {
		
		double score = 0;
		if (ch instanceof Levenshtein) {
			Levenshtein comp = (Levenshtein) ch;
			score =comp.comparer(nom1.getNomOriginal(), nom2.getNomOriginal());

		}
		if (ch instanceof JaroWinkler) {
			JaroWinkler comp = (JaroWinkler) ch;
			score =comp.comparer(nom1.getNomOriginal(), nom2.getNomOriginal());
		}
		return score;
	}
}

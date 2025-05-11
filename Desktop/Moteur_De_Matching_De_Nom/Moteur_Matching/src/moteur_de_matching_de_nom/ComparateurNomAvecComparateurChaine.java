package moteur_de_matching_de_nom;



public class  ComparateurNomAvecComparateurChaine implements  ComparateurNom {
	
	private ComparateurChaine ch;
	public ComparateurNomAvecComparateurChaine(ComparateurChaine ch) {
		this.ch=ch;
	}
	
	public double comparerNom(Nom nom1, Nom nom2) {
		
		int nbrComparaison =0;
		double resultat =0.0;
		
		for (String ch1 : nom1.getListDeNomPretraite()) {
			for (String ch2 : nom2.getListDeNomPretraite()) {
				if (ch1.length()!=0 && ch2.length()!=0) {
					nbrComparaison++;
					resultat +=ch.comparer(ch2, ch1);
				}
					
			}

		}
		if (nbrComparaison==0) {
			return 0.0;
		}
		
		double score= resultat/nbrComparaison;
		return score;
		
		}
}

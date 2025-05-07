package moteur_de_matching_de_nom;

public class ComparateurNomAveclistePretraite implements ComparateurNom {
	
	public double comparerNom(Nom nom1, Nom nom2) {
		
		int nbrtotal = 0;
		int correspondance = 0;
		
		for (String ch1 : nom1.getListDeNomPretraite()) {
			for (String ch2 : nom2.getListDeNomPretraite()) {
				if (ch1.length()!=0 || ch2.length()!=0) {
					nbrtotal++;
					if(ch1.equals(ch2)) {
						correspondance++;
					}
				}	
			}
		}
		
		if (nbrtotal ==0) {
			return 0.0;
		}
		
		double score = (double)correspondance/nbrtotal;
		return(score);
		
	}

}
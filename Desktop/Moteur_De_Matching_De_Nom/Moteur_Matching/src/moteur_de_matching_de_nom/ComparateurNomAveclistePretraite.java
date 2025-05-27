package moteur_de_matching_de_nom;

import java.util.HashSet;
import java.util.Set;

public class ComparateurNomAveclistePretraite implements ComparateurNom {
	
	public double comparerNom(Nom nom1, Nom nom2) {
		
		int nbrtotal = 0;
		int correspondance = 0;
		
		for (String ch1 : nom1.getListDeNomPretraite()) {
			for (String ch2 : nom2.getListDeNomPretraite()) {
				if (!ch1.isEmpty() && !ch2.isEmpty()) {
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
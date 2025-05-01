package moteur_de_matching_de_nom;

import java.util.ArrayList;
import java.util.List;

public class SelectionneurParSeuil  implements SelectionneurDeResultat{
	
	private double seuil;
	ComparateurChaine ch ;
	
	public SelectionneurParSeuil(double seuil) {
		this.seuil=seuil;
	}
	
	public List<IdNomScore> selectionner(List<CoupleDeNomAvecScore> List1){
		List<IdNomScore> listSelectionné = new ArrayList<IdNomScore>();
		for (CoupleDeNomAvecScore couple : List1) {
			if (ch.estUneDistance() == false) {
				if (couple.score() <= seuil) {
					IdNomScore coupleFinal = new IdNomScore(couple.nom2().getId(), couple.nom2().getNomOriginal(), couple.score());
					listSelectionné.add(coupleFinal);
				}
			}
			if (ch.estUneDistance() == true) {
				if (couple.score() >= seuil) {
					IdNomScore coupleFinal = new IdNomScore(couple.nom2().getId(), couple.nom2().getNomOriginal(), couple.score());
					listSelectionné.add(coupleFinal);
				}
				
			}
		}
		return listSelectionné;
	}

}

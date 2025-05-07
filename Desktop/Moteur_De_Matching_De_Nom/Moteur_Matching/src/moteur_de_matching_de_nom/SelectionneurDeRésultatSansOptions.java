package moteur_de_matching_de_nom;

import java.util.ArrayList;
import java.util.List;

public class SelectionneurDeRésultatSansOptions implements SelectionneurDeResultat {

	public List<IdNomScore> selectionner(List<CoupleDeNomAvecScore>L){
		List <IdNomScore> listeChoisie = new ArrayList<IdNomScore>();
		for(CoupleDeNomAvecScore element : L) {
				IdNomScore coupleFinal = new IdNomScore(element.nom2().getId(), element.getNom2(), element.getScore());
				listeChoisie.add(coupleFinal);
			}
		
		return listeChoisie;
	}

}


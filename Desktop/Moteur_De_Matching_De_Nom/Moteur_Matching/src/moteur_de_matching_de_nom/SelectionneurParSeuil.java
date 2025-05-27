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
		List <IdNomScore> listeChoisie = new ArrayList<IdNomScore>();
		for(CoupleDeNomAvecScore element : List1) {
			if (element.getScore()>=seuil) {
				IdNomScore coupleFinal = new IdNomScore(element.nom2().getId(), element.getNom2(), element.getScore());
				listeChoisie.add(coupleFinal);
			}
		}
		return listeChoisie;
	}

}

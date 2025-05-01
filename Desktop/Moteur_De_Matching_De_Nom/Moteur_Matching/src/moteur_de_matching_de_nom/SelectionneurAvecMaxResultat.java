package moteur_de_matching_de_nom;
import java.util.ArrayList;
import java.util.List;

public class SelectionneurAvecMaxResultat implements SelectionneurDeResultat {
	
	private int maxResultat;
	
	public SelectionneurAvecMaxResultat(int maxResultat) {
		this.maxResultat=maxResultat;
	}
	
	public List<IdNomScore> selectionner(List<CoupleDeNomAvecScore> List1){
		
		List<IdNomScore> listSelectionné = new ArrayList<IdNomScore>();
		for(CoupleDeNomAvecScore couple : List1) {
			IdNomScore coupleFinal = new IdNomScore(couple.nom2().getId(), couple.nom2().getNomOriginal(), couple.score());
			listSelectionné.add(coupleFinal);
		}
		return listSelectionné.subList(0, maxResultat);
	}

}

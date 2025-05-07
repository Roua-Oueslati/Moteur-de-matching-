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
			IdNomScore coupleFinal = new IdNomScore(couple.nom2().getId(), couple.getNom2(), couple.getScore());
			listSelectionné.add(coupleFinal);
		}
		int actualSize = Math.min(maxResultat, listSelectionné.size());
		return listSelectionné.subList(0, actualSize);
	}

}

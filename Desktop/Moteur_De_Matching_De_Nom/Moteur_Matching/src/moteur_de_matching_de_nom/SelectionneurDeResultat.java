package moteur_de_matching_de_nom;
import java.util.List;


public interface SelectionneurDeResultat {
	 
	
	List<IdNomScore> selectionner(List<CoupleDeNomAvecScore>L);
	

}
 
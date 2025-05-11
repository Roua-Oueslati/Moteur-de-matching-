package moteur_de_matching_de_nom;

import java.util.ArrayList;
import java.util.List;

public class GenerateurTrivial implements GenerateurDeCandidat{
	

	public List <CoupleDeNom> genererUnCandidat(List <Nom> list1 ,List<Nom> List2){
		List<CoupleDeNom> listDeCandidat = new ArrayList<CoupleDeNom>();
		
		for (Nom nom1 : list1) {
			for (Nom nom2 : List2) {
				CoupleDeNom coupleCandidat = new CoupleDeNom(nom1,nom2);
				listDeCandidat.add(coupleCandidat);
			}
		}

	return listDeCandidat;
	}
}

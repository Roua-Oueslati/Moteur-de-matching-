package moteur_de_matching_de_nom;
import java.util.List;
import java.util.ArrayList;


public class GenerateurDeCandidatSelonLaTaille implements GenerateurDeCandidat{
	
	//Indexeur index;
	
	//public GenerateurDeCandidatSelonLaTaille(Indexeur index) {
		//this.index=index;
	//}
	
	public List<CoupleDeNom> genererUnCandidat(List<Nom> List1, List<Nom> List2){
		List<CoupleDeNom> listDeCandidat = new ArrayList<CoupleDeNom>();
		
		for (Nom nom1 : List1) {
			for (Nom nom2 : List2) {
				if (nom1.getNomOriginal().length() == nom2.getNomOriginal().length()) {
					CoupleDeNom coupleCandidat = new CoupleDeNom(nom1,nom2);
					listDeCandidat.add(coupleCandidat);
				}
			}
		}
		return listDeCandidat;
	}

}

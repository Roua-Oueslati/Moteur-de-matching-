package moteur_de_matching_de_nom;

import  java.util.List;

public interface GenerateurDeCandidat {

	public List <CoupleDeNom> genererUnCandidat(List <Nom> list1 ,List<Nom> List2);

}

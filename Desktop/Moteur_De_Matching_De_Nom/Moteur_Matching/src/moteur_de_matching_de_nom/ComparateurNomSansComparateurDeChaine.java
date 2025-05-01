package moteur_de_matching_de_nom;

public class ComparateurNomSansComparateurDeChaine implements ComparateurNom{

	public double comparerNom(String nom1, String nom2) {
		
		if (nom1.length()==0 || nom2.length()==0) {
			return 0;
		}
		return nom1.equals(nom2) ? 1.0 : 0.0;
	}
}

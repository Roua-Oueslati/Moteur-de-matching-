package moteur_de_matching_de_nom;

public class ComparateurNomSansComparateurDeChaine implements ComparateurNom{

	public double comparerNom(Nom nom1, Nom nom2) {
        // Vérification si l'un des noms est vide
        if (nom1.getNomOriginal().length() == 0 || nom2.getNomOriginal().length() == 0) {
            return 0;
        }
        
        // Comparaison des noms originaux plutôt que des objets
        String nomStr1 = nom1.getNomOriginal().trim();
        String nomStr2 = nom2.getNomOriginal().trim();
        
        // Vérification d'égalité des chaînes
        return nomStr1.equalsIgnoreCase(nomStr2) ? 1.0 : 0.0;
    }
}

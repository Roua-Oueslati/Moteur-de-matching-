package moteur_de_matching_de_nom;
import java.util.List;
import java.util.ArrayList;
import java.text.Normalizer;


public class Normaliseur implements Preprocesseur{
		
		public List<String> prétraiter(Nom nom){
			
			List<String> listeNormalisee = new ArrayList<String>();
			String nomOriginal = nom.getNomOriginal();
				// Supprimer les espaces inutiles
	            nomOriginal = nomOriginal.trim();
	            
	            // Convertir en minuscules
	            nomOriginal = nomOriginal.toLowerCase();
	            
	           // Supprimer les accents
	            nomOriginal = supprimerAccents(nomOriginal);
	            
	           // Supprimer les caractères spéciaux
	            nomOriginal = nomOriginal.replaceAll("[^\\w\\s]", "");

	            // Ajouter à la liste normalisée si non vide
	            if (!nomOriginal.isEmpty()) {
	                listeNormalisee.add(nomOriginal);
	            }
			 return listeNormalisee;
			}
		private static String supprimerAccents(String texte) {
	        return Normalizer.normalize(texte, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
		}
		

}
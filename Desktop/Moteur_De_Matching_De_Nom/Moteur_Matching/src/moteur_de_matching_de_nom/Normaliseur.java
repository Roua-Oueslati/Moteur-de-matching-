package moteur_de_matching_de_nom;

import java.util.ArrayList;
import java.util.List;
import java.text.Normalizer;

public class Normaliseur implements Preprocesseur{
		
		public List<String> prétraiter(List<String> L){
			
			List<String> listeNormalisee = new ArrayList<String>();
			for (String element : L) {
				if( element == null ) {
					continue;
				}
				// Supprimer les espaces inutiles
	            element = element.trim();
	            
	            // Convertir en minuscules
	            element = element.toLowerCase();
	            
	           // Supprimer les accents
	            element = supprimerAccents(element);
	            
	           // Supprimer les caractères spéciaux
	            element = element.replaceAll("[^\\w\\s]", "");

	            // Ajouter à la liste normalisée si non vide
	            if (!element.isEmpty()) {
	                listeNormalisee.add(element);
	            }
	        }
			 return listeNormalisee;
			}
		private static String supprimerAccents(String texte) {
	        return Normalizer.normalize(texte, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
	    }

		

}

package moteur_de_matching_de_nom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexDictionnaire implements Indexeur{
	
	private Map<Character ,List<String>> index;
	
	public IndexDictionnaire() {
		this.index = new HashMap<>();
	}

	public void indexer(List<String> noms) {
		for (String nom : noms) {
	        if (nom == null || nom.isEmpty()) {
	           continue; // Ignorer les noms vides ou nuls
	        }

	        // Prendre la première lettre du nom en majuscule
	        char premiereLettre = Character.toUpperCase(nom.charAt(0));

	         // Ajouter le nom à la liste associée à cette lettre
	         index.computeIfAbsent(premiereLettre, k -> new ArrayList<>()).add(nom);
	        }
		}
	
	public void afficherIndex() {
        for (Map.Entry<Character, List<String>> entry : index.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
	
	
}
		


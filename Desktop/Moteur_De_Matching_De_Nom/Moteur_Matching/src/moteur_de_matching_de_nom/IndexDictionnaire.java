package moteur_de_matching_de_nom;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IndexDictionnaire implements Indexeur{
	
	
	private Map<Integer,List<String>> mapSelonLaTaille;
	
	public IndexDictionnaire() {
		this.mapSelonLaTaille = new HashMap<Integer, List<String>>();
	}
	
	public Map<Integer, List<String>> getMapSelonLaTaille() {
		return mapSelonLaTaille;
	}

	public void indexer(List<String> noms) {
		 
		 for (String nom : noms) {
			 int longueur = nom.length();
			 if (!mapSelonLaTaille.containsKey(longueur)) {
		            mapSelonLaTaille.put(longueur,new ArrayList<String>());
		        }
			 mapSelonLaTaille.get(longueur).add(nom);
		    }
	}
	
	

	
	
		        
	
	
}
		


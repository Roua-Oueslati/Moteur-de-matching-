package moteur_de_matching_de_nom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateurDeCandidatParIndex implements GenerateurDeCandidat{
	
	
	private Indexeur index;
	
	public GenerateurDeCandidatParIndex(Indexeur index) {
		this.index=index;
	}
	
	public List<CoupleDeNom> genererUnCandidat(List<Nom> List1, List<Nom> List2){
		
		    List<CoupleDeNom> couples = new ArrayList<>();

		    // 1. On récupère tous les noms originaux dans une liste commune
		    List<String> nomsOriginaux = new ArrayList<>();
		    Map<String, Nom> map = new HashMap<>();

		    for (Nom nom : List1) {
		        nomsOriginaux.add(nom.getNomOriginal());
		        map.put(nom.getNomOriginal(), nom);
		    }
		    for (Nom nom : List2) {
		        nomsOriginaux.add(nom.getNomOriginal());
		        map.put(nom.getNomOriginal(), nom);
		    }

		    // 2. On indexe tous les noms
		    index.indexer(nomsOriginaux);

		    // 3. On suppose que l'indexeur peut retourner la map des groupes
		    Map<Integer, List<String>> mapParTaille = ((IndexDictionnaire) index).getMapSelonLaTaille();

		    // 4. Pour chaque groupe de taille, on génère des couples (L1 x L2)
		    for (Map.Entry<Integer, List<String>> entry : mapParTaille.entrySet()) {
		        List<String> noms = entry.getValue();

		        for (String nom1 : noms) {
		            for (String nom2 : noms) {
		                    Nom obj1 = map.get(nom1);
		                    Nom obj2 = map.get(nom2);
		                    if (List1.contains(obj1) && List2.contains(obj2)) {
		                        couples.add(new CoupleDeNom(obj1, obj2));
		                    }		                
		            }
		        }
		    }

		    return couples;
		}


}


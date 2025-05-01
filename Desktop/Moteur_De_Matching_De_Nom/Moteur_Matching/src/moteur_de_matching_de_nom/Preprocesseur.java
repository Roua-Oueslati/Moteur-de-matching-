package moteur_de_matching_de_nom;

import java.util.List;

public interface Preprocesseur {
	
	public List<Preprocesseur> prétraiter(List<String> list);
	
	public boolean estPrétraiter();

}

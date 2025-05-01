package moteur_de_matching_de_nom;

import java.util.List;

public abstract class  Encodeur implements Preprocesseur{
	
	public abstract  List<Preprocesseur> prétraiter(List<String> L);
	
	public boolean estPrétraiter() {
		return true;
	}
	
}

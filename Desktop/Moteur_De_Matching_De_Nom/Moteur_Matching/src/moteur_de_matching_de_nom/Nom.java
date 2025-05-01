package moteur_de_matching_de_nom;

public class Nom {
	
	private String nomOriginal;
	private String identifiant;
	// list vide 
	
	public Nom(String nomOriginal, String identifiant) {
		this.identifiant=identifiant;
		this.nomOriginal=nomOriginal;
	}
	

	public String getId() {
		return this.identifiant;
	}
	public String getNomOriginal() {
		return this.nomOriginal;
	}
	
	

}

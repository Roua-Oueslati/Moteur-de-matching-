package moteur_de_matching_de_nom;

public record IdNomScore(String id , String nom, double score ) {
	
	
	public IdNomScore(String id , String nom, double score) {
		// TODO Auto-generated constructor stub
		this.id = id ;
		this.score = score;
		this.nom = nom;
	}
	
	public String Id() {
		return id;
	}
	
	public String Nom() {
		return nom;
	}

	public double score() {
		return score;
	}

}

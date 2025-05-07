package moteur_de_matching_de_nom;

public class IdNomScore {
	
	public String id;
	public double score;
	public Nom nom;
	

	
	public IdNomScore(String id, Nom nom, double score) {
		this.id=id;
		this.nom=nom;
		this.score=score;
	}
	public String toString() {
		return "id:"+" "+id+" nom:"+" "+nom.getNomOriginal()+" "+"score:"+" "+score;
		
	}
	public String getId() {
		return this.id;
	}
	public double getScore() {
		return this.score;
	}
	public Nom getNom() {
		return this.nom;
	}
	
	
	
	

}

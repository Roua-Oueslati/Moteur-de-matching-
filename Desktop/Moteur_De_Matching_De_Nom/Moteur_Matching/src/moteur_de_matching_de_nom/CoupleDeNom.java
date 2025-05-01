package moteur_de_matching_de_nom;

public record CoupleDeNom(Nom nom1,Nom nom2) {

	public CoupleDeNom(Nom nom1 , Nom nom2) {
		// TODO Auto-generated constructor stub
		this.nom1=nom1;
		this.nom2=nom2;
		
	}
	
	public Nom getNom1() {
		return this.nom1;
	}
	
	public Nom getNom2() {
		return this.nom2;
	}
	
	
	
	
	
	
	

}

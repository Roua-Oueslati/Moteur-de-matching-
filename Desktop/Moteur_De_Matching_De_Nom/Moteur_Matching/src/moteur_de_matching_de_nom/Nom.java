package moteur_de_matching_de_nom;

import java.util.ArrayList;
import java.util.List;

public class Nom {
	
	private String identifiant;
	private String nomOriginal;
	private List<String> listDeNomPretraite;
	
	public Nom( String identifiant , String nomOriginal ) {
		this.identifiant=identifiant;
		this.nomOriginal=nomOriginal;
		this.listDeNomPretraite= new ArrayList<String>();
	}
	

	public String getId() {
		return this.identifiant;
	}
	public String getNomOriginal() {
		return this.nomOriginal;
	}


	public List<String> getListDeNomPretraite() {
		return listDeNomPretraite;
	}


	public void setListDeNomPretraite(List<String> listDeNomPretraite) {
		this.listDeNomPretraite = listDeNomPretraite;
	}
	
	@Override
	public boolean equals(Object o) {
	    if (o instanceof Nom) {
	    	Nom nom=(Nom) o;
	    	return(this.nomOriginal.equals(nom));
	    	//if (this.nomOriginal==nom.getNomOriginal()) {
	    		//return true;
	    	//}
	    }
	    return false;
	}

	@Override
	public int hashCode() {
	    return nomOriginal.hashCode(); 
	}
	public String toString() {
		return "ID:"+" "+identifiant+" "+"Nom:"+" "+nomOriginal;
	}

}

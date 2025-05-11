package moteur_de_matching_de_nom;

public class Configuration {
	
	private Preprocesseur nomProcesseur;
	private Indexeur nomIndex;
	private ComparateurNom nomComp;
	private double seuil;
	private int maxResult;
	public Configuration(Preprocesseur nomProcesseur, Indexeur nomIndex, ComparateurNom nomComp, double seuil, int maxResult) {
		super();
		this.nomProcesseur = nomProcesseur;
		this.nomIndex = nomIndex;
		this.nomComp = nomComp;
		this.seuil = seuil;
		this.maxResult = maxResult;
	}
	public Preprocesseur getNomProcesseur() {
		return nomProcesseur;
	}
	public void setNomProcesseur(Preprocesseur nomProcesseur) {
		this.nomProcesseur = nomProcesseur;
	}
	public Indexeur getNomIndex() {
		return nomIndex;
	}
	public void setNomIndex(Indexeur nomIndex) {
		this.nomIndex = nomIndex;
	}
	public ComparateurNom getNomCompchaine() {
		return nomComp;
	}
	public void setNomCompchaine(ComparateurNom nomComp) {
		this.nomComp = nomComp;;
	}
	public double getSeuil() {
		return seuil;
	}
	public void setSeuil(double seuil) {
		this.seuil = seuil;
	}
	public int getMaxResult() {
		return maxResult;
	}
	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}
	
}
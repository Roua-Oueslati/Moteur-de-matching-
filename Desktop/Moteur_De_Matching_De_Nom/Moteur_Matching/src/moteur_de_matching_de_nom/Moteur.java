package moteur_de_matching_de_nom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Moteur {

	private GenerateurDeCandidat genCond;
	private SelectionneurDeResultat selectRes;
	private ComparateurNom compNom;
	private RecuperateurCSV fich;
	private Configuration config;
	
	public Moteur (GenerateurDeCandidat genCond, SelectionneurDeResultat selectRes, ComparateurNom compNom) {
		this.compNom=compNom;
		this.genCond=genCond;
		this.selectRes=selectRes;
	}
	   

	public Moteur (GenerateurDeCandidat genCond, SelectionneurDeResultat selectRes, ComparateurNom compNom, Configuration config) {
		this.compNom=compNom;
		this.genCond=genCond;
		this.selectRes=selectRes;
		this.config=config;
	}
	
	
	public List<IdNomScore> rechercher(Nom nom, List<Nom> l) {

		List <Nom> ListDeNom = new ArrayList<Nom>();
		ListDeNom.add(nom);
		List <CoupleDeNom> candidat = new ArrayList<CoupleDeNom>();
		List <IdNomScore> candidatSéléctionner  = new ArrayList<IdNomScore>();
		List <CoupleDeNomAvecScore> candidatComparé = new ArrayList<CoupleDeNomAvecScore>();
		candidat = this.genCond.genererUnCandidat(ListDeNom,l);
		for (CoupleDeNom couple : candidat) {
			Nom nom1 = couple.getNom1();
			Nom nom2 = couple.getNom2();
			nom1.setListDeNomPretraite(this.config.getNomProcesseur().prétraiter(nom1));
			nom2.setListDeNomPretraite(this.config.getNomProcesseur().prétraiter(nom2));
		}	
		for (CoupleDeNom couple : candidat) {
			double score=compNom.comparerNom(couple.getNom1(), couple.getNom2());
			CoupleDeNomAvecScore coupleEtScore = new CoupleDeNomAvecScore(couple.getNom1(),couple.getNom2(), score);
			candidatComparé.add(coupleEtScore);
		}
		
		candidatSéléctionner=this.selectRes.selectionner(candidatComparé);
		return candidatSéléctionner;		
	}
	
	public List<CoupleDeNomAvecScore> dedupliquer(List<Nom> liste) {
	    List<CoupleDeNom> couples = genCond.genererUnCandidat(liste, liste);
	    Set<String> dejaVus = new HashSet<>();
	    List<CoupleDeNomAvecScore> resultats = new ArrayList<>();

	    for (CoupleDeNom couple : couples) {
	        Nom nom1 = couple.getNom1();
	        Nom nom2 = couple.getNom2();

	        // Éviter les auto-comparaisons
	        if (nom1.getId().equals(nom2.getId())) continue;

	        // Clé unique pour éviter les inverses (ordre indépendant)
	        String cle = genererCleUnique(nom1, nom2);
	        if (dejaVus.contains(cle)) continue;

	        // Marquer ce couple comme traité
	        dejaVus.add(cle);

	        // Prétraitement
	        nom1.setListDeNomPretraite(this.config.getNomProcesseur().prétraiter(nom1));
	        nom2.setListDeNomPretraite(this.config.getNomProcesseur().prétraiter(nom2));

	        // Comparaison
	        double score = compNom.comparerNom(nom1, nom2);

	        // Seuil configurable
	        if (score >= 0.9) {
	            resultats.add(new CoupleDeNomAvecScore(nom1, nom2, score));
	        }
	    }

	    return resultats;
	}

	// Génère une clé unique pour deux noms, peu importe l’ordre
	private String genererCleUnique(Nom nom1, Nom nom2) {
	    String id1 = nom1.getId();
	    String id2 = nom2.getId();
	    return id1.compareTo(id2) < 0 ? id1 + "" + id2 : id2 + "" + id1;
	}


	
	
	public List<CoupleDeNomAvecScore> comparer(List<Nom> l1, List<Nom> l2){
		List <CoupleDeNom> candidat = new ArrayList<CoupleDeNom>();
		
		List <CoupleDeNomAvecScore> candidatComparé = new ArrayList<CoupleDeNomAvecScore>();
		candidat = this.genCond.genererUnCandidat(l1,l2);
		for (CoupleDeNom couple : candidat) {
			Nom nom1 = couple.getNom1();
			Nom nom2 = couple.getNom2();
			nom1.setListDeNomPretraite(this.config.getNomProcesseur().prétraiter(nom1));
			nom2.setListDeNomPretraite(this.config.getNomProcesseur().prétraiter(nom2));
		}	
		for (CoupleDeNom couple : candidat) {
			double score=compNom.comparerNom(couple.getNom1(), couple.getNom2());
			CoupleDeNomAvecScore coupleEtScore = new CoupleDeNomAvecScore(couple.getNom1(),couple.getNom2(), score);
			candidatComparé.add(coupleEtScore);
		}
		return candidatComparé;
	}
}

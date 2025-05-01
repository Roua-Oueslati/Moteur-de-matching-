package moteur_de_matching_de_nom;

import java.util.ArrayList;
import java.util.List;

public class Moteur {
	private List <Preprocesseur> listDePrétaiteur ;
	private GenerateurDeCandidat genCond;
	private SelectionneurDeResultat selectRes;
	private ComparateurNom compNom;
	private Recuperateur fich;
	private Configuration config;
	
	public Moteur (GenerateurDeCandidat genCond, SelectionneurDeResultat selectRes, ComparateurNom compNom) {
		this.compNom=compNom;
		this.genCond=genCond;
		this.selectRes=selectRes;
	}
	   

	public Moteur (GenerateurDeCandidat genCond, SelectionneurDeResultat selectRes, ComparateurNom compNom,Recuperateur fich, Configuration config, Preprocesseur preProc) {
		this.compNom=compNom;
		this.genCond=genCond;
		this.selectRes=selectRes;
		this.listDePrétaiteur= new ArrayList<Preprocesseur>();
		this.config=config;
		this.fich=fich;
	}
	
	public List<IdNomScore> rechercher(Nom nom, List<Nom> l) {
		List <Nom> ListDeNom = new ArrayList<Nom>();
		ListDeNom.add(nom);
		List <CoupleDeNom> candidat = new ArrayList<CoupleDeNom>();
		List <IdNomScore> candidatSéléctionner  = new ArrayList<IdNomScore>();
		List <CoupleDeNomAvecScore> candidatComparé = new ArrayList<CoupleDeNomAvecScore>();
		candidat = this.genCond.genererUnCandidat(ListDeNom,l);
		for (CoupleDeNom couple : candidat) {
			double score=compNom.comparerNom(couple.getNom1().getNomOriginal(), couple.getNom2().getNomOriginal());
			CoupleDeNomAvecScore coupleEtScore = new CoupleDeNomAvecScore(couple.getNom1(),couple.getNom2(), score);
			candidatComparé.add(coupleEtScore);
		}
		
		candidatSéléctionner=this.selectRes.selectionner(candidatComparé);
		return candidatSéléctionner;	
	}
	
	//public List<String> dedupliquer(List<String> l){
		   
		//}
	
	
	//public List<String> comparer(List<String> l1, List<String> l2){
		
	}


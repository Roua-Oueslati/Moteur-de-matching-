package moteur_de_matching_de_nom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Moteur {
	private List <Preprocesseur> listDePrétaiteur ;
	private GenerateurDeCandidat genCond;
	private SelectionneurDeResultat selectRes;
	private ComparateurNom compNom;
	private RecuperateurCSV fich;
	private Configuration config;
	private Preprocesseur preProc;
	
	public Moteur (GenerateurDeCandidat genCond, SelectionneurDeResultat selectRes, ComparateurNom compNom) {
		this.compNom=compNom;
		this.genCond=genCond;
		this.selectRes=selectRes;
	}
	   

	public Moteur (GenerateurDeCandidat genCond, SelectionneurDeResultat selectRes, ComparateurNom compNom, Configuration config, Preprocesseur preProc) {
		this.compNom=compNom;
		this.genCond=genCond;
		this.selectRes=selectRes;
		this.listDePrétaiteur= new ArrayList<Preprocesseur>();
		this.config=config;
	}
	
	
	public Moteur (GenerateurDeCandidat genCond, SelectionneurDeResultat selectRes, ComparateurNom compNom, Preprocesseur preProc) {
		this.compNom=compNom;
		this.genCond=genCond;
		this.selectRes=selectRes;
		this.listDePrétaiteur= new ArrayList<Preprocesseur>();
		this.preProc = preProc;
	}
	
	
	public List<IdNomScore> rechercher(Nom nom, List<Nom> l) {
		
		List <Nom> ListDeNom = new ArrayList<Nom>();
		ListDeNom.add(nom);
		List <CoupleDeNom> candidat = new ArrayList<CoupleDeNom>();
		List <IdNomScore> candidatSéléctionner  = new ArrayList<IdNomScore>();
		List <CoupleDeNomAvecScore> candidatComparé = new ArrayList<CoupleDeNomAvecScore>();
		candidat = this.genCond.genererUnCandidat(ListDeNom,l);
		for (CoupleDeNom couple : candidat) {
			double score=compNom.comparerNom(couple.getNom1(), couple.getNom2());
			CoupleDeNomAvecScore coupleEtScore = new CoupleDeNomAvecScore(couple.getNom1(),couple.getNom2(), score);
			candidatComparé.add(coupleEtScore);
		}
		
		candidatSéléctionner=this.selectRes.selectionner(candidatComparé);
		return candidatSéléctionner;	
	}
	
	public List<Nom> dedupliquer(List<Nom> l){
		
		Set<Nom> nomUniques = new HashSet();
        Set<Nom> nomDoublons = new HashSet();

        for (Nom element : l) {
            if (!nomUniques.add(element)) {
                nomDoublons.add(element);
            }
            
        }
        List <Nom> listeDesDoublons = new ArrayList<>(nomDoublons);

		
		return listeDesDoublons;
		}
	
	
	public List<Nom> comparer(List<Nom> l1, List<Nom> l2){
		List<Nom> liste = new ArrayList<Nom>();
		List<Nom> listecomparée = new ArrayList<Nom>();
		liste.addAll(l1);
		liste.addAll(l2);
		listecomparée=dedupliquer(liste);
		//List<CoupleDeNomAvecScore> listeComparée = new ArrayList<CoupleDeNomAvecScore>();
		
		
		return listecomparée;
		//return listeComparée;
	}
}

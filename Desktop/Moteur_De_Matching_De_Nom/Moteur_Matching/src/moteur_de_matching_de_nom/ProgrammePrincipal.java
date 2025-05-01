package moteur_de_matching_de_nom;

import java.util.List;
import java.util.ArrayList;
public class ProgrammePrincipal {

	public static void main(String[] args) {
		Nom monNom = new Nom("roua","1");
		Nom nom1 = new Nom("rowe","10");
		Nom nom2 = new Nom("roya","11");
		Nom nom3 = new Nom("roue","100");
		Nom nom4 = new Nom("malik","110");
		Nom nom5 = new Nom("maha","111");
		Nom nom6 = new Nom("mehrez","1000");
		List <Nom> listDeNom = new ArrayList<Nom>();
		listDeNom.add(nom1);
		listDeNom.add(nom2);
		listDeNom.add(nom3);
		listDeNom.add(nom4);
		listDeNom.add(nom5);
		listDeNom.add(nom6);
		
		List <IdNomScore> Listfinale = new ArrayList<IdNomScore>();
		
		ComparateurNomAvecComparateurChaine comNom = new ComparateurNomAvecComparateurChaine();
		SelectionneurAvecMaxResultat select = new SelectionneurAvecMaxResultat(3);
		GenerateurDeCandidatSelonLaTaille genCand = new GenerateurDeCandidatSelonLaTaille();
		
		GenerateurDeCandidat genCandidat = (GenerateurDeCandidat) genCand;
		SelectionneurDeResultat selector = (SelectionneurDeResultat) select;
		ComparateurNom compNom = (ComparateurNom) comNom;
		
		
	
		Moteur moteur = new Moteur(genCandidat,selector,compNom);
		
		System.out.println("le nom à cherché est : "+ monNom.getNomOriginal());
		
		Listfinale= moteur.rechercher(monNom, listDeNom);
		for (IdNomScore element : Listfinale) {
		    System.out.println(element);
		}
		
		
		
	}

}

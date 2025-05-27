package moteur_de_matching_de_nom;


import java.util.ArrayList;
import java.util.List;

public class EncodeurSoundex extends Encodeur{

	public List<String> prétraiter(Nom nom) {
		
		List<String> listePretraitee = new ArrayList<String>();
		String nomEncodé=encoder(nom.getNomOriginal());
		listePretraitee.add(nomEncodé);
		return listePretraitee;
	}
		
	public String encoder (String s) {
		 if (s == null || s.isEmpty()) return "";
	
		 s = s.toUpperCase();
	
		  char firstLetter = s.charAt(0);
	
		        s = s.replaceAll("[BFPV]", "1");
		        s = s.replaceAll("[CGJKQSXZ]", "2");
		        s = s.replaceAll("[DT]", "3");
		        s = s.replaceAll("[L]", "4");
		        s = s.replaceAll("[MN]", "5");
		        s = s.replaceAll("[R]", "6");
	
		        s = s.replaceAll("[AEIOUYHW]", "0");
	
		        // Supprimer doublons consécutifs
		        StringBuilder result = new StringBuilder();
		        char prev = 0;
		        for (char c : s.toCharArray()) {
		            if (c != prev) {
		                result.append(c);
		            }
		            prev = c;
		        }
	
		        // Supprimer les '0'
		        String code = result.toString().replaceAll("0", "");
	
		        // Remplacer première lettre
		        code = firstLetter + code.substring(1);
	
		        // Normaliser à 4 caractères
		        code = code + "0000";
		        return code.substring(0, 4);
		    }
}
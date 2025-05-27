package moteur_de_matching_de_nom;

	import java.util.List;
	import java.util.ArrayList;

public class EncodeurPhonétique extends Encodeur {
	    
	 public List<String> prétraiter(Nom nom) {

	        List<String> resultat = new ArrayList<String>();
	        String nomEncodé = encoderPhonétique(nom.getNomOriginal());
	        resultat.add(nomEncodé);
	        return resultat;
	    }
	    
	    // Implémentation basique d'un encodeur phonétique (type Soundex simplifié)
	    private String encoderPhonétique(String mot) {
	        if (mot == null || mot.isEmpty()) {
	            return "";
	        }
	        
	        // Convertir en majuscules et supprimer les caractères non alphabétiques
	        String s = mot.toUpperCase().replaceAll("[^A-Z]", "");
	        
	        if (s.isEmpty()) {
	            return "";
	        }
	        
	        char premiereLettre = s.charAt(0);
	        
	        // Remplacer les consonnes par des chiffres selon les règles Soundex
	        s = s.replaceAll("[BFPV]", "1")
	             .replaceAll("[CGJKQSXZ]", "2")
	             .replaceAll("[DT]", "3")
	             .replaceAll("[L]", "4")
	             .replaceAll("[MN]", "5")
	             .replaceAll("[R]", "6");
	        
	        // Supprimer les voyelles et les 'H', 'W', 'Y'
	        s = s.replaceAll("[AEIOUHWY]", "");
	        
	        // Supprimer les doublons consécutifs
	        StringBuilder sb = new StringBuilder();
	        if (!s.isEmpty()) {
	            sb.append(s.charAt(0));
	            for (int i = 1; i < s.length(); i++) {
	                if (s.charAt(i) != s.charAt(i - 1)) {
	                    sb.append(s.charAt(i));
	                }
	            }
	        }
	        
	        // Réinsérer la première lettre et limiter à 4 caractères
	        String code = premiereLettre + (sb.length() > 0 ? sb.toString().substring(Math.min(1, sb.length())) : "");
	        
	        // Compléter avec des zéros si nécessaire
	        while (code.length() < 4) {
	            code += "0";
	        }
	        
	        // Limiter à 4 caractères
	        return code.substring(0, Math.min(4, code.length()));
	    }
}
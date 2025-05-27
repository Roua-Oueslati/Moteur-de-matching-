package moteur_de_matching_de_nom;

public class JaroWinkler implements ComparateurChaine{
	
	public double comparer(String nom1 , String nom2) {
		int matchDistance = Math.max(nom1.length(), nom2.length()) / 2 - 1;
        if (matchDistance < 0) matchDistance = 0;
        
        boolean[] nom1Matches = new boolean[nom1.length()];
        boolean[] nom2Matches = new boolean[nom2.length()];
        
        // Count matching characters
        int matchingChars = 0;
        for (int i = 0; i < nom1.length(); i++) {
            int start = Math.max(0, i - matchDistance);
            int end = Math.min(i + matchDistance + 1, nom2.length());
            
            for (int j = start; j < end; j++) {
                if (!nom2Matches[j] && nom1.charAt(i) == nom2.charAt(j)) {
                    nom1Matches[i] = true;
                    nom2Matches[j] = true;
                    matchingChars++;
                    break;
                }
            }
        }
        
        // If no matches found
        if (matchingChars == 0) {
            return 0.0;
        }
        
        // Count transpositions
        int transpositions = 0;
        int k = 0;
        
        for (int i = 0; i < nom1.length(); i++) {
            if (nom1Matches[i]) {
                while (!nom2Matches[k]) {
                    k++;
                }
                
                if (nom1.charAt(i) != nom2.charAt(k)) {
                    transpositions++;
                }
                
                k++;
            }
        }
        
        // Divide transpositions by 2 as per the algorithm
        transpositions /= 2;
        
        // Calculate Jaro similarity
        return (((double) matchingChars / nom1.length()) +
                ((double) matchingChars / nom2.length()) +
                ((double) (matchingChars - transpositions) / matchingChars)) / 3.0;
    }
	
	
	
	public boolean estUneDistance() {
		return false;
	}
}



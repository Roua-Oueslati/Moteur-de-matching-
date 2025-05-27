package moteur_de_matching_de_nom;

public class Levenshtein implements ComparateurChaine {
	
	public double comparer(String nom1 , String nom2) {
		
		if (nom1 != null && nom2 != null) {
	        int nom1Length = nom1.length();
	        int nom2Length = nom2.length();
	        if (nom1Length == 0) {
	        	return nom2Length;
	        }
	        if (nom2Length == 0) {
	        	return nom1Length;
	        }
	        int[][] dist = new int[nom1Length + 1][nom2Length + 1];
	        for (int i = 0; i < nom1Length + 1; i++) {
	            dist[i][0] = i;
	        }
	        for (int j = 0; j < nom2Length + 1; j++) {
	            dist[0][j] = j;
	        }
	        for (int i = 1; i < nom1Length + 1; i++) {
	            for (int j = 1; j < nom2Length + 1; j++) {
	                int cost = nom1.charAt(i - 1) == nom2.charAt(j - 1) ? 0 : 1;
	                dist[i][j] = Math.min(Math.min(dist[i - 1][j] + 1, dist[i][j - 1] + 1), dist[i - 1][j - 1] + cost);
	                if (i > 1 &&
	                        j > 1 &&
	                        nom1.charAt(i - 1) == nom2.charAt(j - 2) &&
	                        nom1.charAt(i - 2) == nom2.charAt(j - 1)) {
	                    dist[i][j] = Math.min(dist[i][j], dist[i - 2][j - 2] + cost);
	                }
	            }
	        }
        return dist[nom1Length][nom2Length];
		}
		else {
			return -1;
		}
	}	
	
	
	public boolean estUneDistance() {
		return true;
	}
}
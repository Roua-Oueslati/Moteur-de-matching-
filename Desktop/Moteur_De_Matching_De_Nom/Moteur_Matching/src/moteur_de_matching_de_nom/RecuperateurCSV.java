package moteur_de_matching_de_nom;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class RecuperateurCSV implements RecperateurDeDonnees {
	String chemin;
	
	public RecuperateurCSV(String chemin) {
		this.chemin=chemin;
	}
	
	public List<Nom> recuperer(){
		try (Stream<String> lines = Files.lines(Paths.get(chemin))) {
			return lines.skip(1) // Skip the header line
			.map(line -> line.split(","))
			.filter(values -> values.length >= 2)
			.map(values -> new Nom(values[0].trim(), values[1].trim()))
			.toList();
			} catch (IOException e) {
			e.printStackTrace();
			return List.of();
			}
			
	}
}

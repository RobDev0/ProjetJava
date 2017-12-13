package Classes;

import java.util.List;

public class FicheProduit extends DocumentProduit {

	public FicheProduit(String fileName, List<Produit> listeProduits){
		super(fileName, listeProduits);
	}

	public boolean creerFichierPdf() {
		// TODO Génerer la méthode pour créer le fichier d'une fiche produit
		return false;
	}
	
}

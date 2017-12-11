import Classes.Produit;
import com.google.zxing.WriterException;
import com.itextpdf.text.DocumentException;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.util.List;

public class Program {
	
	private static Options genererOptions() {
		Options options = new Options();
		options.addOption("h", true, "pour afficher l’aide");
		options.addOption("i", true, "suivi du chemin du fichier CSV d’entrée");
		options.addOption("categorie", true, "suivi du nom de la catégorie pour filtrer les produit");
		options.addOption("fiche", true, "suivi du chemin du fichier PDF contenant les fiches produit");
		options.addOption("etiquette", true, "suivi du chemin du fichier PDF qui contiendra les étiquettes produit");
		options.addOption("tva", true, "montant de la TVA à utiliser pour calculer le prix TTC (par défaut 20%)");
		return options;
	}

	public static void main(String[] args) throws DocumentException, IOException, WriterException {

		Options options = genererOptions();
		try {
			CommandLineParser parser = new DefaultParser();
			CommandLine cmd = parser.parse( options, args);
			if (cmd.hasOption("i")) {
				String cheminFichier = cmd.getOptionValue("i");
				List<Produit> productList = Produit.extractProductFromCSV(cheminFichier);
				for (int i=0; i<productList.size(); i++){
					System.out.println(productList.get(i).getNom() + " - " + productList.get(i).getCategorie() + "\n" + productList.get(i).getPrixHT() + " euros HT / " + productList.get(i).getPrixTTC() + " euros TTC" + "\n");
				}
				new PdfEtiquette().createEtiquette(cheminFichier + ".pdf", productList);
			}else
				System.out.println("Le paramètre du fichier csv requis est manquant. Arrêt du programme.");
		}catch(ParseException ex) {
			System.out.println("Erreur de parsing de la commande. Arrêt du programme.");
		}
	}
	
}
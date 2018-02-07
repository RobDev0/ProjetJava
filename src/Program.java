import Classes.Exceptions.CheminNonPreciseException;
import Classes.GestionnaireOptions;
import Classes.PDF.EtiquetteProduit;
import Classes.Extractable;
import Classes.Produit;
import Classes.CSV.CSVProduit;
import Classes.Sortable;
import com.google.zxing.WriterException;
import com.itextpdf.text.DocumentException;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.util.List;

public class Program {

	public static void main(String[] args) throws DocumentException, IOException, WriterException {

		try {
			GestionnaireOptions gestOptions = new GestionnaireOptions(args);
			for (Sortable sortie : gestOptions.getSorties()) {
				if (sortie != null)
					sortie.creerSortie();
			}
		}catch(ParseException ex) {
			System.out.println("Erreur de parsing de la commande. Arrêt du programme.");
		}
	}
	
}
package Classes;

import Classes.CSV.CSVProduit;
import Classes.Exceptions.CheminNonPreciseException;
import Classes.PDF.EtiquetteProduit;
import Classes.PDF.FicheProduit;
import org.apache.commons.cli.*;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireOptions {

    private String[] args;
    private Options options;

    public GestionnaireOptions(String[] args){
        this.args = args;
        this.options = genererOptions();
    }

    private Options genererOptions() {
        Options options = new Options();
        options.addOption("h", false, "pour afficher laide");
        options.addOption("i", true, "suivi du chemin du fichier CSV dentree");
        options.addOption("categorie", true, "suivi du nom de la categorie pour filtrer les produit");
        options.addOption("fiche", true, "suivi du chemin du fichier PDF contenant les fiches produit");
        options.addOption("etiquette", true, "suivi du chemin du fichier PDF qui contiendra les etiquettes produit");
        options.addOption("tva", true, "suivi du montant de la TVA (en pourcentage) a utiliser pour calculer le prix TTC (par défaut 20)");
        return options;
    }

    public ArrayList<Sortable> getSorties() throws CheminNonPreciseException, ParseException {
        ArrayList<Sortable> documentsASortir = new ArrayList<>();
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(this.options, this.args);
        Extractable fichierEntree;
        if (cmd.hasOption("i")) {
            String cheminFichier = cmd.getOptionValue("i");
            fichierEntree = new CSVProduit(cheminFichier);
            List<Produit> listeProd = getListeProduits(cmd, fichierEntree);
            setTVA(cmd, listeProd);
            if (cmd.hasOption("h")){
                for (Option option: options.getOptions()) {
                    System.out.println("-" + option.getOpt() + " " + option.getDescription());
                }
                return documentsASortir;
            }else {
                if (cmd.hasOption("etiquette") || cmd.hasOption("fiche")) {
                    if (cmd.hasOption("fiche")) {
                        documentsASortir.add(new FicheProduit(cmd.getOptionValue("fiche"), listeProd));
                    }
                    if (cmd.hasOption("etiquette")) {
                        documentsASortir.add(new EtiquetteProduit(cmd.getOptionValue("etiquette"), listeProd));
                    }
                    return documentsASortir;
                } else {
                    throw new CheminNonPreciseException("Le paramètre du fichier de sortie requis est manquant. Arrêt du programme.");
                }
            }
        }else
            throw new CheminNonPreciseException("Le paramètre du fichier d'entrée requis est manquant. Arrêt du programme.");
    }

    private void setTVA(CommandLine cmd, List<Produit> listeProd) {
        if (cmd.hasOption("tva")) {
            for (Produit p : listeProd) {
                p.setTVA(Double.valueOf(cmd.getOptionValue("tva")));
            }
        }
    }

    private List<Produit> getListeProduits(CommandLine cmd, Extractable fichierEntree) {
        List<Produit> listeProd;
        if (cmd.hasOption("categorie")) {
            listeProd = Produit.getProduitByCategorie(fichierEntree.extractProduct(), Produit.CATEGORIE.ELECTROMENAGER);
        } else {
            listeProd = fichierEntree.extractProduct();
        }
        return listeProd;
    }

}

package Classes;

import Classes.CSV.CsvFileHelper;
import Classes.CSV.CsvReader;

import java.util.ArrayList;
import java.util.List;

public class Produit {

    private String categorie;
    private String code;
    private String description;
    private String nom;
    private double prixHT;
    private double TVA = 2.5;

    public Produit(){}
    public Produit(String cat, String code, String desc, String nom, double prix) {
        this.categorie = cat;
        this.code = code;
        this.description = desc;
        this.nom = nom;
        this.prixHT = prix;

    }

    public String getCategorie()
    {
        return this.categorie;
    }
    public String getCode()
    {
        return this.code;
    }
    public String getDescription()
    {
        return this.description;
    }
    public String getNom()
    {
        return this.nom;
    }
    public double getPrixHT()
    {
        return this.prixHT;
    }
    public double getPrixTTC(){
        return this.prixHT + (this.prixHT * this.getTVA() / 100);
    }

    public static List<Produit> extractProductFromCSV(String cheminFichier) {
        List<Produit> listProduct = new ArrayList<>();
        CsvReader fileReader = new CsvReader(CsvFileHelper.getResource(cheminFichier));
        List<List<String>> fileContent = fileReader.getContentLinesList();
        for (int i=0;i<fileContent.size();i++){
            Produit newProduct = new Produit();
            newProduct.nom = fileContent.get(i).get(0);
            newProduct.categorie = fileContent.get(i).get(1);
            newProduct.code = fileContent.get(i).get(2);
            newProduct.description = fileContent.get(i).get(3);
            try {
                newProduct.prixHT = Double.valueOf(fileContent.get(i).get(4));
            }catch (NumberFormatException ex){
                newProduct.prixHT = 0;
            }
            listProduct.add(newProduct);
        }
        return listProduct;
    }

    public double getTVA() {
        return TVA;
    }
    public void setTVA(double TVA) {
        this.TVA = TVA;
    }

}

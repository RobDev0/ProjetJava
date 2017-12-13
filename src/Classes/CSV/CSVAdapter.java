package Classes.CSV;

import Classes.CSV.CsvFileHelper;
import Classes.CSV.CsvReader;
import Classes.Produit;

import java.util.ArrayList;
import java.util.List;

public class CSVAdapter {

    private String cheminFichier;
    private CsvReader fileReader = new CsvReader(CsvFileHelper.getResource(cheminFichier));

    public CSVAdapter(String cheminFichier){
        this.cheminFichier = cheminFichier;
    }

    public List<Produit> extractProductFromCSV() {
        List<Produit> listProduct = new ArrayList<>();
        List<List<String>> fileContent = fileReader.getContentLinesList();
        for (int i=0;i<fileContent.size();i++){
            Produit newProduct = new Produit();
            newProduct.setNom(fileContent.get(i).get(0));
            newProduct.setCategorie(fileContent.get(i).get(1));
            newProduct.setCode(fileContent.get(i).get(2));
            newProduct.setDescription(fileContent.get(i).get(3));
            try {
                newProduct.setPrixHT(Double.valueOf(fileContent.get(i).get(4)));
            }catch (NumberFormatException ex){
                newProduct.setPrixHT(0);
            }
            listProduct.add(newProduct);
        }
        return listProduct;
    }

}

package Classes.CSV;

import Classes.Extractable;
import Classes.Produit;

import java.util.ArrayList;
import java.util.List;

public class CSVProduit implements Extractable {

    private String cheminFichier;
    private CSVAdapteur fileReader;

    public CSVProduit(String cheminFichier){
        fileReader = new CSVAdapteur(cheminFichier);
    }

    @Override
    public List<Produit> extractProduct() {
        List<Produit> listProduct = new ArrayList<>();
        List<List<String>> fileContent = fileReader.getContentLinesList();
        System.out.println("size: " + fileContent.size());
        for (int i=0;i<fileContent.size();i++){
            Produit newProduct = new Produit();
            newProduct.setNom(fileContent.get(i).get(0));
            newProduct.setCategorie(Produit.CATEGORIE.valueOf(fileContent.get(i).get(1)));
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

    @Override
    public String getCheminFichier() {
        return cheminFichier;
    }

}

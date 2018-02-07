package Classes.PDF;

import Classes.Produit;
import Classes.Sortable;
import com.google.zxing.WriterException;
import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.util.List;

public abstract class DocumentProduit implements Sortable {

    private String fileName;
    private List<Produit> listeProduits;

    public abstract void creerSortie() throws DocumentException, IOException, WriterException;

    DocumentProduit(String fileName, List<Produit> listeProduits){
        this.setFileName(fileName);
        this.setListeProduits(listeProduits);
    }

    String getFileName() {
        return fileName;
    }
    private void setFileName(String fileName) {
        this.fileName = fileName;
    }

    List<Produit> getListeProduits() {
        return listeProduits;
    }
    private void setListeProduits(List<Produit> listeProduits) {
        this.listeProduits = listeProduits;
    }

}

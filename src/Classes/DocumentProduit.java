package Classes;

import com.google.zxing.WriterException;
import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.util.List;

public abstract class DocumentProduit {

    private String fileName;
    private List<Produit> listeProduits;

    protected abstract boolean creerFichierPdf() throws DocumentException, IOException, WriterException;

    public DocumentProduit(String fileName, List<Produit> listeProduits){
        this.setFileName(fileName);
        this.setListeProduits(listeProduits);
    }

    public String getFileName() {
        return fileName;
    }
    private void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<Produit> getListeProduits() {
        return listeProduits;
    }
    private void setListeProduits(List<Produit> listeProduits) {
        this.listeProduits = listeProduits;
    }
}

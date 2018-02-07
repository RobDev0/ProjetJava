package Classes;

import com.google.zxing.WriterException;
import com.itextpdf.text.DocumentException;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Produit {

    public enum CATEGORIE {
        ELECTROMENAGER, INFORMATIQUE, TELECOMMUNICATION
    }
    private CATEGORIE categorie;
    private String code;
    private String description;
    private String nom;
    private double prixHT;
    private double TVA = 20;

    public static List<Produit> getProduitByCategorie(List<Produit> allProduits, CATEGORIE categorie){
        List<Produit> produitsCat = new ArrayList<>();
        for (int i=0; i<allProduits.size(); i++){
            if (allProduits.get(i).getCategorie() == categorie){
                produitsCat.add(allProduits.get(i));
            }
        }
        return produitsCat;
    }

    public Produit(){}

    public double getTVA() {
        return TVA;
    }
    public void setTVA(double TVA) {
        this.TVA = TVA;
    }

    public CATEGORIE getCategorie() {
        return categorie;
    }
    public void setCategorie(CATEGORIE categorie) {
        this.categorie = categorie;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrixHT() {
        return prixHT;
    }
    public void setPrixHT(double prixHT) {
        this.prixHT = prixHT;
    }

    public double getPrixTTC(){
        return this.getPrixHT() + (this.getPrixHT() * this.getTVA() / 100);
    }

}

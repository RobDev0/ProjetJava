package Classes;

import com.google.zxing.WriterException;
import com.itextpdf.text.DocumentException;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Produit {

    private String categorie;
    private String code;
    private String description;
    private String nom;
    private double prixHT;
    private double TVA = 2.5;

    public Produit(){}
    public Produit(String cat, String code, String desc, String nom, double prix) {
        this.setCategorie(cat);
        this.setCode(code);
        this.setDescription(desc);
        this.setNom(nom);
        this.setPrixHT(prix);

    }

    public double getTVA() {
        return TVA;
    }
    public void setTVA(double TVA) {
        this.TVA = TVA;
    }

    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
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


public class Produit {
	private String categorie;
	private String code;
	private String description;
	private String nom;
	private double prixHT;

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
}

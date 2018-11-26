package Entites.referentiels.magasins;

public class Magasin {

	private int id;
	private String nom;
	private int idEmplacement;
	private int idType;
	private String description;
	//private ArrayList<Produit> listeProduits;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getIdEmplacement() {
		return idEmplacement;
	}
	public void setIdEmplacement(int idEmplacement) {
		this.idEmplacement = idEmplacement;
	}
	public int getIdType() {
		return idType;
	}
	public void setIdType(int idType) {
		this.idType = idType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}

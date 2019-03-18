package Entites.referentiels.campagne;

import java.sql.Date;
import java.util.ArrayList;

import Entites.referentiels.magasins.Magasin;
import Entites.referentiels.produitsVendus.Product;
import Entites.referentiels.profilsConsommateur.Profil;

public class Campaign {

	private int idCampaign;
	private String nameCampaign;
	private String typeCampaign;
	private Date startdateCampaign;
	private Date enddateCampaign;
	private ArrayList <Magasin> listMagasin;
	private ArrayList <Profil> listProfil;
	private ArrayList <Product> listProduct;
	
	public int getIdCampaign() {
		return idCampaign;
	}
	public void setIdCampaign(int idCampaign) {
		this.idCampaign = idCampaign;
	}
	public String getNameCampaign() {
		return nameCampaign;
	}
	public void setNameCampaign(String nameCampaign) {
		this.nameCampaign = nameCampaign;
	}
	public String getTypeCampaign() {
		return typeCampaign;
	}
	public void setTypeCampaign(String typeCampaign) {
		this.typeCampaign = typeCampaign;
	}
	public Date getStartdateCampaign() {
		return startdateCampaign;
	}
	public void setStartdateCampaign(Date startdateCampaign) {
		this.startdateCampaign = startdateCampaign;
	}
	public Date getEnddateCampaign() {
		return enddateCampaign;
	}
	public void setEnddateCampaign(Date enddateCampaign) {
		this.enddateCampaign = enddateCampaign;
	}
	public ArrayList<Magasin> getListMagasin() {
		return listMagasin;
	}
	public void setListMagasin(ArrayList<Magasin> listMagasin) {
		this.listMagasin = listMagasin;
	}
	public ArrayList<Profil> getListProfil() {
		return listProfil;
	}
	public void setListProfil(ArrayList<Profil> listProfil) {
		this.listProfil = listProfil;
	}
	public ArrayList<Product> getListProduct() {
		return listProduct;
	}
	public void setListProduct(ArrayList<Product> listProduct) {
		this.listProduct = listProduct;
	}
	public Campaign() { }
	public Campaign(int idCampaign, String nameCampaign, String typeCampaign, Date startdateCampaign,
			Date enddateCampaign) {
		super();
		this.idCampaign = idCampaign;
		this.nameCampaign = nameCampaign;
		this.typeCampaign = typeCampaign;
		this.startdateCampaign = startdateCampaign;
		this.enddateCampaign = enddateCampaign;
	}
	public Campaign(String nameCampaign, String typeCampaign, Date startdateCampaign, Date enddateCampaign,
			ArrayList<Magasin> listMagasin, ArrayList<Profil> listProfil, ArrayList<Product> listProduct) {
		super();
		this.nameCampaign = nameCampaign;
		this.typeCampaign = typeCampaign;
		this.startdateCampaign = startdateCampaign;
		this.enddateCampaign = enddateCampaign;
		this.listMagasin = listMagasin;
		this.listProfil = listProfil;
		this.listProduct = listProduct;
	}
	
	public Campaign(ArrayList<Magasin> listMagasin) {
		super();
		this.listMagasin = listMagasin;
	}
	
}

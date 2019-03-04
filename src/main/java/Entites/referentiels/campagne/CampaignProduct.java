package Entites.referentiels.campagne;

import java.util.List;

public class CampaignProduct {
	private int idCampaignP;
	private List<Campaign> listCampaign;
	
	public int getIdCampaignP() {
		return idCampaignP;
	}
	public void setIdCampaignP(int idCampaignP) {
		this.idCampaignP = idCampaignP;
	}
	public List<Campaign> getListCampaign() {
		return listCampaign;
	}
	public void setListCampaign(List<Campaign> listCampaign) {
		this.listCampaign = listCampaign;
	}
	public CampaignProduct() {
		super();
	}
	public CampaignProduct(List<Campaign> listCampaign) {
		super();
		this.listCampaign = listCampaign;
	}
	
}

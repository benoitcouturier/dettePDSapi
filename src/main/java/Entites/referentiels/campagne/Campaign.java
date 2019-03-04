package Entites.referentiels.campagne;

import java.sql.Date;

public class Campaign {

	private int idCampaign;
	private String nameCampaign;
	private TypeCampaign typeCampaign;
	private Date startdateCampaign;
	private Date enddateCampaign;
	
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
	public TypeCampaign getTypeCampaign() {
		return typeCampaign;
	}
	public void setTypeCampaign(TypeCampaign typeCampaign) {
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
	public Campaign() {
		super();
	}
	public Campaign(int idCampaign, String nameCampaign, TypeCampaign typeCampaign, Date startdateCampaign,
			Date enddateCampaign) {
		super();
		this.idCampaign = idCampaign;
		this.nameCampaign = nameCampaign;
		this.typeCampaign = typeCampaign;
		this.startdateCampaign = startdateCampaign;
		this.enddateCampaign = enddateCampaign;
	}
}

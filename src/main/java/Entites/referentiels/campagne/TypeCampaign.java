package Entites.referentiels.campagne;

public enum TypeCampaign {
	particulier("particulier"),
	general("general"),
	promotion("promotion");

	private String type;
	
	private TypeCampaign(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}

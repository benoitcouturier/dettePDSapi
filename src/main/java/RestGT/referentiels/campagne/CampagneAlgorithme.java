package RestGT.referentiels.campagne;

import java.util.ArrayList;

import DAO.referentiels.campagne.CampagneDAOImpl;
import Entites.referentiels.campagne.Campaign;
import Entites.referentiels.magasins.Magasin;
import Entites.referentiels.produitsVendus.Product;
import Entites.referentiels.profilsConsommateur.Profil;

public class CampagneAlgorithme {
	
	public Campaign CampagneTraitement (Campaign campagne) {
		
		CampagneDAOImpl campagneDAO = new CampagneDAOImpl();
		
		if (campagne.isNull() == false) {
			
			/*  
			 * Champ magasin non renseigné
			 * 
			 * On va retrouver les magasins qui vendent les produits spécifiés
			 * 
			 * */
			
			if (campagne.getListProduct() != null && campagne.getListProfil() != null) {
				
				try {
					campagne.setListMagasin(campagneDAO.findProductShop(campagne.getListProduct()));
				}catch(Exception e) {
					
				}
				return campagne;
			}
			
			/*  
			 * Champ type magasin = general
			 * 
			 * On ne specifie aucune liste (sinon on alourdit la BDD pour rien
			 * 
			 * */
			
			if (campagne.getTypeCampaign().getType() == "general") {
				campagne.setListProduct(new ArrayList<Product>());
				campagne.setListMagasin(new ArrayList<Magasin>());
				campagne.setListProfil(new ArrayList<Profil>());
				return campagne;
			}
			
		}
		return null;
	}
}

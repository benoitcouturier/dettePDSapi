package RestGT.referentiels.profils;
import DAO.referentiels.profilsConsommateur.ProfilDAO;
import Entites.portail.gererSonCompteClient.Customer_account;
import Entites.referentiels.profilsConsommateur.Profil;

import java.util.ArrayList;

import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

public class ProfilService {

	public Response create(Profil profil, ProfilDAO<Profil> dao) {

		if(profil.getAgeClient()!=0 && profil.getProfilT_id()!=0 && profil.getProfilT_name()!="" && profil.getSexClient()!="" && profil.getProduct_Type()!=""&&profil.getAgeClient()!=0 && profil.getProfilT_id()!=0 && profil.getProfilT_name()!=" " && profil.getSexClient()!=" " && profil.getProduct_Type()!=" ") {

			String response = new String();
			System.out.println("ok");
			try {
				dao.create(profil);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return Response.status(500).entity(e).build();
			}

			return Response.status(200).build();

		} else

			return Response.status(501).build();
	}

	public Response mockAchats(ProfilDAO<Profil> dao) throws Exception{

		dao.mockAchats();
		String []msg = {"Sucess"};
		return Response.status(200).entity(msg).build();

	}

	public Response determinationProfil(ProfilDAO<Profil> dao) {
		String response = new String();
		System.out.println("ok");
		try {
			//Select des Customer avec l'id profil a null
			ArrayList<Customer_account> customers = dao.getProfilNull();
			//Actualisation de ces Profils en fonction de leur Sexe
			for(int i = 0; i<customers.size() ; i++) {
				if(customers.get(i).getCustomer_sex().equalsIgnoreCase("Male")) {
					dao.updateProfilClient(13, customers.get(i).getId_customer());
				}else {
					dao.updateProfilClient(12, customers.get(i).getId_customer());
				}
			}
			//Selection de tous les customer et de leur ligne de commande
			
			// Moyenne des prix * qte / nbTotal = Un type de profil
			
			// INsertion de ces Profils.
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).entity(e).build();
		}

		return Response.status(200).entity("Done").build();

	}
	
	public Response getClientProfil(ProfilDAO<Profil> dao) {
		String response = new String();
		System.out.println("ok");
		try {
			String res = new String();
			ObjectMapper mapper = new ObjectMapper();
			ArrayList<Customer_account> customers = dao.getClientProfil();
			res = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customers);
			return Response.status(200).entity(res).build();		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).entity(e).build();
		}

	}
	
}
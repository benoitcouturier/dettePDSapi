package RestGT.referentiels.profils;

import DAO.referentiels.profilsConsommateur.ProfilDAO;
import Entites.referentiels.profilsConsommateur.Profil;

import javax.ws.rs.core.Response;

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

	public Response mockUser(ProfilDAO<Profil> dao) {

		String response = new String();
		System.out.println("ok");
		try {
			dao.mockUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).entity(e).build();
		}

		return Response.status(200).build();
	}
}
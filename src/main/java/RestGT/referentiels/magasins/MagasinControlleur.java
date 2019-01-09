package RestGT.referentiels.magasins;

import java.util.ArrayList;

import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import DAO.referentiels.magasins.MagasinDAOImpl;
import DAO.referentiels.magasins.MagasinsDAO;
import Entites.referentiels.magasins.Magasin;
import Entites.referentiels.magasins.RechercheVide;

public class MagasinControlleur {

	
	public Response rechercherMagasinType(int id, CallMagasin control) {

		
		String res = new String();
		// controle :
		if(!control.existType(id)) {
			return Response.status(202).entity("Pas en Base").build();
		}
		
		Magasin m = new Magasin();
		m.setIdType(id);
		try {
			ArrayList<Magasin> mag = control.rechercheType(m);
			if(mag.isEmpty()) {
				RechercheVide erreur = new RechercheVide();
				erreur.setNom("Pas de Resultat pour cette categorie");
				return Response.status(201).entity(erreur).build();
			}
			ObjectMapper mapper = new ObjectMapper();
			res = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mag);
			return Response.status(200).entity(res).build();
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return Response.status(500).entity(e).build();
		}
		
		
	}
	
	public Response rechercherMagasinNom(String nom, CallMagasin control) {

		
		String res = new String();
				
		Magasin m = new Magasin();
		m.setNom(nom);
		try {
			ArrayList<Magasin> mag = control.rechercheNom(m);
			if(mag.isEmpty()) {
				RechercheVide erreur = new RechercheVide();
				erreur.setNom("Pas de Resultat pour cette categorie");
				return Response.status(201).entity(erreur).build();
			}
			ObjectMapper mapper = new ObjectMapper();
			res = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mag);
			return Response.status(200).entity(res).build();
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return Response.status(500).entity(e).build();
		}
		
		
	}
}

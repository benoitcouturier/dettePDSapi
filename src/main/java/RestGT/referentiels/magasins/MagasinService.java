package RestGT.referentiels.magasins;

import java.util.ArrayList;

import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import DAO.referentiels.magasins.MagasinDAOImpl;
import DAO.referentiels.magasins.MagasinsDAO;
import Entites.referentiels.magasins.Magasin;
import Entites.referentiels.magasins.RechercheVide;


public class MagasinService {


	public Response rechercherMagasinType(int id,MagasinsDAO<Magasin> dao) {
		try {
			String res = new String();
			if(!dao.existType(id)) {
				return Response.status(202).entity("Pas en Base").build();
			}

			Magasin m = new Magasin();
			m.setIdType(id);
			ArrayList<Magasin> mag = dao.rechercheType(m);
			if(mag.isEmpty()) {
				RechercheVide erreur = new RechercheVide();
				erreur.setNom("Pas de resultats pour cette categorie");
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

	public Response rechercherMagasinNom(String nom, MagasinsDAO<Magasin> dao) {
		try {
			String res = new String();
			Magasin m = new Magasin();
			if(!this.controle(nom)){
				RechercheVide erreur = new RechercheVide();
				erreur.setNom("Caractere interdit");
				return Response.status(501).entity(erreur).build();
			}

			m.setNom(nom);
			ArrayList<Magasin> mag = dao.rechercheNom(m);
			if(mag.isEmpty()) {
				RechercheVide erreur = new RechercheVide();
				erreur.setNom("Pas de resultats pour ce nom");
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
	public boolean controle(String nom){
		String caractersInterdits="&�'(-�_��)=~#{[|`\\^@]}%��$�*<>\"�!:/.?,;";
		for (int i=0;i>caractersInterdits.length();i++){
			String caractere =""+caractersInterdits.charAt(i);
			if (nom.contains(caractere)){
				return false;
			}
		}
		return true;
	}
}

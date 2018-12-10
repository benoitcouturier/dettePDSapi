package RestGT.referentiels.magasins;

import java.util.ArrayList;

import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import DAO.referentiels.magasins.MagasinDAOImpl;
import DAO.referentiels.magasins.MagasinsDAO;
import Entites.referentiels.magasins.Magasin;

public class MagasinControlleur {

	
	public Response rechercherMagasin(int id) {

		String res = new String();
		MagasinsDAO<Magasin> mDAO = new MagasinDAOImpl();
		Magasin m = new Magasin();
		m.setIdType(id);
		try {
			ArrayList<Magasin> mag = mDAO.rechercheType(m);
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

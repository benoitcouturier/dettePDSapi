package RestGT.referentiels.campagne;

import javax.ws.rs.core.Response;

import DAO.referentiels.campagne.CampagneDAO;
import Entites.referentiels.campagne.Campaign;

public class CampagneService {
	
	public Response mockCampagne(CampagneDAO<Campaign> dao) throws Exception{

        dao.mockCampagne();
        return Response.status(200).entity("Success").build();

    }
}

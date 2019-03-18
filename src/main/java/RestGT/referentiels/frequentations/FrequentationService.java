package RestGT.referentiels.frequentations;
import DAO.referentiels.frequentations.FrequentationDAO;
import Entites.referentiels.frequentations.Frequentation;

import javax.ws.rs.core.Response;

public class FrequentationService {

    public Response mockFrequentation(FrequentationDAO<Frequentation> dao) throws Exception{

        dao.mockFrequentation();
        return Response.status(200).entity("Success").build();

    }
}

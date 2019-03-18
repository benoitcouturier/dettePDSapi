package RestGT.referentiels.frequentations;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import DAO.referentiels.frequentations.FrequentationDAO;
import DAO.referentiels.frequentations.FrequentationDAOImpl;
import Entites.referentiels.frequentations.Frequentation;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.codehaus.jackson.map.ObjectMapper;

@Path("/Frequentation")
public class FrequentationApiRest {

    private  FrequentationService service = new FrequentationService();
    private static final Logger log = Logger.getLogger(FrequentationApiRest.class);

    public static void init() {
        if(log.getLevel() == null) {
            BasicConfigurator.configure();
            log.setLevel(Level.DEBUG);
        }
    }




    @GET
    @Path("/mockFrequentation")
    @Produces("application/json")
    public Response mockFrequentation() {
        init();
        log.info("Methode MockFrequentation");
        FrequentationDAO<Frequentation> fDAO = new FrequentationDAOImpl();
        try {
            return service.mockFrequentation(fDAO);

        }catch(Exception e) {
            return Response.status(500).entity(e).build();
        }
    }

}

package RestGT.referentiels.profils;

import DAO.referentiels.profilsConsommateur.ProfilDAO;
import DAO.referentiels.profilsConsommateur.ProfilDAOImpl;
import Entites.referentiels.profilsConsommateur.Profil;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/Profil")
public class ProfilApiRest {


    private static final Logger log = Logger.getLogger(ProfilApiRest.class);

    public static void init() {
        if(log.getLevel() == null) {
            BasicConfigurator.configure();
            log.setLevel(Level.DEBUG);
        }
    }

    @GET
    @Path("/tous")
    @Produces("application/json")
    public Response get() {
        init();
        log.info("Methode GET");
        return null;
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(String profil) {
        log.info("Methode POST");
        ProfilDAO<Profil> pDAO = new ProfilDAOImpl();
        ObjectMapper mapper = new ObjectMapper();
        String response = new String();
        System.out.println("ok");
        try {
            Profil p = mapper.readValue(profil, Profil.class);
            pDAO.create(p);
            String res = "Profil saved :";
            log.info(res);
            response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(res);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }

        return Response.status(200).entity(response).build();
    }

}
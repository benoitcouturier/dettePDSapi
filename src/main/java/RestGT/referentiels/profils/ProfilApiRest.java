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

	private  ProfilService service = new ProfilService();
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
    public Response create(String profil) {
        log.info("Methode POST");
        ProfilDAO<Profil> pDAO = new ProfilDAOImpl();
        ObjectMapper mapper = new ObjectMapper();
        try{
            Profil p = mapper.readValue(profil, Profil.class);
           
            return service.create(p,pDAO);
        }catch (Exception e){
            return Response.status(500).entity(e).build();
        }
    }



    @GET
    @Path("/find/{name}")
    @Consumes("application/json")
    public Response find(@PathParam("name") String name) {
        ProfilDAO<Profil> pDAO = new ProfilDAOImpl();
        Profil profil = new Profil();
        ObjectMapper mapper = new ObjectMapper();
        String response = new String();
        System.out.println("ok");
        try{
            profil.setProfilT_name(name);
            pDAO.find(profil);
            log.info(response);
            response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(profil);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(200).entity(response).build();
    }
    
    
    @GET
    @Path("/mockAchats")
    @Produces("application/json")
    public Response mockUser() {
        init();
        log.info("Methode MockUser");
        ProfilDAO<Profil> pDAO = new ProfilDAOImpl();
        try {
        	return service.mockAchats(pDAO);
        	
        }catch(Exception e) {
        	return Response.status(500).entity(e).build();
        }
    }

    @GET
    @Path("/determinationProfil")
    @Produces("application/json")
    public Response determinationProfil() {
        init();
        ProfilDAO<Profil> pDAO = new ProfilDAOImpl();
        try {
        	return service.determinationProfil(pDAO);
        	
        }catch(Exception e) {
        	return Response.status(500).entity(e).build();
        }
    }
    
}
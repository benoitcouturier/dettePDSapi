package trueTest.TU.Profils;

import DAO.referentiels.profilsConsommateur.ProfilDAO;
import Entites.portail.gererSonCompteClient.Customer_account;
import Entites.referentiels.profilsConsommateur.Profil;

import java.util.ArrayList;

public class ProfilDAOStub implements ProfilDAO<Profil> {

    @Override
    public void create(Profil object) throws Exception {

        if(object.getAgeClient()<18){
            throw new Exception();

        }

    }

    @Override
    public ArrayList<Profil> read() throws Exception {
        return null;
    }

    @Override
    public void delete(Profil object) throws Exception {

    }

    @Override
    public void update(Profil object, int id) throws Exception {

    }

    @Override
    public Profil find(Profil object) throws Exception {
        return null;
    }

	@Override
	public void mockAchats() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProfilClient(int idProfil, int idClient) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Customer_account> getProfilNull() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Customer_account> getClientProfil() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

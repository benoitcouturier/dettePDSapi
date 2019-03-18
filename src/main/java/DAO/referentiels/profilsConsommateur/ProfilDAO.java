package DAO.referentiels.profilsConsommateur;

import java.util.ArrayList;

import DAO.CrudDAO;
import Entites.portail.gererSonCompteClient.Customer_account;

public interface ProfilDAO<T> extends CrudDAO<T> {

	public void mockAchats() throws Exception;
	public void updateProfilClient( int idProfil, int idClient) throws Exception;
	public ArrayList<Customer_account> getProfilNull() throws Exception;
}

package DAO.portail.gererSonCompteClient;

import java.util.ArrayList;

import DAO.CrudDAO;

public interface NotifClientDAO<T> extends CrudDAO<T> {

	public ArrayList<T> getEmplacementsDisponibles() throws Exception;
	
}

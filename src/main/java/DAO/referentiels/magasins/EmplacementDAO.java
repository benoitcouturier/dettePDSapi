package DAO.referentiels.magasins;

import java.util.ArrayList;

import DAO.CrudDAO;

public interface EmplacementDAO<T> extends CrudDAO<T> {

	public ArrayList<T> getEmplacementsDisponibles() throws Exception;
	
}

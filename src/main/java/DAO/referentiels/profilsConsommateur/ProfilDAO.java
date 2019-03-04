package DAO.referentiels.profilsConsommateur;

import DAO.CrudDAO;

public interface ProfilDAO<T> extends CrudDAO<T> {

	public void mockUser() throws Exception;
}

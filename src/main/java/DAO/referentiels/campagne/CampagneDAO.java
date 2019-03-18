package DAO.referentiels.campagne;

import DAO.CrudDAO;

public interface CampagneDAO<T> extends CrudDAO<T> {

 public void mockCampagne () throws Exception;
}
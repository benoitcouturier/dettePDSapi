package DAO;
import java.util.ArrayList;
import java.util.HashMap;

import Entites.Dossier;

public interface DossierDAO {
	
	int getNbDossier() throws Exception;
	
	HashMap<Integer, Dossier> getDossierByName(String name) throws Exception;
	ArrayList<Dossier> getAllDossier() throws Exception;
	HashMap<Integer, Dossier> getDossierByPGI(int dos_pgi) throws Exception;
	HashMap<Integer, Dossier> getDossierByFlag(int flag_id) throws Exception;
	HashMap<Integer, Dossier> getDossierByAssocie(int id_associe) throws Exception;
	HashMap<Integer, Dossier> getDossierByCloture(int cloture) throws Exception;
	ArrayList<Dossier> getDossierByAssocieAtDate(int id_associe, int date) throws Exception;
	ArrayList<Dossier> getDossierAtDate(int dos_pgi, int date) throws Exception;
	HashMap<Integer, Dossier> getDossierByNaf(String naf) throws Exception;
	HashMap<Integer, Dossier> getDossierByCollab(String nom, String prenom) throws Exception;
	HashMap<Integer, Dossier> getDossierFavoris(int user_id) throws Exception;
	HashMap<Integer, Dossier> getDossierMap() throws Exception;
	HashMap<Integer, Dossier> getUniqueDossierMap(int dosPgi) throws Exception;
	
	public HashMap<Integer,Dossier> getFiscaRecherche(String codePgi,String dosNom,String flagId,String assoNum,String etat,String nafSection,String moisDeCloture, String numCollab) throws Exception;
	public HashMap<Integer, Dossier> getDossiersPersonne(int user_id) throws Exception;
	void updateFiscaComment(int dos_pgi, String comment) throws Exception;
	
}

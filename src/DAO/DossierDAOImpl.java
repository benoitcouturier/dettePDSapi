/*package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import Entites.Dossier;


public class DossierDAOImpl implements DossierDAO
{
	

	*//**
	 * getDossierMap :
	 * 
	 * Recuperes les dossiers stockes dans la BD et les retourne sous forme de HashMap dont la cle est le num�ro PGI du dossier correspondant
	 * 
	 * 
	 * @param void
	 * @return dossierMap HashMap<Integer,Dossier>
	 * @throws Exception 
	 *//*
	
	@Override
	public HashMap<Integer, Dossier> getDossierMap() throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String request = null;
		
		HashMap<Integer, Dossier> dossierMap = new HashMap<Integer, Dossier>();
		
		DataSourceModel dsHandler = DataSourceHandler.getDataSourceClient();
		
		try {
			
			connection = dsHandler.getConnection();

			request = DataSourceHandler.getQuery(SqlTransformCleConfigurationConstantes.GET_ALLDOSSIER);

			if (logger.isDebugEnabled()) {
				logger.debug("[* REQUETE *] : getDossierByName = " + request);
			}
			
			ps = connection.prepareStatement(request);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				Dossier d = map(rs);
				dossierMap.put(d.getDosPgi(),d);
			}
			
			ps.close();
			
			
		} catch (Exception e) {
			logger.error("[* REQUEST ERROR *]= " + request);
			throw new Exception(e);
		} finally {
			dsHandler.releaseConnection();
			connection = null;
		}
	
		return dossierMap;
		
		
	}
	
	@Override
	public HashMap<Integer, Dossier> getUniqueDossierMap(int dosPgi) throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String request = null;
		
		HashMap<Integer, Dossier> dossierMap = new HashMap<Integer, Dossier>();
		
		DataSourceModel dsHandler = DataSourceHandler.getDataSourceClient();
		
		try {
			
			connection = dsHandler.getConnection();

			request = DataSourceHandler.getQuery(SqlTransformCleConfigurationConstantes.GET_DOSSIERPGI);

			if (logger.isDebugEnabled()) {
				logger.debug("[* REQUETE *] : getDossierByDOSPGI = " + request);
			}
			
			ps = connection.prepareStatement(request);
			ps.setInt(1,dosPgi);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Dossier d = map(rs);
				dossierMap.put(d.getDosPgi(),d);
			}
			
			ps.close();
			
			
		} catch (Exception e) {
			logger.error("[* REQUEST ERROR *]= " + request);
			throw new Exception(e);
		} finally {
			dsHandler.releaseConnection();
			connection = null;
		}
	
		return dossierMap;
		
		
	}
	
	
	
	@Override
	public HashMap<Integer, Dossier> getDossierByName(String name) throws Exception {
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String request = null;
		
		HashMap<Integer, Dossier> dossierMap = new HashMap<Integer, Dossier>();
		
		DataSourceModel dsHandler = DataSourceHandler.getDataSourceClient();
		
		try {
			
			connection = dsHandler.getConnection();

			request = DataSourceHandler.getQuery(SqlTransformCleConfigurationConstantes.GET_DOSSIER_BY_NAME);

			if (logger.isDebugEnabled()) {
				logger.debug("[* REQUETE *] : getDossierByName = " + request);
			}
			
			ps = connection.prepareStatement(request);
			ps.setString(1, "%"+name+"%");

			rs = ps.executeQuery();
			
			while(rs.next()) {
				Dossier d = map(rs);
				dossierMap.put(d.getDosPgi(),d);
			}
			
			ps.close();
			
			
		} catch (Exception e) {
			logger.error("[* REQUEST ERROR *]= " + request);
			throw new Exception(e);
		} finally {
			dsHandler.releaseConnection();
			connection = null;
		}
		
		
		return dossierMap;
	}
	
	
	@Override
	public ArrayList<Dossier> getAllDossier() throws Exception {
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String request = null;
		
		ArrayList<Dossier> dossierList = new ArrayList<Dossier>();
		Dossier dossier = new Dossier();
		
		DataSourceModel dsHandler = DataSourceHandler.getDataSourceClient();
		
		try {
			
			connection = dsHandler.getConnection();

			request = DataSourceHandler.getQuery(SqlTransformCleConfigurationConstantes.GET_ALLDOSSIER);

			if (logger.isDebugEnabled()) {
				logger.debug("[* REQUETE *] : getAllDossier = " + request);
			}
			
			ps = connection.prepareStatement(request);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				dossierList.add(map(rs));
			}
			
			ps.close();
			
			System.out.println("[* REQUEST getAllDossier = "+dossier.getDosNom());
			
		} catch (Exception e) {
			logger.error("[* REQUEST ERROR *] = " + request);
			throw new Exception(e);
		} finally {
			dsHandler.releaseConnection();
			connection = null;
		}
	
		
		return dossierList;
	}
	
	
	
	
	@Override
	public int getNbDossier() throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int nb= 0;
		String request = null;
		
		DataSourceModel dsHandler = DataSourceHandler.getDataSourceClient();
		
		try {
			
			connection = dsHandler.getConnection();

			request = DataSourceHandler.getQuery(SqlTransformCleConfigurationConstantes.GET_NBDOSSIER);

			if (logger.isDebugEnabled()) {
				logger.debug("[* REQUETE *] : getNBDOSSIER = " + request);
			}
			
			ps = connection.prepareStatement(request);

			rs = ps.executeQuery();
			
			rs.next();
			nb = rs.getInt(1);
			
						
		} catch (Exception e) {
			logger.error("[* REQUEST ERROR *] = " + request);
			throw new Exception(e);
		} finally {
			dsHandler.releaseConnection();
			connection = null;
		}
		
		return nb;
	}
	
	
	
	@Override
	public HashMap<Integer, Dossier> getDossierByFlag(int dos_pgi) throws Exception {
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String request = null;
		
		HashMap<Integer, Dossier> dossierMap = new HashMap<Integer, Dossier>();
		
		DataSourceModel dsHandler = DataSourceHandler.getDataSourceClient();
		
		try {
			
			connection = dsHandler.getConnection();

			request = DataSourceHandler.getQuery(SqlTransformCleConfigurationConstantes.GET_DOSSIER_BY_FLAG);

			if (logger.isDebugEnabled()) {
				logger.debug("[* REQUETE *] : getDossierByFlags = " + request);
			}
			
			ps = connection.prepareStatement(request);
			ps.setInt(1, dos_pgi);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Dossier d = map(rs);
				dossierMap.put(d.getDosPgi(),d);
			}
			
			ps.close();
			
		} catch (Exception e) {
			logger.error("[* REQUEST ERROR *] = " + request);
			throw new Exception(e);
		} finally {
			dsHandler.releaseConnection();
			connection = null;
		}
		
		return dossierMap;
	}
	
	public static String stringOfMonth(String mois) {
		
		int numMois = Integer.parseInt(mois);

		switch(numMois) {
		
			case 1:
				return "Janvier";
			case 2:
				return "Fevrier";
			case 3:
				return "Mars";
			case 4:
				return "Avril";
			case 5:
				return "Mai";
			case 6:
				return "Juin";
			case 7:
				return "Juillet";
			case 8:
				return "Aout";
			case 9:
				return "Septembre";
			case 10:
				return "Octobre";
			case 11:
				return "Novembre";
			case 12:
				return "Decembre";
			default:
				return null;
		}
	
	}


	@Override
	public HashMap<Integer, Dossier> getDossierByPGI(int dos_pgi) throws Exception {
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String request = null;
		
		HashMap<Integer, Dossier> dossierMap = new HashMap<Integer, Dossier>();
		
		DataSourceModel dsHandler = DataSourceHandler.getDataSourceClient();
		
		try {
			
			connection = dsHandler.getConnection();

			request = DataSourceHandler.getQuery(SqlTransformCleConfigurationConstantes.GET_DOSSIER_BY_PGI);

			if (logger.isDebugEnabled()) {
				logger.debug("[* REQUETE *] : getDossierByPGI = " + request);
			}
			
			ps = connection.prepareStatement(request);
			ps.setInt(1, dos_pgi);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Dossier d = map(rs);
				dossierMap.put(d.getDosPgi(),d);
			}
			
			ps.close();
			
		} catch (Exception e) {
			logger.error("[* REQUEST ERROR *] = " + request);
			throw new Exception(e);
		} finally {
			dsHandler.releaseConnection();
			connection = null;
		}
		
		return dossierMap;
	}


	@Override
	public HashMap<Integer, Dossier> getDossierByAssocie(int id_associe) throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String request = null;
		
		HashMap<Integer, Dossier> dossierMap = new HashMap<Integer, Dossier>();
		
		DataSourceModel dsHandler = DataSourceHandler.getDataSourceClient();
		
		try {
			
			connection = dsHandler.getConnection();

			request = DataSourceHandler.getQuery(SqlTransformCleConfigurationConstantes.GET_DOSSIER_BY_ASSOCIE);

			if (logger.isDebugEnabled()) {
				logger.debug("[* REQUETE *] : getDossierByAssocie = " + request);
			}
			
			ps = connection.prepareStatement(request);
			ps.setInt(1, id_associe);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Dossier d = map(rs);
				dossierMap.put(d.getDosPgi(),d);
			}
			
			ps.close();
			
		} catch (Exception e) {
			logger.error("[* REQUEST ERROR *] = " + request);
			throw new Exception(e);
		} finally {
			dsHandler.releaseConnection();
			connection = null;
		}
		
		return dossierMap;
	}


	@Override
	public ArrayList<Dossier> getDossierAtDate(int dos_pgi, int date) throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String request = null;
		
		ArrayList<Dossier> dossierList = new ArrayList<Dossier>();
		
		DataSourceModel dsHandler = DataSourceHandler.getDataSourceClient();
		
		try {
			
			connection = dsHandler.getConnection();

			request = DataSourceHandler.getQuery(SqlTransformCleConfigurationConstantes.GET_DOSSIER_AT_DATE);

			if (logger.isDebugEnabled()) {
				logger.debug("[* REQUETE *] : getDossierAtDate = " + request);
			}
			
			ps = connection.prepareStatement(request);
			ps.setInt(1, dos_pgi);
			ps.setInt(2, date);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dossierList.add(map(rs));
			}
			
			ps.close();

			
		} catch (Exception e) {
			logger.error("[* REQUEST ERROR *] = " + request);
			throw new Exception(e);
		} finally {
			dsHandler.releaseConnection();
			connection = null;
		}
		
		return dossierList;
	}


	@Override
	public void updateFiscaComment(int dos_pgi, String comment) throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		
		String request = null;
		
		DataSourceModel dsHandler = DataSourceHandler.getDataSourceClient();
		
		try {
			
			connection = dsHandler.getConnection();

			request = DataSourceHandler.getQuery(SqlTransformCleConfigurationConstantes.UPDATE_FISCA_COMMENT);

			if (logger.isDebugEnabled()) {
				logger.debug("[* REQUETE *] : UpdateFiscaComment = " + request);
			}
			
			ps = connection.prepareStatement(request);
			ps.setString(1, comment);
			ps.setInt(2, dos_pgi);
			
			
			ps.executeUpdate();
			
			ps.close();
			
			connection.commit();
			
			
		} catch (Exception e) {
			logger.error("[* REQUEST ERROR *] = " + request);
			throw new Exception(e);
		} finally {
			dsHandler.releaseConnection();
			connection = null;
		}
		
		return;
		
	}
	
	public ArrayList<Dossier> getDossierByAssocieAtDate(int id_associe, int date) throws Exception {
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String request = null;
		
		ArrayList<Dossier> dossierList = new ArrayList<Dossier>();
		
		DataSourceModel dsHandler = DataSourceHandler.getDataSourceClient();
		
		try {
			
			connection = dsHandler.getConnection();

			request = DataSourceHandler.getQuery(SqlTransformCleConfigurationConstantes.GET_DOSSIER_BY_ASSOCIE_AT_DATE);

			if (logger.isDebugEnabled()) {
				logger.debug("[* REQUETE *] : getDossierAtDate = " + request);
			}
			
			ps = connection.prepareStatement(request);
			ps.setInt(1, id_associe);
			ps.setInt(2, date);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dossierList.add(map(rs));
			}
			
			ps.close();

			
		} catch (Exception e) {
			logger.error("[* REQUEST ERROR *] = " + request);
			throw new Exception(e);
		} finally {
			dsHandler.releaseConnection();
			connection = null;
		}
		
		return dossierList;
		
		
		
	}
	


	@Override
	public HashMap<Integer, Dossier> getDossierByCloture(int cloture) throws Exception {
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String request = null;
		
		HashMap<Integer, Dossier> dossierMap = new HashMap<Integer, Dossier>();
		
		DataSourceModel dsHandler = DataSourceHandler.getDataSourceClient();
		
		try {
			
			connection = dsHandler.getConnection();

			request = DataSourceHandler.getQuery(SqlTransformCleConfigurationConstantes.GET_DOSSIER_BY_CLOTURE);

			if (logger.isDebugEnabled()) {
				logger.debug("[* REQUETE *] : getDossierByCloture = " + request);
			}
			
			ps = connection.prepareStatement(request);
			ps.setInt(1, cloture);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				Dossier d = map(rs);
				dossierMap.put(d.getDosPgi(),d);
			}
			
			ps.close();
			
			
		} catch (Exception e) {
			logger.error("[* REQUEST ERROR *]= " + request);
			throw new Exception(e);
		} finally {
			dsHandler.releaseConnection();
			connection = null;
		}
		
		
		return dossierMap;
	}


	@Override
	public HashMap<Integer, Dossier> getDossierByNaf(String naf) throws Exception {
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String request = null;
		
		HashMap<Integer, Dossier> dossierMap = new HashMap<Integer, Dossier>();
		
		DataSourceModel dsHandler = DataSourceHandler.getDataSourceClient();
		
		try {
			
			connection = dsHandler.getConnection();

			request = DataSourceHandler.getQuery(SqlTransformCleConfigurationConstantes.GET_DOSSIER_BY_NAF);

			if (logger.isDebugEnabled()) {
				logger.debug("[* REQUETE *] : getDossierByNaf = " + request);
			}
			
			ps = connection.prepareStatement(request);
			ps.setString(1, naf);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				Dossier d = map(rs);
				dossierMap.put(d.getDosPgi(),d);
			}
			
			ps.close();
			
			
		} catch (Exception e) {
			logger.error("[* REQUEST ERROR *]= " + request);
			throw new Exception(e);
		} finally {
			dsHandler.releaseConnection();
			connection = null;
		}
		
		
		return dossierMap;
	}


	@Override
	public HashMap<Integer, Dossier> getDossierByCollab(String nom, String prenom) throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String request = null;
		
		HashMap<Integer, Dossier> dossierMap = new HashMap<Integer, Dossier>();
		
		DataSourceModel dsHandler = DataSourceHandler.getDataSourceClient();
		
		try {
			
			connection = dsHandler.getConnection();

			request = DataSourceHandler.getQuery(SqlTransformCleConfigurationConstantes.GET_DOSSIER_BY_COLLAB);

			if (logger.isDebugEnabled()) {
				logger.debug("[* REQUETE *] : getDossierByCollab = " + request);
			}
			
			ps = connection.prepareStatement(request);
			ps.setString(1, nom);
			ps.setString(2, prenom);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				Dossier d = map(rs);
				dossierMap.put(d.getDosPgi(),d);
			}
			
			ps.close();
			
			
		} catch (Exception e) {
			logger.error("[* REQUEST ERROR *]= " + request);
			throw new Exception(e);
		} finally {
			dsHandler.releaseConnection();
			connection = null;
		}
		
		
		return dossierMap;
	}


	@Override
	public HashMap<Integer, Dossier> getDossierFavoris(int user_id) throws Exception {
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String request = null;
		
		HashMap<Integer, Dossier> dossierMap = new HashMap<Integer, Dossier>();
		
		DataSourceModel dsHandler = DataSourceHandler.getDataSourceClient();
		
		try {
			
			connection = dsHandler.getConnection();

			request = DataSourceHandler.getQuery(SqlTransformCleConfigurationConstantes.GET_DOSSIER_FAVORIS);

			if (logger.isDebugEnabled()) {
				logger.debug("[* REQUETE *] : getDossierByName = " + request);
			}
			
			ps = connection.prepareStatement(request);
			ps.setInt(1, user_id);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				Dossier d = map(rs);
				dossierMap.put(d.getDosPgi(),d);
			}
			
			ps.close();
			
			
		} catch (Exception e) {
			logger.error("[* REQUEST ERROR *]= " + request);
			throw new Exception(e);
		} finally {
			dsHandler.releaseConnection();
			connection = null;
		}
	
		return dossierMap;
	}
	

	protected Dossier map(ResultSet rs) throws SQLException {

		Dossier dos = new Dossier();

		dos.setDosNom(rs.getString("DOS_NOM"));
		dos.setDosPgi(rs.getInt("DOS_PGI"));
		dos.setDosPeriodicite(rs.getString("DOS_PERIODICITE"));
		dos.setDosMoisCloture(stringOfMonth(rs.getString("DOS_MOIS_CLOTURE")));
		dos.setDosFiscaComment(rs.getString("DOS_COMMENTAIRE_FISCA"));

		return dos;
		
	}
	
	@Override
	public HashMap<Integer,Dossier> getFiscaRecherche(String codePgi,String dosNom,String flagId,String assoNum,String etat,String nafSection,String moisDeCloture, String numCollab) throws Exception {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String requeteSql = null;
	
		
		HashMap<Integer, Dossier> dossierMap = new HashMap<Integer, Dossier>();

		DataSourceModel dsHandler = DataSourceHandler.getDataSourceClient();
		
		System.out.println();
		System.out.println("[ **** ENTER FISCA RECHERCHE ****]");
		System.out.println();
		
		try{
			
			connection = dsHandler.getConnection();
		
		String trueRequest = "SELECT DISTINCT D.DOS_PGI, D.DOS_NOM, D.DOS_PERIODICITE, D.DOS_MOIS_CLOTURE, D.DOS_COMMENTAIRE_FISCA FROM DOSSIER AS D";
		requeteSql = "SELECT DISTINCT D.DOS_PGI, D.DOS_NOM, D.DOS_PERIODICITE, D.DOS_MOIS_CLOTURE, D.DOS_COMMENTAIRE_FISCA FROM DOSSIER AS D";
		
		
			if( assoNum != null) {
				requeteSql += " JOIN UTILISATEUR_CEGID AS UC ON UC.USRCEGID_ID = D.USRCEGID_ID";
				requeteSql += " JOIN UTILISATEUR AS U ON U.USR_ID = UC.USR_ID";
			}
			if(flagId!=null) {
				requeteSql += " JOIN FLAG_DOSSIER FD ON FD.DOS_PGI = D.DOS_PGI";
			}
			if(numCollab!=null) {
				requeteSql += " JOIN HEURE_DOSSIER HD ON HD.DOS_PGI = D.DOS_PGI \n" + 
						"LEFT JOIN UTILISATEUR_CEGID UC# ON UC#.USRCEGID_ID = HD.USRCEGID_ID \n" + 
						"JOIN UTILISATEUR U# ON U#.USR_ID = UC#.USR_ID \n" + 
						"JOIN USR_NOMPRENOM UN# ON UN#.USR_ID = U#.USR_ID  ";
			}
			if(nafSection!=null) {
				requeteSql += " JOIN CODE_NAF CN ON CN.NAF_ID = D.NAF_ID";
			}

			requeteSql +="\n ";
			requeteSql +="where ";
			int indice =0;
			// ecriture de la requete en fonction des parametre entrés
			if(codePgi !=null) {
				if(indice !=0) {
					requeteSql+=" and ";
				}
				requeteSql += "D.DOS_PGI like ? ";
				indice++;
				codePgi = "%"+codePgi+"%";
			}
			if(dosNom !=null) {
				if(indice !=0) {
					requeteSql+=" and ";
				}
				requeteSql += "D.DOS_NOM like ? ";
				indice++;
				dosNom="%"+dosNom+"%";
			}
			if(flagId !=null) {
				if(indice !=0) {
					requeteSql+=" and ";
				}
				requeteSql += " FD.FLAG_ID = ? ";
				indice++;
				// parse Int
			}
			if(assoNum !=null) {
				if(indice !=0) {
					requeteSql+=" and ";
				}
				requeteSql += " U.USR_ID = ? ";
				indice++;
				// parse Int 
			}

			if(etat !=null) {
				if(indice !=0) {
					requeteSql+=" and ";
				}
				requeteSql += " D.DOS_ETAT like ? ";
				indice++;
				etat="%"+etat+"%";
			}
			if(nafSection !=null) {
				if(indice !=0) {
					requeteSql+=" and ";
				}
				requeteSql += " CN.NAFSECTION_ID like ? ";
				indice++;
				nafSection = "%"+nafSection+"%";
			}
			if(moisDeCloture !=null) {
				if(indice !=0) {
					requeteSql+=" and ";
				}
				requeteSql += " D.DOS_MOIS_CLOTURE =? ";
				indice++;
				// parse Int
			}
			if(numCollab !=null) {
				if(indice !=0) {
					requeteSql+=" and ";
				}
				requeteSql += " UN#.NOMPRENOM LIKE ? \n" ;
				indice++;
				numCollab="%"+numCollab+"%";
			}


			int indiceRequete =1;

			if(codePgi==null && dosNom==null && flagId==null && assoNum==null && numCollab==null && etat==null && nafSection==null && moisDeCloture==null) {
				requeteSql = new String();
				requeteSql = trueRequest;
				System.out.print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

			}
			
			pstmt = connection.prepareStatement(requeteSql);
		

			if(codePgi!=null) {
				pstmt.setString(indiceRequete++, codePgi);
				System.out.print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!dospgi!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
			if(dosNom!=null) {
				pstmt.setString(indiceRequete++, dosNom);
				System.out.print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!dosnom + " + dosNom);
			}
			if(flagId!=null) {
				pstmt.setInt(indiceRequete++, Integer.parseInt(flagId));
				System.out.print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!flag!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
			if(assoNum!=null) {
				pstmt.setInt(indiceRequete++, Integer.parseInt(assoNum));
				System.out.print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!assonum!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
			if(etat!=null) {
				pstmt.setString(indiceRequete++, etat);
				System.out.print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!etat" + etat);
			}
			if(nafSection!=null) {
				pstmt.setString(indiceRequete++, nafSection);
				System.out.print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!naf!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
			if(moisDeCloture!=null) {
				pstmt.setInt(indiceRequete++, Integer.parseInt(moisDeCloture));
				System.out.print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!moisclot!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
			if(numCollab!=null) {
				pstmt.setString(indiceRequete++, numCollab);
				System.out.print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!numcollab!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Dossier d = map(rs);
				dossierMap.put(d.getDosPgi(),d);
			}
			
			pstmt.close();
			
		} catch (Exception e) {
			logger.error("[* REQUEST ERROR *]= " + requeteSql);
			throw new Exception(e);
		} finally {
			dsHandler.releaseConnection();
			connection = null;
		}
	
		return dossierMap;
	}
			
	@Override
	public HashMap<Integer, Dossier> getDossiersPersonne(int user_id) throws Exception {
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String request = null;
		
		HashMap<Integer, Dossier> dossierMap = new HashMap<Integer, Dossier>();
		
		DataSourceModel dsHandler = DataSourceHandler.getDataSourceClient();
		
		try {
			
			connection = dsHandler.getConnection();

			request = DataSourceHandler.getQuery(SqlTransformCleConfigurationConstantes.GET_DOSSIERS_PERSONNE);

			if (logger.isDebugEnabled()) {
				logger.debug("[* REQUETE *] : getDossierByName = " + request);
			}
			
			ps = connection.prepareStatement(request);
			ps.setInt(1, user_id);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				Dossier d = map(rs);
				dossierMap.put(d.getDosPgi(),d);
			}
			
			ps.close();
			
			
		} catch (Exception e) {
			logger.error("[* REQUEST ERROR *]= " + request);
			throw new Exception(e);
		} finally {
			dsHandler.releaseConnection();
			connection = null;
		}
	
		return dossierMap;
	}	
			
	
	
}

	
*/
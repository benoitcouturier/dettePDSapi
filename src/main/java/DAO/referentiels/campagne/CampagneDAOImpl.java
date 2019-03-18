package DAO.referentiels.campagne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DataBase.Database;
import Entites.referentiels.campagne.Campaign;
import Entites.referentiels.campagne.TypeCampaign;
import Entites.referentiels.magasins.Magasin;
import Entites.referentiels.produitsVendus.Product;

public class CampagneDAOImpl implements CampagneDAO<Campaign>  {
	@Override
	public void create(Campaign campagne) throws Exception {
		Connection connect;
		PreparedStatement st;
		ResultSet rs = null;
		int idCampaign = 0;

		try {

			/* Insertion dans la table Campaign */
			connect= Database.getConnection();
			String sql = "INSERT IGNORE INTO Campaign VALUES (NULL,?,?,?,?)";
			st = connect.prepareStatement(sql);
			st.setString(1,campagne.getNameCampaign());
			st.setString(2, campagne.getTypeCampaign());
			st.setDate(3, campagne.getStartdateCampaign());
			st.setDate(4, campagne.getEnddateCampaign());
			st.executeUpdate();

			connect.commit();

			/* Récupérer l'id de la campagne provenant de l'autoincrement */

			sql = "Select LAST_INSERT_ID() ID";
			st = connect.prepareStatement(sql);
			rs = st.executeQuery(sql);

			if(rs.first()) {
				idCampaign = rs.getInt("ID");
			}	

			/* Insérer la liste de magasin dans la table CampaignStore */

			for (int i=0; i < campagne.getListMagasin().size(); i++) {
				sql = "INSERT INTO CampaignStore VALUES (NULL,?,?)";
				st = connect.prepareStatement(sql);
				st.setInt(1,idCampaign);
				st.setInt(2, campagne.getListMagasin().get(i).getId());
				st.executeUpdate();

				connect.commit();
			}
			
			/* Insérer la liste de produits dans la table CampaignProduct */

			for (int i=0; i < campagne.getListProduct().size(); i++) {
				sql = "INSERT INTO CampaignProduct VALUES (NULL,?,?)";
				st = connect.prepareStatement(sql);
				st.setInt(1,idCampaign);
				st.setInt(2, campagne.getListProduct().get(i).getPid());
				st.executeUpdate();

				connect.commit();
			}
			
			/* Insérer la liste des profils dans la table CampaignTargetedProfile */

			for (int i=0; i < campagne.getListProfil().size(); i++) {
				sql = "INSERT INTO CampaignTargetedProfile VALUES (NULL,?,?)";
				st = connect.prepareStatement(sql);
				st.setInt(1,idCampaign);
				st.setInt(2, campagne.getListProfil().get(i).getNumProfil());
				st.executeUpdate();

				connect.commit();
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public ArrayList<Campaign> read() throws Exception {

		Connection connect;
		PreparedStatement ps ;
		ResultSet rs;
		ArrayList<Campaign> listCampaign = new ArrayList<Campaign>();
		
		try {
			
			connect = Database.getConnection();
			
			String sql = "Select * from Campaign";
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Campaign campaign = new Campaign();
				campaign.setIdCampaign(rs.getInt("idCampaign"));
				campaign.setTypeCampaign(rs.getString("typeCampaign"));
				campaign.setNameCampaign(rs.getString("nameCampaign"));
				campaign.setStartdateCampaign(rs.getDate("startdateCampaign"));
				campaign.setEnddateCampaign(rs.getDate("enddateCampaign"));

				listCampaign.add(campaign);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCampaign;
	}

	@Override
	public void delete(Campaign campagne) throws Exception {

	}

	@Override
	public void update(Campaign campagne, int id) throws Exception {

	}

	@Override
	public Campaign find(Campaign campagne) throws Exception {
		return null;
	}
	
	/**** Recupere les magasins qui possèdent les produits ****/
	
	public ArrayList<Magasin> findProductShop(ArrayList<Product> listProduit) throws Exception {
		Connection connect;
		PreparedStatement ps ;
		ResultSet rs;
		ArrayList<Magasin> magasins = new ArrayList<Magasin>();
		try {
			
			connect = Database.getConnection();
			for (int i=0; i<listProduit.size();i++) {
			String sql = "Select * from Magasins m, Product p "
					+ "where p.store_id = m.id "
					+ "and p.product_id = ?";
			ps = connect.prepareStatement(sql);
			ps.setInt(1, listProduit.get(i).getPid());
			rs = ps.executeQuery();
			while(rs.next()) {
				Magasin m = new Magasin();
				m.setDescription(rs.getString("description"));
				m.setId(rs.getInt("id"));
				m.setIdType(rs.getInt("idType"));
				m.setNom(rs.getString("nom"));

				magasins.add(m);
			}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return magasins;
	}

}

package DAO.referentiels.administrateur.campagne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import DataBase.Database;
import Entites.referentiels.campagne.Campaign;

public class CampagneDAOImpl implements CampagneDAO<Campaign>  {
	@Override
    public void create(Campaign campagne) throws Exception {

        Connection connect;
        PreparedStatement st;

        try {

            connect= Database.getConnection();
            String sql = "INSERT INTO Campaign VALUES(NULL,?,?,?,?)";
            st = connect.prepareStatement(sql);
            st.setString(1,campagne.getNameCampaign());
            st.setString(2, campagne.getTypeCampaign().getType());
            st.setDate(3, campagne.getStartdateCampaign());
            st.setDate(4, campagne.getEnddateCampaign());
            st.executeUpdate();


        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Campaign> read() throws Exception {


        Connection connect;
        PreparedStatement st;

        try {

            connect= Database.getConnection();
            String sql = "SELECT* FROM Campaign";
            st = connect.prepareStatement(sql);
            st.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void delete(Campaign campagne) throws Exception {

    }

    @Override
    public void update(Campaign campagne, int id) throws Exception {

    }

    @Override
    public Campaign find(Campaign campagne) throws Exception {

        /*Connection connect;
        PreparedStatement st;
        ResultSet rs;

        try {

            connect= Database.getConnection();
            String sql= "SELECT * FROM Campaign WHERE nameCampaign = ?";
            st = connect.prepareStatement(sql);
            st.setString(1, campagne.getNameCampaign());
            rs = st.executeQuery();
            while(rs.next()) {
                campagne.setIdCampaign(rs.getInt("idCampaign"));
                campagne.setNameCampaign(rs.getString("nameCampaign"));
                campagne.setTypeCampaign(rs.getString("typeCampaign"));
            }
            st.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }*/
    	return null;
}
}
